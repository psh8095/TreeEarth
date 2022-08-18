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

	<h1>자주 묻는 질문 작성</h1>
	
	<form action="QnaFaqWritePro.cm" method="post">
		<table>
			<tr>
				<td><label for="faq_subject">질문</label></td>
				<td><input type="text" name="faq_subject" required="required" /></td>
			</tr>
			<tr>
				<td><label for="faq_content">답변</label></td>
				<td>
					<textarea id="faq_content" name="faq_content" cols="40" rows="15" required="required"></textarea>
				</td>
			</tr>
		</table>
		
		<section id="commandCell">
			<input type="submit" value="등록">&nbsp;&nbsp;
			<input type="reset" value="다시쓰기">&nbsp;&nbsp;
			<input type="button" value="취소" onclick="history.back()">
		</section>
	</form>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->

</body>
</html>