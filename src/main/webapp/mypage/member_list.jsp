<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@font-face {
    font-family: 'HallymGothic-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2204@1.0/HallymGothic-Regular.woff2') format('woff2');
    font-weight: 400;
    font-style: normal;
}

*{margin: 0; padding: 0; font-family: 'HallymGothic-Regular';}

.table {
	margin: 0 0 40px 0;
	width: 100%;
	box-shadow: 0 1px 3px rgba(0,0,0,0.2);
	display: table;
}

.row {
	display: table-row;
}

.cell {
	display: table-cell;
}

.header {
	background-color: #7fd49b;
	color: #ffffff;
	font-weight: 600;
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
	
	<h1>회원 목록</h1>
	<hr style="color: gray; opacity: 50%; margin-bottom: 15px;">
	
	<div class="table">
		<div class="row header">
			<div class="cell">ID</div>
			<div class="cell">이름</div>
			<div class="cell">생년월일</div>
			<div class="cell">성별</div>
			<div class="cell">주소</div>
			<div class="cell">상세 주소</div>
			<div class="cell">연락처</div>
			<div class="cell">이메일</div>
			<div class="cell">가입일자</div>
		</div>
		
		<c:forEach var="member" items="${memberList }">
			<div class="row">
				<div class="cell">${member.mem_id }</div>
				<div class="cell">${member.mem_name }</div>
				<div class="cell">${member.mem_birth }</div>
				<div class="cell">${member.mem_gender }</div>
				<div class="cell">${member.mem_address }</div>
				<div class="cell">${member.mem_address_detail }</div>
				<div class="cell">${member.mem_phone }</div>
				<div class="cell">${member.mem_email }</div>
				<div class="cell">${member.mem_date }</div>
			</div>
		</c:forEach>
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>