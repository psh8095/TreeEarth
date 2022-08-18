<%@page import="vo.community.DiaryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%
	// dto 객체 어트리뷰트로 받기
	DiaryDTO diary = (DiaryDTO)request.getAttribute("diary");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려나무 성장일지</title>
<link href="../css/index.css" rel="stylesheet">
</head>
<style type="text/css">	
#writeForm {
	width: 800px;
	height: 610px;
	border: 1px solid yellowgreen;
	margin: auto;
}
table {
	margin: auto;
	width: 700px;
}
#commandCell {
	text-align: center;
}

#articleContentArea {
		background: yellowgreen;
		margin-top: 20px;
		width:auto;
		height: 420px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
		#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
</style>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	<section id="writeForm">
		<h2>글 상세내용 보기</h2>
		
		<section id="">
			<table>
			<tr><th width="70">제 목</th><td colspan="3" >${diary.diary_subject }</td></tr>
			<tr>
				<th width="70">작성자</th><td>${diary.diary_id }</td>
				<th width="70">작성일</th><td>${diary.diary_date }</td>
			</tr>
			<tr>
				<th width="70">첨부파일</th>
				<td>
					<a href="upload/${diary.diary_real_img }" download="${diary.diary_img }">
						${diary.diary_img }
					</a>
				</td>
				<th width="70">조회수</th>
				<td>${diary.diary_readcount }</td>
			</tr>
			</table>
		</section>
			<section id="articleContentArea">
			<img alt="" src="./upload/<%=diary.getDiary_thumb_img() %>" width="70%">
			<img alt="" src="./upload/<%=diary.getDiary_img() %>" width="70%">
			</section>
	</section>
	
	<section id="commandList">
		<input type="button" value="수정" onclick="location.href='DiaryModifyForm.cm?diary_idx=${diary.diary_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='DiaryDeleteForm.cm?diary_idx=${diary.diary_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='DiaryList.cm?pageNum=${param.pageNum}'">
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>