<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$("#unregister").on("click", function() {
		if(confirm("정말로 탈퇴하시겠습니까?")) {
			location.href="UnregisterMember.me";
		}
	});
</script>
</head>
<body>
	<form action="UpdateMemberInfo.my" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" value="${member.mem_name }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="mem_pass" required="required"></td>
			</tr>
			<tr>
				<td>휴대폰 번호</td>
				<td><input type="text" name="mem_phone" value="${member.mem_phone }"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="mem_address" value="${member.mem_address }"></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input type="text" name="mem_address_detail" value="${member.mem_address_detail }"></td>
			</tr>
		</table>
		<input type="submit" value="정보 수정">
	</form>
	<input type="button" value="회원 탈퇴" id="unregister">
</body>
</html>