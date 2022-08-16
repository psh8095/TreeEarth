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
	<!-- 구매후기 상세내용 보기 -->
	<section id="">
		<h3>구매후기 상세내용</h3>
		<section id="">
		 	<table>
		 		<tr><th width="300">${store_review.mem_id }님의 후기입니다.</th></tr>
		 		<tr><th>작성일</th><td></td></tr>
		 		<tr>
		 			<th width="70">첨부 사진</th>
		 		</tr>
		 		<tr>
		 		<td><img alt="" src="upload/${store_review.sto_re_file }" width="300" height="250"></td>
		 		</tr>
		 		<tr>
		 			<th width="70">후기 내용</th>
		 		</tr>
		 		<tr>
		 		<td>${store_review.sto_re_content }</td>
		 		</tr>
		 	</table>
		 </section>
	</section>
	<section id="">
		<input type="button" value="수정" onclick="location.href='StoreReviewModifyForm.st?sto_re_idx=${store_review.sto_re_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='StoreReviewDeleteForm.st?sto_re_idx=${store_review.sto_re_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='StoreReviewList.st?sto_idx=${param.sto_idx }&pageNum=${param.pageNum}'">
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>







