<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 된 상품을 상세조회하는 페이지</title>
<style type="text/css">
	#articleForm {
		width: 800px;
		height: 850px;
		border: 1px solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		border: 1px solid black;
		border-collapse: collapse; 
	 	width: 800px;
	 	margin: auto;
	}
	
	th {
		text-align: center;
	}
	
	td {
		width: 150px;
		text-align: center;
	}
	
	#basicInfoArea {
		height: 120px;
		text-align: center;
	}
	
	#articleContentArea {
		background: orange;
		margin-top: 20px;
		height: 350px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
	#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<!-- 게시판 상세내용 보기 -->
	<section id="articleForm">
		<h2>등록 된 상품을 상세조회하는 페이지</h2>
		<section id="basicInfoArea">
			<table border="1">
			<tr><th width="400">상품 이름</th><td colspan="3" >${store.sto_subject }</td></tr>
			<tr>
				<th width="70">상품 가격</th><td>${store.sto_price } 원</td>
				<th width="70">작성일</th><td>${store.sto_date }</td>
			</tr>
			<tr>
				<th width="70">첨부파일</th>
				<td>
					<!-- 
					파일명은 원본 파일명을 표시하고, 다운로드 파일 대상은 실제 업로드 파일명,
					실제 다운로드 되는 파일명은 원본 파일명으로 변경하여 다운로드
					-->
					<a href="upload/${store.sto_content_real_file }" download="${store.sto_content_file }">
						${store.sto_content_file }
					</a>
				</td>
				<th width="70">태그</th>
				<td>${store.sto_tag }</td>
				<th width="70">카테고리</th>
				<td>${store.sto_category }</td>
			</tr>
			</table>
		</section>
		
		<section id="articleContentArea">
			${store.sto_content }
		</section>
	</section>
	<section id="commandList">
		<input type="button" value="수정" onclick="location.href='StoreModifyForm.st?sto_idx=${store.sto_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='StoreDeleteForm.st?sto_idx=${store.sto_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='StoreList.st?pageNum=${param.pageNum}'">
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>