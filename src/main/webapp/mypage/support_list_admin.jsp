<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/table.css" rel="stylesheet">
<style type="text/css">
table {
	height: 40px;
}

.co {
	width: 150px;
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

	<h1 class="title">후원 내역 조회</h1>
	
	<table id="sup_list">
		<tr>
			<td class="co">회원ID</td>
			<td class="co">후원글</td>
			<td class="co">후원금액</td>
			<td class="co">후원일</td>
		</tr>
		<c:choose>
			<c:when test="${not empty supList }">
				<c:forEach var="supporthistory" items="${supList }">
					<tr id="commandCell">
						<td>${supporthistory.mem_id }</td>
						<td>${supporthistory.sup_idx }</td>
						<td>${supporthistory.suphi_money }</td>
						<td>${supporthistory.suphi_date }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4"><h3 class="title">게시물이 존재하지 않습니다.</h3></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>

	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->

</body>
</html>