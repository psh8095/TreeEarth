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
form{
	max-width: 30rem;
	margin: 0 auto;
	padding: 1.5rem 2rem;
	background-color: #ffffff;
	border-radius: 8px;
	box-shadow: 0 4px 20px raba(0,0,0,0.15);
}

table input{
	outline: 0;
	background: #ffffff;
	width: 100%;
	padding: 15px;
	box-sizing: border-box;
	font-size: 15px;
	
}
	
</style>
</head>
<body id="back">
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<div id="writeForm">
		<h2>캠페인 공고 작성</h2>
		<form id="cam_form" action="CampaignWritePro.cp" method="post" enctype="multipart/form-data">
			<table id="table_form" border="1">
				<tr>
					<td><label for="cam_subject">제목</label></td>
					<td><input type="text" name="cam_subject"></td>
				</tr>
				<tr>
					<td><label for="cam_content">내용</label></td>
					<td><textarea rows="15" cols="41" required="required" name="cam_content"></textarea>
				</tr>
				<tr>
					<td><label for="cam_img">파일 첨부</label></td>
					<td><input type="file" name="cam_img"></td>
				</tr>
			</table>
		<br>
			<div id="commandCell"> 
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="history.back()">
			</div>
		</form>
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>