<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Support</title>
<style>
	#passForm {
		width: 300px;
		margin: auto;
		text-align: center;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		width: 300px;
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
	
	<h2>후원 게시판 글 삭제</h2>
	<section id="passForm">
		<form action="SupportDeleteProAdmin.su" name="deleteForm" method="post">
		<input type="hidden" name ="sup_idx" value="${param.sup_idx}">
			<table>
				<tr>
					<td><label>글 비밀번호</label></td>
					<td><input type="password" name="mem_pass" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="삭제">&nbsp;&nbsp;
						<input type="button" value="돌아가기" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</form>
	</section>
		<jsp:include page="../hf/footer.jsp"></jsp:include>
</body>
</html>
