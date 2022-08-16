<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 - 상품목록</title>
</head>
<body>
	<section id="listForm">
		<h1>등록 된 상품목록</h1>
		<table>
			<tr id="tr_top">
				<td width="100">상품 번호</td>
				<td width="100"> 상품 제목</td>
				<td width=100>상품 가격</td>
				<td width="100">상품 내용</td>
				<td width="100">상품 태그</td>
				<td width="100">상품 분류</td>
			</tr>
		</table>
	</section>
	<section id="buttonArea">
		<input type="button" value="상품 등록" onclick="location.href='store_write.jsp'">
		<input type="button" value="상품 삭제" onclick="location.href='store_deleteAction.jsp'">
	</section>
	<section id="pageList">		
	</section>
</body>
</html>