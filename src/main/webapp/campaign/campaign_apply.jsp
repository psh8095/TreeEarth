<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/campaign.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<style type="text/css">

</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<div id="container">
	<h1>캠페인 참가 신청서</h1>
	<form action="CampaignApplyPro.cp" method="post">
		<input type="hidden" name="cam_idx" value="${param.cam_idx }">
		<table border="1">
			<tr>
				<td><label for="cam_name">이름</label></td>
				<td><input type="text" name="mem_name" required="required"></td>
			</tr>
			<tr>
				<td><label for="cam_phone">연락처</label></td>
				<td><input type="text" name="mem_phone" required="required"></td>
			</tr>
			<tr>
				<td><label for="cam_email">이메일</label></td>
				<td><input type="text" name="mem_email" required="required"></td>
			</tr>
			<tr>
				<td><label for="cam_people">참가 희망 인원수</label></td>
				<td><input type="text" name="apply_people" required="required"></td>
			</tr>
			<tr>
				<td><label for="cam_etc">기타사항</label></td>
				<td><textarea cols="37" rows="10" name="apply_etc"></textarea></td>
			</tr>
		</table>
		<br>
		<section id="cam_button">
			 <input class="w-btn-outline w-btn-green-outline" type="submit" value="지원하기">
		</section>
	</form>
</div>	

	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>