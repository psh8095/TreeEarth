<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 - 상품등록</title>
</head>
<body>
	<!-- 게시판 등록 -->
	<section id="writeForm">
		<h1>상품 등록(관리자페이지)</h1>
		<!-- 
		form 데이터 중 파일 정보가 포함될 경우
		<form> 태그 속성에 enctype="multipart/form-data" 명시 필수!
		(생략 시 enctype="application/x-www-form-urlencoded" 속성이 기본값으로 설정됨)
		-->
		<form action="AdminStoreWritePro.st" name="boardForm" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="td_left"><label for="sto_idx">상품 번호</label></td>
					<td class="td_right"><input type="text" name="sto_idx" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_thum_file">썸네일 이미지 첨부</label></td>
					<!-- 파일 첨부 형식은 input 태그의 type="file" 속성 사용 -->
					<td class="td_right"><input type="file" name="sto_thum_file" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_subject">상품 제목</label></td>
					<td class="td_right"><input type="text" name="sto_subject" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_price">상품 가격</label></td>
					<td class="td_right"><input type="text" name="sto_price" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_content">상품 내용</label></td>
					<td class="td_right">
						<textarea id="board_content" name="sto_content" cols="40" rows="15" required="required"></textarea>
					</td>
				<tr>
					<td class="td_left"><label for="sto_content_file">상세페이지 이미지 첨부</label></td>
					<!-- 파일 첨부 형식은 input 태그의 type="file" 속성 사용 -->
					<td class="td_right"><input type="file" name="sto_content_file" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_tag">상품 태그</label></td>
					<td class="td_right"><input type="text" name="sto_tag" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_category">상품 분류</label></td>
					<td class="td_right"><input type="text" name="sto_category" required="required" /></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
</body>
</html>








