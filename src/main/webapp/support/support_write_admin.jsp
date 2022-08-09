<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TreeEarth</title>
<link href="css/index.css" rel="stylesheet">
</head>
<style type="text/css">	
#writeForm {
	width: 800px;
	height: 610px;
	border: 1px solid green;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 600px;
}

.td_left {
	width: 150px;
	background: green;
}

.td_right {
	width: 300px;
	background: yellowgreen;
}

#commandCell {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<section id="writeForm">
		<h2>게시판글등록</h2>
		<form action="SupportWriteProAdmin.su" method="post"
			enctype="multipart/form-data" name="boardform">
			<table>
				<tr>
					<td class="td_left"><label for="sup_subject">제목</label></td>
					<td class="td_right"><input type="text" name="sup_subject"
						id="board_name" required="required"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sup_pass">비밀번호</label></td>
					<td class="td_right"><input type="password" name="sup_pass"
						id="board_pass" required="required"></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td class="td_left"><label for="sup_goal_price">목표 금액</label></td>
					<td class="td_right"><input type="text" name="sup_goal_price"
						id="board_subject" required="required"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sup_content">내용</label></td>
					<td><textarea name="sup_content" rows="15" cols="40" required="required"></textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="sup_thumbnail_file">썸네일 파일 첨부</label></td>
					<td class="td_right"><input name="sup_thumbnail_file" type="file"
						 required="required"></td>
				</tr>
					<tr>
					<td class="td_left"><label for="sup_original_file">파일 첨부</label></td>
					<td class="td_right"><input name="sup_original_file" type="file"
						 required="required"></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp; <input
					type="reset" value="다시쓰기" />&nbsp;&nbsp;
					<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
	    
    <!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>