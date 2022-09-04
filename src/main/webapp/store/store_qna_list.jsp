<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>treeEarth</title>
<link href="css/qna.css" rel="stylesheet">
<link href="css/store.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script src="js/TweenMax.js"></script>
<script type="text/javascript">
	
	// 문의 번호 초기화
	var qnaNum = -1;
	
	$(function() {
		// 문의 답변 스르륵
		$('.qa_li .question').click(function() {
			
			q = $(".qa_li .question").index(this);
			
			if(q != qnaNum) { // Q눌렀을 때 답변 스르륵 동작
				$('.qa_li .answer').stop(true, true).slideUp(400);
				$('.qa_li').removeClass('open');
				TweenMax.to($('.qa_li .question').eq(qnaNum).find('.iconDiv'), 0.4, {rotation:0});
				qnaNum = q;
				$('.qa_li').eq(qnaNum).addClass('open');
				$('.qa_li .answer').eq(qnaNum).stop(true, true).slideDown(400);
				TweenMax.to($('.qa_li .question').eq(qnaNum).find('.iconDiv'), 0.4, {rotation:0});
			} else {
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
	
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	
		<h3>상품 문의 목록</h3> 
		<br>
			<div>
				<ul class="listWrap">
					<c:choose>
						<c:when test="${not empty storeQnaList and pageInfo.itemListCount gt 0}">
							<c:forEach var="store_qna" items="${storeQnaList }">
								<li class="qa_li">
									<div class="question">
										<p class="tit">${store_qna.mem_id }님의 문의입니다.</p><p>&nbsp;&nbsp;&nbsp;&nbsp;${store_qna.sto_qna_date }</p>
										<p class="iconDiv"><img src="https://happyjung.diskn.com/data/lecture/icon_jquery_faq2_icon_arrow.png"></p>
									</div>
									<div class="answer">
										${store_qna.sto_qna_content }
										<input type="button" id="modifyBtn" value="문의 수정" onclick="location.href='StoreQnaModifyForm.st?sto_idx=${store_qna.sto_idx}&sto_qna_idx=${store_qna.sto_qna_idx}&pageNum=${param.pageNum}'">
										<input type="button" id="deleteBtn" value="문의 삭제" onclick="location.href='StoreQnaDeleteForm.st?sto_idx=${store_qna.sto_idx}&sto_qna_idx=${store_qna.sto_qna_idx}&pageNum=${param.pageNum}'">
<%-- 									<span style="display:block;margin-top: 20px; cursor:pointer;" onclick="location.href='StoreQnaDetail.st?sto_qna_idx=${store_qna.sto_qna_idx }&pageNum=${pageInfo.pageNum}'">&lt;문의 보기&gt;</span> --%>
									</div>
								</li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h2><b>문의 내역이 없습니다.</b></h2>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
	
		<c:choose>
			<c:when test="${not empty sessionScope.sId}">
				<input type="button" id="store_qna_btn" value="문의 작성하기" onclick="location.href='StoreQnaWriteForm.st?sto_idx=${store.sto_idx}'">
			</c:when>
		</c:choose>
		
	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='StoreQnaList.st?sto_idx=${store.sto_idx }&pageNum=${pageInfo.pageNum-1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>
			
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<c:choose>
				<c:when test="${pageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="StoreQnaList.st?sto_idx=${store.sto_idx }&pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='StoreQnaList.st?sto_idx=${store.sto_idx }&pageNum=${pageInfo.pageNum+1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>