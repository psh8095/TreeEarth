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
#sup_list {
	margin: 0 0 40px 0;
	width: 100%;
	box-shadow: 0 1px 3px rgba(0,0,0,0.2);
	border-spacing: 1px solid black;
	display: table;
}

.row {
	display: table-row;
}

.cell {
	display: table-cell;
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
	
	<div id="sup_list">
		<div class="row">
			<span class="cell co">후원글</span>
			<span class="cell co">후원금액</span>
			<span class="cell co">후원일</span>
		</div>
		
		<c:choose>
			<c:when test="${not empty supList }">
				<c:forEach var="supporthistory" items="${supList }">
					<div class="row" id="commandCell">
						<span class="cell">${supporthistory.sup_idx }</span>
						<span class="cell">${supporthistory.suphi_money }</span>
						<span class="cell">${supporthistory.suphi_date }</span>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
			
				<h3 class="title">게시물이 존재하지 않습니다.</h3>
				
			</c:otherwise>
		</c:choose>
	</div>

	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->

</body>
</html>