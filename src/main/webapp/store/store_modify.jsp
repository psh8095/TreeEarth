<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 된 상품을 수정하는 페이지</title>
<style type="text/css">
	#modifyForm {
		width: 600px;
		height: 550px;
		border: 1px solid red;
		margin: auto;
	}
	
	h1 {
		text-align: center;
	}
	
	table {
		margin: auto;
		width: 450px;
	}
	
	.td_left {
		width: 150px;
		background: orange;
		text-align: center;
	}
	
	.td_right {
		width: 300px;
		background: skyblue;
	}
	
	#commandCell {
		text-align: center;
	}
</style>
</head>
<body>
	<!-- 게시판 글 수정 -->
	<section id="modifyForm">
		<h1>등록 된 상품 수정</h1>
		<form action="StoreModifyPro.st" name="boardForm" method="post">
			<!-- 게시물 수정에 필요한 글번호와 페이징 처리에 필요한 페이지번호도 함께 전달 -->
			<input type="hidden" name="sto_idx" value="${param.sto_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td class="td_left"><label for="sto_subject">상품 이름</label></td>
					<td class="td_right">
						<input type="text" name="sto_subject" value="${store.sto_subject }" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_price">상품 가격</label></td>
					<td class="td_right">
						<input type="text" name="sto_price" value="${store.sto_price }" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_content">상품 설명</label></td>
					<td class="td_right">
						<textarea rows="15" cols="40" name="sto_content" required="required">${store.sto_content }</textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_tag">태그</label></td>
					<td class="td_right">
						<input type="text" name="sto_tag" value="${store.sto_tag }" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_category">카테고리</label></td>
					<td class="td_right">
						<input type="text" name="sto_category" value="${store.sto_category }" required="required">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_content_file">첨부파일</label></td>
					<!-- 파일 수정 기능은 제외(파일명만 표시) -->
					<td class="td_right">${store.sto_content_file }(수정불가)</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="수정">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
</body>
</html>








