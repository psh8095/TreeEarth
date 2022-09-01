<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/community.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<h1>후원 내역 조회</h1>
	
	<div id="sup_list">
	
		
			<span>후원글</span>
			<span>후원금액</span>
			<span>후원일</span>
		
		
		<c:choose>
			<c:when test="${not empty supList }">
				<c:forEach var="supporthistory" items="${supList }">
					
						<span>${supporthistory.sup_idx }</span>
						<span>${supporthistory.suphi_money }</span>
						<span>${supporthistory.suphi_date }</span>
					
				</c:forEach>
			</c:when>
			<c:otherwise>
			
				<h1>게시물이 존재하지 않습니다.</h1>
				
			</c:otherwise>
		</c:choose>
	</div>



	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->

</body>
</html>