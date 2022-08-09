<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    session.setAttribute("location", 2);
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
	
	function checkEmail() {
		window.open("checkEmail.me", "check_email", "width=600,height=400");
	}
	
	</script>

</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<!-- 회원가입 절차 -->
	<jsp:include page="currentLocation.jsp"></jsp:include>
	<!-- 회원가입 절차 -->
	
	<h1>본인 인증</h1>
	
	
	<form action="">
		
		
		<input type="button" value="휴대폰 인증하기" onclick="location.href=''">
		<input type="button" value="이메일 인증하기" onclick="checkEmail()">
		
	</form>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
	
</body>
</html>