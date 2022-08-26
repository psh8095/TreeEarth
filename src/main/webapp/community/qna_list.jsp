<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/button.css" rel="stylesheet">
<link href="css/qna.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script src="js/TweenMax.js"></script>
<script type="text/javascript">

	// 질문번호 초기화
	var qnaNum = -1;
	
	$(function(){
		//답변 스르륵
		$('.qa_li .question').click(function(){
			
			q = $(".qa_li .question").index(this); //몇번째 질문인지
	        
			if(q!=qnaNum){ // Q눌렀을 때 A 스르륵
				$('.qa_li .answer').stop(true, true).slideUp(400); // 현재 스르륵 내려와 있는곳 다시 올리기
				$('.qa_li').removeClass('open'); // open 제거
				TweenMax.to($('.qa_li .question').eq(qnaNum).find('.iconDiv'), 0.4, {rotation:0}); // 0.4초동안 스르륵
				qnaNum = q; //질문번호 몇번째인지
				$('.qa_li').eq(qnaNum).addClass('open'); // open 클래스 추가
				$('.qa_li .answer').eq(qnaNum).stop(true, true).slideDown(400); // 내가 누른 질문 스르륵 내려오기
				TweenMax.to($('.qa_li .question').eq(qnaNum).find('.iconDiv'), 0.4, {rotation:0}); //0.4초동안 스르륵
	            
			}else{ //q없을때(dafault)
				$('.qa_li .answer').eq(qnaNum).stop(true, true).slideUp(400);
				$('.qa_li').eq(qnaNum).removeClass('open');
				TweenMax.to($('.qa_li').eq(qnaNum).find('.question p'), 0.4, {rotation:0});
				qnaNum = -1;
			}
		});
	});
	
</script>
</head>
<body>
	
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<div class="qna_category" style="text-align: center;">
		<button class="w-btn-green-outline w-btn-outline" onclick="location.href='QnaList.cm?qna_tag=faq'">자주묻는질문</button>
		<button class="w-btn-green-outline w-btn-outline" onclick="location.href='QnaList.cm?qna_tag=delivery'">배송문의</button>
		<button class="w-btn-green-outline w-btn-outline" onclick="location.href='QnaList.cm?qna_tag=change'">교환/반품문의</button>
		<button class="w-btn-green-outline w-btn-outline" onclick="location.href='QnaList.cm?qna_tag=store'">상품문의</button>
		<button class="w-btn-green-outline w-btn-outline" onclick="location.href='QnaList.cm?qna_tag=etc'">기타문의</button>
	</div>
	
	<h1>목록</h1>
	
	<br>
	
	<section>
		<ul class="listWrap">
			<c:choose>
				<c:when test="${not empty qnaList and pageInfo.itemListCount gt 0 }">
					<c:forEach var="qna" items="${qnaList}">
						<li class="qa_li">
							<div class="question">
					            <p class="tit">${qna.qna_subject }</p>
					            <p class="iconDiv"><img src="https://happyjung.diskn.com/data/lecture/icon_jquery_faq2_icon_arrow.png"></p>
					        </div>
					        <div class="answer">
					        	${qna.qna_content }
					        	<input id="deleteBtn" type="button" value="삭제" onclick="location.href='QnaDeleteForm.cm?qna_idx=${qna.qna_idx}'">
					        </div>
						</li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>문의글이 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</ul>
	</section>
	
	<c:choose>
		<c:when test="${not empty sessionScope.sId}">
			<input type="button" value="글쓰기" id="writeBtn" onclick="location.href='QnaWriteForm.cm'">
		</c:when>
	</c:choose>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->

</body>
</html>