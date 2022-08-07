<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#articleForm {
		width: 500px;
		height: 550px;
		border: 1px solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		border: 1px solid black;
		border-collapse: collapse; 
	 	width: 500px;
	}
	
	th {
		text-align: center;
	}
	
	td {
		width: 150px;
		text-align: center;
	}
	
	#basicInfoArea {
		height: 70px;
		text-align: center;
	}
	
	#articleContentArea {
		background: orange;
		margin-top: 20px;
		height: 350px;
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
</head>
<body>
<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 게시판 상세내용 보기 -->
	<section id="articleForm">
		<h2>글 상세내용 보기</h2>
		<section id="basicInfoArea">
			<table border="1">
			<tr><th width="70">제 목</th><td colspan="3" >${dto.sup_subject }</td>
			</tr>
			
			<tr>
				<th width="70">작성일</th><td>${dto.date }</td>
			</tr>
			<tr>
				<th width="70">조회수</th>
				<td>${dto.sup_readcount }</td>
			</tr>
			</table>
		</section>
		<section id="articleContentArea">
			${dto.sup_content }
		</section>
	</section>
	<section id="commandList">
	<input type="button" value="답변" onclick="location.href='BoardReplyForm.bo?board_num=${dto.sup_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="수정" onclick="location.href='BoardModifyForm.bo?board_num=${dto.sup_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='BoardDeleteForm.bo?board_num=${dto.sup_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='BoardList.bo?pageNum=${param.pageNum}'">
	</section>
</body>
</html>