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
	#writeForm {
		width: 500px;
		height: 450px;
		border: 1px #c5e096;
		margin: auto;
	}
	
	h1 {
		text-align: center;
		color: #c5e096;
	}
	
	.table {
		margin: auto;
		width: 450px;
		color: white;
	}
	
	.td_left {
		width: 150px;
		background: #c5e096;
		text-align: center;
		color: white;
	}
	
	#button {
		margin: 0 auto;
	}
	
	#button2 {
		color: white; 
		padding: 4px 10px;
		background-color: #c5e096;
		display: inline-block;
		border: 1px solid rgba(0,0,0,0.21);
		border-bottom-color: rgba(0,0,0,0.34);
		text-shadow:0 1px 0 rgba(0,0,0,0.15);
		box-shadow: 0 1px 0 rgba(255,255,255,0.34) inset, 
		            0 2px 0 -1px rgba(0,0,0,0.13), 
		            0 3px 0 -1px rgba(0,0,0,0.08), 
		            0 3px 13px -1px rgba(0,0,0,0.21);
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
	
	<section id="writeForm">
		<h1>캠페인 공고 작성</h1>
		<form id="cam_form" action="CampaignWritePro.cp" method="post" enctype="multipart/form-data">
			<table id="table">
				<tr>
					<td class="td_left"><label for="cam_subject">제목</label></td>
					<td><input type="text" name="cam_subject"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="cam_content">내용</label></td>
					<td><textarea rows="15" cols="41" required="required" name="cam_content"></textarea>
				</tr>
				<tr>
					<td class="td_left"><label for="cam_img">파일 첨부</label></td>
					<td><input type="file" name="cam_img"></td>
				</tr>
			</table>
			
			<section id="button">
				<button id="button2" type="submit" value="등록">등록</button>
				<button id="button2" type="reset" value="다시쓰기">다시쓰기</button>
				<button id="button2" type="button" value="취소" onclick="history.back()">취소</button>
			</section>
		</form>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>