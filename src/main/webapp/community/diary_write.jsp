<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">	
#writeForm {
	width: 800px;
	height: 610px;
	margin: auto;
}


table {
	margin: auto;
	width: 600px;
}

#commandCell {
	text-align: center;
}
</style>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<section id="writeForm">
		<h1>반려나무 성장일지 작성</h1>
		<form action="DiaryWritePro.cm" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><label for="diary_id">글쓴이</label></td>
					<td>
						<input type="text" name="diary_id" value="${sessionScope.sId }" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="diary_subject">제목</label></td>
					<td><input type="text" name="diary_subject" required="required"></td>
				</tr>
				<tr>
					<td><label for="diary_content">내용</label></td>
					<td>
						<textarea id="diary_content" name="diary_content" cols="55" rows="25" required="required"></textarea>
					</td>
				</tr>
				<tr>
					<td><label for="diary_img">파일 첨부</label></td>
					<td><input type="file" name="diary_img"></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
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