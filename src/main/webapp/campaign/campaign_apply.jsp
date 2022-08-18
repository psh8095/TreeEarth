<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<h1>캠페인 참가 신청서 양식</h1>
	<form action="CampaignApplyPro.cp" method="post">
		<input type="hidden" name="cam_idx" value="${param.cam_idx }">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="mem_name" required="required"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="mem_phone" required="required"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="mem_email" required="required"></td>
			</tr>
			<tr>
				<td>참가 희망 인원수</td>
				<td><input type="text" name="apply_people" required="required"></td>
			</tr>
			<tr>
				<td>기타사항</td>
				<td><textarea cols="23" rows="10" name="apply_etc"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="지원하기">
	</form>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>