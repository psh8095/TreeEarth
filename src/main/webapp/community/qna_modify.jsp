<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/table.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<h2 class="title">Q&A 수정</h2>
	
	<form action="QnaModifyPro.cm" method="post">
		<input type="hidden" name="qna_idx" value="${param.qna_idx }">
		<table>
			<tr>
				<td class="co"><label for="qna_id">작성자</label></td>
				<td>
					<input type="text" name="qna_id" value="${qna.qna_id }" required="required">
				</td>
			</tr>
			<tr>
				<td class="co">카테고리</td>
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
				<td class="co"><label for="qna_subject">질문</label></td>
				<td>
					<textarea name="qna_subject" cols="40" rows="5" required="required">
						${qna.qna_subject }
					</textarea>
				</td>
			</tr>
			<c:if test="${sessionScope.sId eq 'admin'}">
				<tr>
					<td class="co"><label for="qna_content">답변</label></td>
					<td>
						<textarea id="qna_content" name="qna_content" cols="40" rows="5" required="required">
							${qna.qna_content }
						</textarea>
					</td>
				</tr>
			</c:if>
		</table>
		
		<section id="commandCell">
			<input class="btn" type="submit" value="수정">&nbsp;&nbsp;
			<input class="btn" type="reset" value="다시쓰기">&nbsp;&nbsp;
			<input class="btn" type="button" value="취소" onclick="history.back()">
		</section>
	</form>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->

</body>
</html>