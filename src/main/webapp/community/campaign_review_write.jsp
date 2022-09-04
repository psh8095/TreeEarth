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
	
	<section id="">
		<h2 class="title">캠페인 후기 작성</h2>
		<form action="CampaignReviewPro.cm" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="co"><label for="cam_re_id">글쓴이</label></td>
					<td>
						<input type="text" name="cam_re_id" value="${sessionScope.sId }" required="required">
					</td>
				</tr>
				<tr>
					<td class="co"><label for="cam_re_subject">제목</label></td>
					<td><input type="text" name="cam_re_subject" required="required"></td>
				</tr>
				<tr>
					<td class="co"><label for="cam_re_content">내용</label></td>
					<td>
						<textarea id="cam_re_content" name="cam_re_content" cols="40" rows="15" required="required"></textarea>
					</td>
				</tr>
				<tr>
					<td class="co"><label for="cam_re_file">파일 첨부</label></td>
					<td><input type="file" name="cam_re_file"></td>
				</tr>
			</table>
			<section id="commandCell">
				<input class="btn" type="submit" value="등록">&nbsp;&nbsp;
				<input class="btn" type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input class="btn" type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>