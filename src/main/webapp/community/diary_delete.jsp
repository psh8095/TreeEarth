<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Support</title>
<link href="css/button.css" rel="stylesheet">
<style>
	#passForm {
		width: 1000px;
		margin: auto;
		text-align: center;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		width: 1000px;
		margin: auto;
		text-align: center;
	}
	
</style>
</head>
<body>
	<!-- 게시판 글 삭제 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<h2>성장일지 삭제</h2>
	<section id="passForm">
		<form action="DiaryDeletePro.cm" method="post">
		<input type="hidden" name="diary_idx" value="${param.diary_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td><label>글 비밀번호</label></td>
					<td><input type="password" name="mem_pass" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button class="w-btn-outline w-btn-red-outline" type="submit" >삭제</button>
						<button class="w-btn-outline w-btn-indigo-outline"type="button" onclick="javascript:history.back()">돌아가기</button>
					</td>
				</tr>
			</table>
		</form>
	</section>
		<jsp:include page="../hf/footer.jsp"></jsp:include>
</body>
</html>
