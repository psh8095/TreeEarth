<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 자유게시판 삭제</title>
<style>
	#passForm {
		width: 300px;
		margin: auto;
		border: 1px solid c5e096;
		text-align: center;
	}
	
	h2 {
		text-align: center;
		color: #c5e096;
	}
	
	table {
		width: 300px;
		margin: auto;
		text-align: center;
	}
	
	#button {
		color: white; 
		padding: 2px 2px;
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
	
	#button2 {
		position: absolute;
		left: 53%;
	}	
</style>
</head>
<body>
	<h2>자유게시판 글 삭제</h2>
	<section id="passForm">
		<form action="FreeBoardDeletePro.cm" name="deleteForm" method="post">
			<!-- 입력받지 않은 글번호(free_idx)와 페이지번호(pageNum)도 함께 포함시켜 전달 -->
			<input type="hidden" name="free_idx" value="${param.free_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td><label>글 비밀번호</label></td>
					<td><input type="password" name="free_pass" required="required"></td>
				</tr>
				<tr>
					<td id="button2">
						<input id="button" type="submit" value="삭제">&nbsp;&nbsp;
						<input id="button" type="button" value="돌아가기" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>