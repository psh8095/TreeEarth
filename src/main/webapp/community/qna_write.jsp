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

	<h1>Q&A 작성</h1>
	
	<form action="QnaWritePro.cm" method="post">
		<table>
			<tr>
				<td><label for="qna_id">작성자</label></td>
				<td>
					<input type="text" name="qna_id" value="${sessionScope.sId }" required="required">
				</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>
					<select name="qna_tag" onchange="changeTag()">
						<option value="faq">자주묻는질문</option>
						<option value="delivery">배송문의</option>
						<option value="change">교환/반품문의</option>
						<option value="store">상품문의</option>
						<option value="etc">기타문의</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="qna_subject">질문</label></td>
				<td><input type="text" name="qna_subject" required="required" /></td>
			</tr>
			<tr>
				<td><label for="qna_content">답변</label></td>
				<td>
					<textarea id="qna_content" name="qna_content" cols="40" rows="15"></textarea>
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