<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>treeEarth</title>
<link href="../css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	<section id="">
		<h3>상품후기 목록</h3> 
		<h1>${store.sto_idx }</h1>
			<c:choose>
				<c:when test="${not empty storeReviewList and pageInfo.itemListCount gt 0}">
					<c:forEach var="store_review" items="${storeReviewList }">
						<table>
						<tr>
							<td colspan="3">
								<span onclick="location.href='StoreReviewDetail.st?sto_re_idx=${store_review.sto_re_idx }&pageNum=${pageInfo.pageNum}'" style="cursor: pointer;" onfocus="blur();"></span>
									<c:choose>
										<c:when test="${not empty store_review.sto_re_file}"> 
											<img alt="" src="upload/${store_review.sto_re_file }"> 
										</c:when>
									</c:choose>
							</td>
						</tr>
						<tr>
							<td>${store_review.mem_id }</td><td>&nbsp;&nbsp;&nbsp;&nbsp;작성 날짜</td>
						</tr>
						<tr>
							<td><b>${store_review.sto_re_content }</b></td>
							<td>
							<input type="button" value="수정">
							<input type="button" value="삭제">
							</td>
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
		<input type="button" value="후기 작성하기" onclick="location.href='StoreReviewWriteForm.st?sto_idx=${store.sto_idx }'">
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





