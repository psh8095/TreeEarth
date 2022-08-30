<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 자유게시판</title>
<style type="text/css">
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- 게시판 글 수정 -->
	<section id="modifyForm">
		<h1>자유게시판 글 수정</h1>
		<form action="FreeBoardModifyPro.cm" name="boardForm" method="post">
			<!-- 게시물 수정에 필요한 글번호와 페이징 처리에 필요한 페이지번호도 함께 전달 -->
			<input type="hidden" name="free_idx" value="${param.free_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td class="td_left"><label for="free_name">글쓴이</label></td>
					<td class="td_right">
						<input type="text" name="free_name" value="${freeboard.free_name }" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_pass">비밀번호</label></td>
					<td class="td_right">
						<input type="password" name="free_pass" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_subject">제목</label></td>
					<td class="td_right">
						<input type="text" name="free_subject" value="${freeboard.free_subject }" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_content">내용</label></td>
					<td class="td_right">
						<textarea rows="15" cols="40" name="free_content" required="required">${freeboard.free_content }</textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_img">파일</label></td>
					<!-- 파일 수정 기능은 제외(파일명만 표시) -->
					<td class="td_right">${freeboard.free_img }(수정불가)</td>
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








