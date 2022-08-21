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

	<h1>신고글 상세조회</h1>
	
	<table>
		<tr>
			<th>신고글제목</th>
			<td>${campaign_review.cam_re_subject }</td>
		</tr>
		<tr>
			<th>신고글내용</th>
			<td>
				${campaign_review.cam_re_content } <br><br>
				<img alt="${campaign_review.cam_re_file }" src="upload/${campaign_review.cam_re_real_file }">
			</td>
		</tr>
	</table>

	<input type="button" value="신고취소" onclick="">
	<input type="button" value="신고글삭제" onclick="">

</body>
</html>