<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 - 캠페인</title>
<link href="css/button.css" rel="stylesheet">
<style type="text/css">
#listBar {
	text-align: center;
}
@font-face {
    font-family: 'HallymGothic-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2204@1.0/HallymGothic-Regular.woff2') format('woff2');
    font-weight: 400;
    font-style: normal;
}

</style>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		// 캠페인 리스트 확인 시 1번 캠페인 출력
		$.ajax({
			type: "post",
			url: "CampaignDetail.cp",
			data: {
				cam_idx: 1
			},
			dataType: "text",
			success: function(response) {
				$("#detailView").html(response);
			}
		});
		
		// 캠페인 제목 클릭 시 해당 캠페인 내용 출력
		$(".cam_subject").on("click", function() {
			$.ajax({
				type: "post",
				url: "CampaignDetail.cp",
				data: {
					cam_idx: $(".cam_idx").eq($(".cam_subject").index(this)).html()
				},
				dataType: "text",
				success: function(response) {
					$("#detailView").html(response);
				}
			});
		});
	});
	
	
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
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<section class="outer">
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
	</section>
	<div class="button-list">
	 <button class="button-left">← Left</button>
	 <button class="button-right">Right →</button>
	</div>
	
	<div style="height: 50px"></div>
	<c:choose>
		<c:when test="${empty campaignList }">
			<h1>현재 진행중인 캠페인이 없습니다.</h1>
		</c:when>
		<c:otherwise>
			<section id="listBar">
				<c:forEach var="cam" items="${campaignList }">
					<button class="w-btn-outline w-btn-green-outline">${cam.cam_subject }</button>
					<span class="cam_idx" hidden="">${cam.cam_idx }</span>
				</c:forEach>
			</section>
			<section id="detailView"></section>
			
		</c:otherwise>	
	</c:choose>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>