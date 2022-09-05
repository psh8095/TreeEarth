<%@page import="vo.community.FreeboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
	#replyForm {
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
		left: 50%;	 
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
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<!-- 게시판 답글 작성 -->
	<section id="replyForm">
		<h1>자유게시판 답글 작성</h1>
		<form action="FreeBoardReplyPro.cm" name="freeboardForm" method="post">
			<!-- 글번호와 페이지번호 전달 -->
			<input type="hidden" name="free_idx" value="${param.free_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<!-- 답글에 대한 원본글 정보 담고 있는 free_re_ref, free_re_lev, free_re_seq 도 전달 -->
			<input type="hidden" name="free_re_ref" value="${board.free_re_ref }">
			<input type="hidden" name="free_re_lev" value="${board.free_re_lev }">
			<input type="hidden" name="free_re_seq" value="${board.free_re_seq }">
			<table>
				<tr>
					<td class="td_left"><label for="free_name">글쓴이</label></td>
					<td class="td_right">
						<input type="text" name="free_name" required="required" />
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_pass">비밀번호</label></td>
					<td class="td_right">
						<input type="password" name="free_pass" required="required" />
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_subject">제목</label></td>
					<td class="td_right">
						<input type="text" name="free_subject" value="Re:${board.free_subject }" required="required" />
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_content">내용</label></td>
					<td class="td_right">
						<textarea id="free_content" name="free_content" cols="40" rows="15" required="required">${board.free_content }</textarea>
					</td>
				</tr>
			</table>
			<section id="button">
				<input id="button2" type="submit" value="답글등록">&nbsp;&nbsp;
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