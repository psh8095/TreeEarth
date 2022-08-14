<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
</head>
<body>
	<h1>아이디 찾기</h1>
	<form action="findIdPhonePro.me">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="find_name"></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><input type="text" name="find_name"></td>
			</tr>
			
			<tr colspan="2">
				<input type="submit" value="가입">
				<input type="reset" value="초기화">
				<input type="button" value="돌아가기" onclick="history.back()">
			</tr>
		</table>
	</form>
	<form action="findIdEmail.me">
	
	</form>
</body>
</html>