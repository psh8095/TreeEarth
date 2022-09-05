<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<style type="text/css">
	#writeForm {
		width: 500px;
		height: 450px;
		border: 1px #c5e096;
		margin: auto;
	}
	
	h1 {
		text-align: center;
		color: #c5e096;
	}
	
	table {
		margin: auto;
		width: 450px;
		color: white;
	}
	
	.td_left {
		width: 150px;
		background: #c5e096;
		text-align: center;
	}
	
	#button {
		position: absolute;
		left: 53%;	 
	}
	
	#button2 {
		color: white; 
		padding: 4px 10px;
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
</style>
</head>
<body>
	<!-- 헤더 -->
<%-- 	<jsp:include page="../hf/header.jsp"></jsp:include> --%>
	<!-- 헤더 -->

	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->

	<%
		String no_id = null;
		if (session.getAttribute("no_id") != null) {
			no_id = (String) session.getAttribute("no_id"); // 로그인을 한사람이라면 no_id 에 정보가 담기게 됨
		}
	%>
	
	<section id="writeForm">
		<h1>공지사항 작성</h1>
		<form action="NoticeWritePro.cm" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="td_left"><label for="no_id">작성자</label></td>
					<td>
						<input type="text" name="no_id" value="${sessionScope.sId }" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="no_subject">제목</label></td>
					<td><input type="text" name="no_subject" required="required"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="no_content">내용</label></td>
					<td>
						<textarea id="no_content" name="no_content" cols="40" rows="15" required="required"></textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="no_img">이미지 첨부</label></td>
					<td><input type="file" name="no_img"></td>
				</tr>
			</table>
			<section id="button">
				<input id="button2" type="submit" value="등록">&nbsp;&nbsp;
				<input id="button2" type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input id="button2" type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>