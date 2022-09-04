<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/table.css" rel="stylesheet">
</head>
<body>
	<h2 class="title">게시판 글 삭제</h2>
	<section id="">
		<form action="CampaignReviewDeletePro.cm" method="post">
			<input type="hidden" name="cam_re_idx" value="${param.cam_re_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td><label>글 비밀번호</label></td>
					<td><input type="password" name="mem_pass" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="btn" type="submit" value="삭제">&nbsp;&nbsp;
						<input class="btn" type="button" value="돌아가기" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>
