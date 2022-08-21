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
		for(var k = 0; k < ${storeReviewList.size()}; k++) {
			var i = $(".score").eq(k).html();
// 			alert(i);
			if(i == 4) {
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
<link href="../css/index.css" rel="stylesheet">
<link rel="stylesheet" href="css/star.css">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	<section id="">
		<h3>상품후기 목록</h3> 
		<h1>${store.sto_idx }</h1> <!-- 확인용 - 나중에 삭제!! -->
			<c:choose>
				<c:when test="${not empty storeReviewList and pageInfo.itemListCount gt 0}">
					<c:forEach var="store_review" items="${storeReviewList }">
						<table>
						<tr>
							<td colspan="3">
									<c:choose>
										<c:when test="${not empty store_review.sto_re_file}"> 
											<img alt="" src="upload/${store_review.sto_re_file }" width="300" height="250"> 
										</c:when>
<%-- 										<c:otherwise> --%>
<%-- 											<img alt="상품 이미지" src="img/store/${store.sto_thum_file}" width="100" height="100"> --%>
<%-- 										</c:otherwise> --%>
									</c:choose>
							</td>
						</tr>
						<tr>
							<td>${store_review.mem_id }님의 후기입니다.</td><td>&nbsp;&nbsp;&nbsp;&nbsp;작성 날짜</td>
						</tr>
						<tr>
							<td class="score">${store_review.sto_re_score }</td>
						</tr>
						</table>
						<fieldset>
							<span class="rate1">⭐</span>
							<span class="rate2">⭐</span>
							<span class="rate3">⭐</span>
							<span class="rate4">⭐</span>
							<span class="rate5">⭐</span>
						</fieldset>
						<table>
						<tr>
							<td>
							<b>${store_review.sto_re_content }</b>
							</td>
							<td>
							<span onclick="location.href='StoreReviewDetail.st?sto_idx=${store.sto_idx}&sto_re_idx=${store_review.sto_re_idx }&pageNum=${pageInfo.pageNum}'" style="cursor: pointer;">후기 상세보기</span>
							</td>
<!-- 							<td> -->
<%-- 							<input type="button" value="수정" onclick="location.href='StoreReviewModifyForm.st?sto_re_idx=${store_review.sto_re_idx}&pageNum=${param.pageNum}'"> --%>
<%-- 							<input type="button" value="삭제" onclick="location.href='StoreReviewDeleteForm.st?sto_re_idx=${store_review.sto_re_idx}&pageNum=${param.pageNum}'"> --%>
<!-- 							</td> -->
						</tr>
						</table>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h2><b>후기가 없습니다.</b><br></h2>
					<h3>후기를 작성해 보세요!</h3>
				</c:otherwise>
			</c:choose>
	</section>
	<br>
	<section id="buttonArea">
		<input type="button" value="후기 작성하기" onclick="location.href='StoreReviewWriteForm.st?sto_idx=${store.sto_idx}'">
	</section>
	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='StoreReviewList.st?pageNum=${pageNum - 1}'">
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
					<a href="StoreReviewList.st?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='StoreReviewList.st?pageNum=${pageNum + 1}'">
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





