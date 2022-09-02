<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
</head>
<body>
	<!-- 헤더 -->
<%-- 	<jsp:include page="../hf/header.jsp"></jsp:include> --%>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<section id="writeForm">
		<h1>공지사항 수정</h1>
		<form action="NoticeModifyPro.cm" method="post">
			<input type="hidden" name="no_idx" value="${param.no_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td><label for="no_id">작성자</label></td>
					<td><input type="text" name="no_id" value="${notice.no_id }" required="required"></td>
				</tr>
				<tr>
					<td><label for="mem_pass">비밀번호</label></td>
					<td>
						<input type="password" name="mem_pass" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="no_subject">제목</label></td>
					<td>
						<input type="text" name="no_subject" value="${notice.no_subject }" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="no_content">내용</label></td>
					<td>
						<textarea id="no_content" name="no_content" cols="40" rows="15" required="required">
							${notice.no_content }
						</textarea>
					</td>
				</tr>
				<tr>
					<td><label for="no_img">이미지 첨부</label></td>
					<td>${notice.no_img }</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="수정">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>