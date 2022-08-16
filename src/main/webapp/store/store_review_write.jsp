<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>treeEarth</title>
<link href="../css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<section id="reviewForm">
		<h1>상품 구매 후기 작성</h1>
		<form action="StoreReviewWritePro.st" method="post" enctype="multipart/form-data">
		<input type="hidden" name="sto_idx" value="${param.sto_idx }">
			<table>
				<tr>
					<td><img src="img/store/${store.sto_thum_file}" width="100" height="110"></td>
					<td>${store.sto_subject }</td>
				</tr>
				<tr>
					<td><label for="sto_re_mem_id">작성자</label></td>
					<td>
						<input type="text" name="sto_re_mem_id" value="${sessionScope.sId }" id="sto_re_mem_id" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="sto_re_content">내용</label></td>
					<td>
						<textarea cols="50" rows="15" id="sto_re_content" name="sto_re_content" required="required"></textarea>
					</td>
				</tr>
				<tr>
					<td><label for="sto_re_file">후기 사진 첨부</label></td>
					<td><input type="file" id="sto_re_file" name="sto_re_file"></td>
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









