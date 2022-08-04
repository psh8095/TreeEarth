<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="imgPro.jsp" method="post" enctype="multipart/form-data">
		<table id="notice">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" required="required"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" required="required"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="20" name="content" required="required"></textarea></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="file" required="required"></td>
			</tr>

			
		</table>
		<div id="table_search">
			<input type="submit" value="글쓰기" class="btn">
		</div>
	</form>
</body>
</html>