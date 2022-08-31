<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<%
		String no_id = null;
		if (session.getAttribute("no_id") != null) {
			no_id = (String) session.getAttribute("no_id"); // 로그인을 한사람이라면 no_id 에 정보가 담기게 됨
		}
	%>
	
	<section id="">
		<h1>공지사항 작성</h1>
		<form action="NoticeWritePro.cm" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td><label for="no_id">작성자</label></td>
					<td>
						<input type="text" name="no_id" value="${sessionScope.sId }" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="no_subject">제목</label></td>
					<td><input type="text" name="no_subject" required="required"></td>
				</tr>
				<tr>
					<td><label for="no_content">내용</label></td>
					<td>
						<textarea id="no_content" name="no_content" cols="40" rows="15" required="required"></textarea>
					</td>
				</tr>
				<tr>
					<td><label for="no_img">이미지 첨부</label></td>
					<td><input type="file" name="no_img"></td>
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