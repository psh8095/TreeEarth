<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<h1>로그인</h1>
	<form action="MemberLoginPro.me" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="로그인">&nbsp;
				<input type="submit" value="카카오톡으로 로그인"> 
				<br>
				<span id="searchId">아이디찾기</span>&nbsp;&nbsp;&nbsp;<span id="searchPass">비밀번호찾기</span>
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>







