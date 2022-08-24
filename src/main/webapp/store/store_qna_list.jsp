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
		<h3>상품 문의 목록</h3> 
			<c:choose>
				<c:when test="${not empty storeQnaList and pageInfo.itemListCount gt 0}">
					<c:forEach var="store_qna" items="${storeQnaList }">
						<table>
						<tr>
							<td>${store_qna.mem_id }님의 문의입니다.</td><td>&nbsp;&nbsp;&nbsp;&nbsp;${store_qna.sto_qna_date }</td>
						</tr>
						<tr>
<!-- 							<td> -->
<%-- 							<b>${store_qna.sto_qna_content }</b> --%>
<!-- 							</td> -->
							<td>
							<span style="display:block;margin-top: 200px;" onclick="location.href='StoreQnaDetail.st?sto_qna_idx=${store_qna.sto_qna_idx }&pageNum=${pageInfo.pageNum}'" style="cursor:pointer;">&lt;문의 보기&gt;</span>
							</td>
						</tr>
						</table>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h2><b>문의 내역이 없습니다.</b></h2>
				</c:otherwise>
			</c:choose>
	</section>
	<br>
	<section id="buttonArea">
		<input type="button" value="문의 작성하기" onclick="location.href='StoreQnaWriteForm.st?sto_idx=${store.sto_idx}'">
	</section>
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