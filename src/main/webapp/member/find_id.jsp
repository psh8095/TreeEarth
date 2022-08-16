<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<script type="text/javascript">
	function changeDomain() {
		document.findIdEmail.email2.value = document.findIdEmail.emailDomain.value;
	}
</script>
</head>
<body>
	<h1>아이디 찾기</h1>
	
	<section id="findIdPhone">
		<h3>이름, 핸드폰번호로 찾기</h3>
		<form name="findIdPhone" action="FindIdPhone.me" method="get">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td>
						<select name="phone1" onchange="changePhone()">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="070">070</option>
							<option value="02">02</option>
						</select>
						<input type="text" name="phone2"> - 
						<input type="text" name="phone3">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="찾기">
						<input type="button" value="취소" onclick="window.close()">
					</td>
				</tr>
			</table>
		</form>
	</section>
	
	<section id="findIdEmail">
		<h3>이름, 이메일로 찾기</h3>
		<form name="findIdEmail" action="FindIdEmail.me" method="get">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email1" required="required">@
						<input type="text" name="email2" required="required">
						<select name="emailDomain" onchange="changeDomain()">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="nate.com">google.com</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="찾기">
						<input type="button" value="취소" onclick="window.close()">
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>