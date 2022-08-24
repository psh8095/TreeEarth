<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<h1>회원 목록</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>주소</th>
			<th>상세 주소</th>
			<th>연락처</th>
			<th>이메일</th>
			<th>적립금</th>
			<th>가입일자</th>
		</tr>
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.mem_id }</td>
				<td>${member.mem_name }</td>
				<td>${member.mem_birth }</td>
				<td>${member.mem_gender }</td>
				<td>${member.mem_address }</td>
				<td>${member.mem_address_detail }</td>
				<td>${member.mem_phone }</td>
				<td>${member.mem_email }</td>
				<td>${member.mem_point }</td>
				<td>${member.mem_date }</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>