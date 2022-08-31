<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="findIdPhone">
		<h3>이름, 핸드폰번호로 찾기</h3>
		<form name="findIdPhone" action="FindIdPhone.me" method="get">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required="required"></td>
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
						<input type="text" name="phone2" required="required"> - 
						<input type="text" name="phone3" required="required">
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