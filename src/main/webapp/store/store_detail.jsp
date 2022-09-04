<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/button.css" rel="stylesheet">
<style type="text/css">
	#writeForm {
		width: 500px;
		height: 450px;
		border: 1px #c5e096;
		margin: auto;
	}
	
	h1 {
		text-align: center;
		color: #c5e096;
		padding: 20px;
	}
	
	.table {
		margin: auto;
		width: 450px;
		color: c5e096;
	}
	
	.td_left {
		width: 150px;
		background: #c5e096;
		text-align: center;
		color: white;
	}
	
	#button {
		margin: 0 auto;
		text-align: center;
	}
	
	
	#button2 {
		text-align: center;
		color: white; 
		padding: 4px 10px;
		background-color: #c5e096;
		display: inline-block;
		border: 1px solid rgba(0,0,0,0.21);
		border-bottom-color: rgba(0,0,0,0.34);
		text-shadow:0 1px 0 rgba(0,0,0,0.15);
		box-shadow: 0 1px 0 rgba(255,255,255,0.34) inset, 
		            0 2px 0 -1px rgba(0,0,0,0.13), 
		            0 3px 0 -1px rgba(0,0,0,0.08), 
		            0 3px 13px -1px rgba(0,0,0,0.21);
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
	<section id="writeForm">
		<h1>등록 된 상품을 상세조회하는 페이지</h1>
		<section>
			<table id="table">
			<tr><th class="td_left">상품 이름</th><td colspan="3" >${store.sto_subject }</td></tr>
			<tr>
				<th class="td_left">상품 가격</th><td>${store.sto_price } 원</td>
				<th class="td_left">작성일</th><td>${store.sto_date }</td>
			</tr>
			<tr>
				<th class="td_left">첨부파일</th>
				<td>
					<!-- 
					파일명은 원본 파일명을 표시하고, 다운로드 파일 대상은 실제 업로드 파일명,
					실제 다운로드 되는 파일명은 원본 파일명으로 변경하여 다운로드
					-->
					<a href="upload/${store.sto_content_real_file }" download="${store.sto_content_file }">
						${store.sto_content_file }
					</a>
				</td>
				<th class="td_left">태그</th>
				<td>${store.sto_tag }</td>
				<th class="td_left">카테고리</th>
				<td>${store.sto_category }</td>
			</tr>
			</table>
		</section>
		
		<section>
			${store.sto_content }
		</section>
	</section>
	
	<section id="button">
		<input id="button2" type="button" value="수정" onclick="location.href='StoreModifyForm.st?sto_idx=${store.sto_idx}&pageNum=${param.pageNum}'">
		<input id="button2" type="button" value="삭제" onclick="location.href='StoreDeleteForm.st?sto_idx=${store.sto_idx}&pageNum=${param.pageNum}'">
		<input id="button2" type="button" value="목록" onclick="location.href='StoreList.st?pageNum=${param.pageNum}'">
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>