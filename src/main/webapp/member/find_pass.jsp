<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	function changeDomain() {
		document.findPass.email2.value = document.findPass.emailDomain.value;
	}
	
	$(function() {
		//인증번호 발송
		$("#sendAuthCode").on("click", function() {
			$.ajax({
				type: "post",
				url: "FindPassAuth.me",
				data: $("form").serialize(),
				dataType: "text",
				success: function() {
					
				}
			});
		});
	});
</script>
</head>
<body>
	
	<h1>비밀번호 찾기</h1>
	
	<form name="findPass" action="CheckPassResult.me" method="get">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="mem_id"></td>
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
					<td>인증 번호</td>
					<td>
						<input id="authCode" type="text" name="authCode" required="required">
						<input id="sendAuthCode" type="button" value="인증번호 전송">	
						<span id="authCodeSpan"></span>
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
	
</body>
</html>