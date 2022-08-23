<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<style type="text/css">
#writeForm {
	width: 500px;
	height: 450px;
	border: 1px;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

.td_left {
	width: 150px;
	background: gray;
	text-align: center;
}
	
.td_right {
	width: 300px;
	background: skyblue;
}
	
#commandCell {
	text-align: center;
}	
</style>
</head>
<body>
	<section id="writeForm">
	<h2>캠페인 게시글 작성</h2>
		<form action="CampaignWritePro.cp" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="td_left"><label for="cam_subject">제목</label></td>
					<td class="td_right"><input type="text" name="cam_subject"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="cam_content">내용</label></td>
					<td class="td_right"><textarea rows="15" cols="40" required="required" name="cam_content"></textarea>
				</tr>
				<tr>
					<td class="td_left"><label for="cam_img">파일 첨부</label></td>
					<td class="td_right"><input type="file" name="cam_img"></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
</body>
</html>