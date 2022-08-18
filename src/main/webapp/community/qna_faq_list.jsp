<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/faq.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script src="js/TweenMax.js"></script>
<script type="text/javascript">

var qnaNum = -1;

$(document).ready(function(){
	$('.qa_li .question').click(function(){
		
		q = $(".qa_li .question").index(this);
        
		if(q!=qnaNum){
			$('.qa_li .answer').stop(true, true).slideUp(400);
			$('.qa_li').removeClass('open');
			TweenMax.to($('.qa_li .question').eq(qnaNum).find('.iconDiv'), 0.4, {rotation:0});
			qnaNum = q;
			$('.qa_li').eq(qnaNum).addClass('open');
			$('.qa_li .answer').eq(qnaNum).stop(true, true).slideDown(400);
			TweenMax.to($('.qa_li .question').eq(qnaNum).find('.iconDiv'), 0.4, {rotation:0});
            
		}else{
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

	<h1>자주 묻는 질문</h1>
	
	<br>
	
	<ul class="listWrap">
		<c:choose>
			<c:when test="${not empty qnaFaqList and pageInfo.itemListCount gt 0 }">
				<c:forEach var="qnafaq" items="${qnaFaqList }">
					<li class="qa_li">
						<div class="question">
				            <p class="tit">${qnafaq.faq_subject }</p>
				            <p class="iconDiv"><img src="https://happyjung.diskn.com/data/lecture/icon_jquery_faq2_icon_arrow.png"></p>
				        </div>
				        <div class="answer">
				        	${qnafaq.faq_content }
				        	<c:choose>
				        		<c:when test="${sessionScope.sId eq 'admin'}">
					        		<input id="deleteBtn" type="button" value="삭제" onclick="location.href='QnaFaqDeleteForm.cm?faq_idx=${qnafaq.faq_idx}'">
				        		</c:when>
				        	</c:choose>
				        </div>
					</li>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h2>게시물이 존재하지 않습니다.</h2>
			</c:otherwise>
		</c:choose>
	</ul>
	
	<br>
	
	<c:choose>
		<c:when test="${sessionScope.sId eq 'admin'}">
			<input type="button" value="글쓰기" onclick="location.href='QnaFaqWriteForm.cm'">
		</c:when>
	</c:choose>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->

</body>
</html>