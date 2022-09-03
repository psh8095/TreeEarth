<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<style type="text/css">
body {
   padding: 2rem;
   background-color: hsl(0,0%,95%);
}

* {-webkit-box-sizing: border-box;
   -moz-box-sizing: border-box;
   box-sizing: border-box; 
}
  
#writeForm{
	width: 550px;
	padding: 20px;
	margin: 45px auto 25px auto;
}

h2{
	text-align: center;
	padding: 20px;
}

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

/* .td_left { */
/* 	width: 150px; */
/* 	background: gray; */
/* 	text-align: center; */
/* } */
	
/* .td_right { */
/* 	width: 300px; */
/* 	background: skyblue; */
/* } */
	
#commandCell {
	text-align: center;
}	
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<div id="writeForm">
		<h2>캠페인 게시글 작성</h2>
		<form action="CampaignWritePro.cp" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td><label for="cam_subject">제목</label></td>
					<td><input type="text" name="cam_subject"></td>
				</tr>
				<tr>
					<td><label for="cam_content">내용</label></td>
					<td><textarea rows="15" cols="40" required="required" name="cam_content"></textarea>
				</tr>
				<tr>
					<td><label for="cam_img">파일 첨부</label></td>
					<td><input type="file" name="cam_img"></td>
				</tr>
			</table>
		<br>
			<div id="commandCell"> 
				<input id="cam_apply" type="submit" value="등록">&nbsp;&nbsp;
				<input id="cam_apply" type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input id="cam_apply" type="button" value="취소" onclick="history.back()">
			</div>
		</form>
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>