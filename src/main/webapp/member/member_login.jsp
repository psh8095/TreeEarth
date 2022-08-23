<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //페이지 번호
    session.setAttribute("location", 1);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

	function findId() {
		window.open("FindIdForm.me", "findId", "width=700, height=450");
	}

	function findPass() {
		window.open("FindPassForm.me", "findPass", "width=630, height=300");
	}
</script>
<link href="css/index.css" rel="stylesheet">
</head>
<body>

	<h1>로그인</h1>

	<h1><a href="requiredTerms.me">회원가입</a></h1>

	<form action="MemberLoginPro.me" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mem_id"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="mem_pass"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
				<input type="submit" value="카카오톡으로 로그인">
				<br>
				<span id="searchId" onclick="findId()">아이디 찾기</span>&nbsp;&nbsp;&nbsp;
				<span id="searchPass" onclick="findPass()">비밀번호찾기</span>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>







