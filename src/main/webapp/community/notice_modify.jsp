<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<style type="text/css">
	#modifyForm {
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
<%-- 	<jsp:include page="../hf/header.jsp"></jsp:include> --%>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<section id="modifyForm">
		<h1>공지사항 수정</h1>
		<form action="NoticeModifyPro.cm" method="post">
			<input type="hidden" name="no_idx" value="${param.no_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td class="td_left"><label for="no_id">작성자</label></td>
					<td><input type="text" name="no_id" value="${notice.no_id }" required="required"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="mem_pass">비밀번호</label></td>
					<td>
						<input type="password" name="mem_pass" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="no_subject">제목</label></td>
					<td>
						<input type="text" name="no_subject" value="${notice.no_subject }" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="no_content">내용</label></td>
					<td>
						<textarea id="no_content" name="no_content" cols="40" rows="15" required="required">
							${notice.no_content }
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="no_img">이미지 첨부</label></td>
					<td class="td_left">${notice.no_img }(이미지 수정불가)</td>
				</tr>
			</table>
			<section id="button">
				<input id="button2" type="submit" value="수정">&nbsp;&nbsp;
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