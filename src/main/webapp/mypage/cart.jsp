<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<h1>장바구니</h1>
	<c:choose>
		<c:when test="${empty cart }">
			<h1>장바구니가 비어있습니다.</h1>
		</c:when>
		<c:otherwise>
			<table>
				<c:forEach var="cart" items="${cart }">
					<tr>
						<td><img src="img/store/${cart.sto_thum_file }" width="150"></td>
						<td>${cart.sto_subject }</td>
						<td>${cart.sto_price }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>	
	</c:choose>

	<div>
		<input type="button" id="rm_cart" value="삭제">
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>