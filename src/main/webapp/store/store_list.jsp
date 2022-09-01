<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 - 상품목록</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<section id="listForm">
		<h1>등록 된 상품목록</h1>
		<table>
			<tr id="tr_top">
				<td width="100">상품 번호</td>
				<td width="300"> 상품 제목</td>
				<td width=100>상품 가격</td>
				<td width="400">상품 내용</td>
				<td width="100">상품 태그</td>
				<td width="100">상품 분류</td>
			</tr>
			<c:choose>
				<c:when test="${not empty storeList and pageInfo.itemListCount gt 0 }">
					<c:forEach var="store" items="${storeList }">
						<tr>
							<td>${store.sto_idx }</td>
							<td id="subject">
								<a href="StoreDetail.st?sto_idx=${store.sto_idx }&pageNum=${pageInfo.pageNum }">
									${store.sto_subject }
								</a>
							</td>
							<td>${store.sto_price} 원</td>
							<td>${store.sto_content }</td>
							<td>${store.sto_tag }</td>
							<td>${store.sto_category }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><td>등록 된 상품이 존재하지 않습니다.</td></tr>
				</c:otherwise>
			</c:choose>
		</table>
	</section>
	<section id="buttonArea">
		<input type="button" value="상품 등록" onclick="location.href='StoreWriteForm.st'">
<!-- 		<input type="button" value="상품 삭제" onclick="location.href='StoreDeleteForm.st'"> -->
	</section>
	<section id="pageList">	
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='StoreList.st?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>
			
		<!-- 페이지 번호 목록은 시작 페이지(startPage)부터 끝 페이지(endPage) 까지 표시 -->
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<!-- 단, 현재 페이지 번호는 링크 없이 표시 -->
			<c:choose>
				<c:when test="${pageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="StoreList.st?pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 현재 페이지 번호(pageNum)가 총 페이지 수보다 작을 때만 [다음] 링크 동작 -->
		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='StoreList.st?pageNum=${pageInfo.pageNum + 1}'">
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