<%@page import="vo.store.StoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>treeEarth</title>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	
	$(function() {
		// 상품 후기 버튼 => 비회원 작성 시도 시 로그인 창 open 및 로그인 후 회원만 후기 작성 가능
		$("#review_btn").on("click", function() {
			if(${empty sessionScope.sId}) {
				alert("로그인이 필요한 기능입니다.");
				window.open("MemberLoginForm.me?returnUrl=StoreReviewList.st", "", "width=400, height=600");
			} else {
				location.href="StoreReviewWriteForm.st?sto_idx=${store.sto_idx}";
			}
		});
		
		// 후기 별점 출력
		for(var k = 0; k < ${storeReviewList.size()}; k++) {
			var i = $(".score").eq(k).html();
// 			alert(i);
			if(i == 4) { // 별점이 4점일 경우 class명이 rate5인 별 하나 숨김처리
				$(".rate5").eq(k).css({
					color: "transparent"
				});
			} 
			if(i == 3) {
				$(".rate4").eq(k).css({
					color: "transparent"
				});
				$(".rate5").eq(k).css({
					color: "transparent"
				});
			}
			if(i == 2) {
				$(".rate3").eq(k).css({
					color: "transparent"
				});
				$(".rate4").eq(k).css({
					color: "transparent"
				});
				$(".rate5").eq(k).css({
					color: "transparent"
				});
			}
			if(i == 1) {
				$(".rate2").eq(k).css({
					color: "transparent"
				});
				$(".rate3").eq(k).css({
					color: "transparent"
				});
				$(".rate4").eq(k).css({
					color: "transparent"
				});
				$(".rate5").eq(k).css({
					color: "transparent"
				});
			}
		}
	});
</script>
<link href="css/store.css" rel="stylesheet">
<style type="text/css">
fieldset {
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    border: 0; /* 필드셋 테두리 제거 */
    width: 100%;
    text-align: left; 
    margin:5px 0;
    padding-left: 2px;
}

.st {
    font-size: 1em; /* 이모지 크기 */
}

fieldset legend {
	text-align: left;
}
</style>
</head>
<body>
	
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	
	<!-- 게시판 리스트 -->
	<div class="main">
	
	 	<hr>
	 			<!-- 스토어 후기 타이틀-->
				<div class="r_sto_title">
					<span>구매 후기</span>
				</div>

				<!-- 글쓰기 -->
				<div class="r_sto_title_button">
<!-- 					<button id="review_btn"><img src="img/community/pencil.png" width="47px" height="50px">후기 작성하기</button> -->
					<button id="review_btn">후기 작성하기</button>
				</div>
		 <hr>
				<!-- 게시판 구별 -->
				<div >
					<span class="r_sto_subject">상품</span>
					<span class="r_sto_content">내용</span>
					<span class="r_sto_name">작성자</span>
					<span class="r_sto_date">작성일</span>
				</div>
		 <hr>

		<!-- 게시판 내용 -->
		<div >
			<c:choose>
				<c:when test="${not empty storeReviewList and pageInfo.itemListCount gt 0}">
					<c:forEach var="store_review" items="${storeReviewList }">
						
						<!-- 제목 -->
						<div class="r_sto_subject">
							
							<a href='StoreReviewDetail.st?sto_idx=${store.sto_idx}&sto_re_idx=${store_review.sto_re_idx }&pageNum=${pageInfo.pageNum}'>
							<c:choose>
								<c:when test="${not empty store_review.sto_re_file}"> 
									<img class="r_sto_img" alt="" src="img/store/${store_review.sto_re_file }">
								</c:when>
								<c:otherwise>
									<img alt="기본 이미지" src="img/store/store_reivew_d.png" class="sto_rev_im">
								</c:otherwise>
							</c:choose>
							</a>

							<div class="score">${store_review.sto_re_score }</div> <!-- 상품후기 별점 출력 -->
							<fieldset>
								<span class="rate1" id="st">⭐</span>
								<span class="rate2" id="st">⭐</span>
								<span class="rate3" id="st">⭐</span>
								<span class="rate4" id="st">⭐</span>
								<span class="rate5" id="st">⭐</span>
							</fieldset>
						</div>
					
						<div >	
							<!-- 내용 -->
							<div class="r_sto_content">
								<a href='StoreReviewDetail.st?sto_idx=${store.sto_idx}&sto_re_idx=${store_review.sto_re_idx }&pageNum=${pageInfo.pageNum}'>${store_review.sto_re_content }</a>
							</div>
							
							<!-- 작성자 -->	
							<div class="r_sto_name">
								${store_review.mem_id }
							</div>	
							
							<!-- 작성일 -->	
							<div class="r_sto_date">
								${store_review.sto_re_date }
							</div>	
						</div>
						 <hr>
					</c:forEach>
				</c:when>

				<c:otherwise>
					<h2><b>후기가 없습니다.</b><br></h2>
					<h3>후기를 작성해 보세요!</h3>
				</c:otherwise>
			</c:choose>
		</div>	
	</div>

	<br>
	<div style="clear: both;">
	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='StoreReviewList.st?sto_idx=${store.sto_idx }&pageNum=${pageInfo.pageNum - 1}'">
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
					<a href="StoreReviewList.st?sto_idx=${store.sto_idx }&pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='StoreReviewList.st?sto_idx=${store.sto_idx }&pageNum=${pageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>





