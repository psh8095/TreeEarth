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
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<section id="writeForm">
		<h1>성장일지 수정</h1>
		<form action="DiaryModifyPro.cm" method="post">
			<input type="hidden" name="diary_idx" value="${param.diary_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td><label for="diary_id">글쓴이</label></td>
					<td><input type="text" name="diary_id" value="${diary.diary_id }" required="required"></td>
				</tr>
				<tr>
					<td><label for="mem_pass">비밀번호</label></td>
					<td>
						<input type="password" name="mem_pass" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="diary_subject">제목</label></td>
					<td>
						<input type="text" name="diary_subject" value="${diary.diary_subject }" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="diary_content">내용</label></td>
					<td>
						<textarea id="diary_content" name="diary_content" cols="40" rows="15" required="required">
							${diary.diary_content }
						</textarea>
					</td>
				</tr>
				<tr>
					<td><label for="diary_img">파일</label></td>
					<td>${diary.diary_img }</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="수정" onclick="location.href='DiaryList.cm?pageNum=${param.pageNum}'">&nbsp;&nbsp;
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