<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="css/mainBanner.css" rel="stylesheet">

	<script type="text/javascript">
	
	/*
	  div사이즈 동적으로 구하기
	*/
	const outer = document.querySelector('.outer');
	const innerList = document.querySelector('.inner-list');
	const inners = document.querySelectorAll('.inner');
	let currentIndex = 0; // 현재 슬라이드 화면 인덱스

	inners.forEach((inner) => {
	  inner.style.width = `${outer.clientWidth}px`; // inner의 width를 모두 outer의 width로 만들기
	})

	innerList.style.width = `${outer.clientWidth * inners.length}px`; // innerList의 width를 inner의 width * inner의 개수로 만들기

	/*
	  버튼에 이벤트 등록하기
	*/
	const buttonLeft = document.querySelector('.button-left');
	const buttonRight = document.querySelector('.button-right');

	buttonLeft.addEventListener('click', () => {
	  currentIndex--;
	  currentIndex = currentIndex < 0 ? 0 : currentIndex; // index값이 0보다 작아질 경우 0으로 변경
	  innerList.style.marginLeft = `-${outer.clientWidth * currentIndex}px`; // index만큼 margin을 주어 옆으로 밀기
	});

	buttonRight.addEventListener('click', () => {
	  currentIndex++;
	  currentIndex = currentIndex >= inners.length ? inners.length - 1 : currentIndex; // index값이 inner의 총 개수보다 많아질 경우 마지막 인덱스값으로 변경
	  innerList.style.marginLeft = `-${outer.clientWidth * currentIndex}px`; // index만큼 margin을 주어 옆으로 밀기
	});
	
	</script>


<div class="outer">
  <div class="inner-list">
  
    <div class="inner">
      <h2>first...</h2>
    </div>
    
    <div class="inner">
      <h2>second...</h2>
    </div>
    
    <div class="inner">
      <h2>third...</h2>
    </div>
    
  </div>
</div>

<div class="button-list">
  <button class="button-left">← Left</button>
  <button class="button-right">Right →</button>
</div>
	
	
