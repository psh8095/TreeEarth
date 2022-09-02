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
	
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<!-- 상품 문의글 상세내용 보기 -->
	<section id="">
		<h3>문의 내역</h3>
		<section id="">
		 	<table>
		 		<tr><th width="300">${store_qna.mem_id }님의 문의입니다.</th></tr>
		 		<tr><td>${store_qna.sto_qna_date }</td></tr>
		 		<tr>
		 			<th width="70">문의 내용</th>
		 		</tr>
		 		<tr>
		 		<td>${store_qna.sto_qna_content }</td>
		 		</tr>
		 	</table>
		 </section>
	</section>
	<section id="">
		<input type="button" value="문의 내용 수정" onclick="location.href='StoreQnaModifyForm.st?sto_idx=${store_qna.sto_idx}&sto_qna_idx=${store_qna.sto_qna_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="문의 삭제" onclick="location.href='StoreQnaDeleteForm.st?sto_idx=${store_qna.sto_idx}&sto_qna_idx=${store_qna.sto_qna_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='StoreQnaList.st?sto_idx=${store_qna.sto_idx }&pageNum=${param.pageNum}'">
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>













