<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<div style="height: 50px"></div>
	<h1>참가 내역</h1>
	<c:choose>
		<c:when test="${empty applyList }">
			<h1>캠페인 참가 내역이 존재하지 않습니다.</h1>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${sessionScope.sId eq 'admin' }">
					<table>
						<tr>
							<td>캠페인</td>
							<td>회원 아이디</td>
							<td>이름</td>
							<td>연락처</td>
							<td>신청 인원</td>
							<td>기타 사항</td>
						</tr>
						<c:forEach var="apply" items="${applyList }">
							<tr>
								<td>${apply.cam_subject }</td>
								<td>${apply.mem_id }</td>
								<td>${apply.mem_name }</td>
								<td>${apply.mem_phone }</td>
								<td>${apply.apply_people }</td>
								<td>${apply.apply_etc }</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<td>캠페인</td>
							<td>이름</td>
							<td>연락처</td>
							<td>신청 인원</td>
							<td>기타 사항</td>
						</tr>
						<c:forEach var="apply" items="${applyList }">
							<tr>
								<td>${apply.cam_subject }</td>
								<td>${apply.mem_name }</td>
								<td>${apply.mem_phone }</td>
								<td>${apply.apply_people }</td>
								<td>${apply.apply_etc }</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>