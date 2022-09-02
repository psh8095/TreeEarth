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
<!-- 		<h3>구매후기 상세내용</h3> -->
		<div id="">
		 	<table>
		 		<tr><th width="300">&lt;${store_review.mem_id }님의 후기입니다&gt;</th></tr>
		 		<tr><th>${store_review.sto_re_date }</th></tr>
		 		<tr>
		 			<th width="70">후기 사진</th>
		 		</tr>
		 		<tr>
<%-- 		 		<td><img alt="" src="img/store/${store_review.sto_re_file }" width="300" height="250"></td> --%>
				<td><a href="img/store/${store_review.sto_re_real_file }"><img id="sto_img" alt="${store_review.sto_re_file }" src="img/store/${store_review.sto_re_real_file }" width="400px" height="300px"></a></td>
		 		</tr>
		 		<tr>
		 			<th width="70">후기 내용</th>
		 		</tr>
		 		<tr>
		 		<td>${store_review.sto_re_content }</td>
		 		</tr>
		 	</table>
		 </div>

	<div class="">
		<input type="button" value="수정" onclick="location.href='StoreReviewModifyForm.st?sto_idx=${store_review.sto_idx}&sto_re_idx=${store_review.sto_re_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='StoreReviewDeleteForm.st?sto_idx=${store_review.sto_idx}&sto_re_idx=${store_review.sto_re_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='StoreReviewList.st?sto_idx=${param.sto_idx }&pageNum=${param.pageNum}'">
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>







