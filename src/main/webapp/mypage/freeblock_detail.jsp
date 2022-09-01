<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
</head>
<body>

	<h1>자유게시판 신고글 상세조회</h1>
	
	<table>
		<tr>
			<th>신고글제목</th>
			<td>${freeboard.free_subject }</td>
		</tr>
		<tr>
			<th>신고글내용</th>
			<td>
				${freeboard.free_content } <br><br>
				<img alt="${freeboard.free_img }" src="img/community${freeboard.free_img }">
			</td>
		</tr>
		<tr>
			<th>신고이유</th>
			<td>${free_block.free_block_reason }</td>
		</tr>
	</table>

<%-- 	<input type="button" value="신고글삭제" onclick="location.href='FreeBoardBlockDelete.my?free_block_ref=${free_block.free_block_ref}'"> --%>

</body>
</html>