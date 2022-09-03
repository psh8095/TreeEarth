<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 - 상품등록</title>
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
	}
	
	table {
		margin: auto;
		width: 450px;
		color: white;
	}
	
	.td_left {
		width: 150px;
		background: #c5e096;
		text-align: center;
	}
	
	#button {
		margin-right: 9in;
		position: absolute;
		bottom: -1cm;
		right: 3px;	
			 
	}

	
	#button2 {
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
	
	<!-- 게시판 등록 -->
	<section id="writeForm">
		<h1>스토어 상품 등록</h1>
		<!-- 
		form 데이터 중 파일 정보가 포함될 경우
		<form> 태그 속성에 enctype="multipart/form-data" 명시 필수!
		(생략 시 enctype="application/x-www-form-urlencoded" 속성이 기본값으로 설정됨)
		-->
		<form action="StoreWritePro.st" name="storeForm" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="td_left"><label for="sto_subject">상품 제목</label></td>
					<td class="td_right"><input type="text" name="sto_subject" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_price">상품 가격</label></td>
					<td class="td_right"><input type="text" name="sto_price" required="required" />원</td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_content">상품 내용</label></td>
					<td class="td_right">
						<textarea id="board_content" name="sto_content" cols="40" rows="15" required="required"></textarea>
				</td>
				<tr>
					<td class="td_left"><label for="sto_thum_file">썸네일 이미지 첨부</label></td>
					<!-- 파일 첨부 형식은 input 태그의 type="file" 속성 사용 -->
					<td class="td_right"><input type="file" name="sto_thum_file" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_content_file">상세페이지 이미지 첨부</label></td>
					<!-- 파일 첨부 형식은 input 태그의 type="file" 속성 사용 -->
					<td class="td_right"><input type="file" name="sto_content_file" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="sto_tag">상품 태그</label></td>
					<td class="td_right"><input type="text" name="sto_tag" placeholder="#" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left">상품 분류</td>
					<td>
						<select id="selectBox" name="sto_category">
							<option value="선택하세요">선택하세요</option>
							<option value="반려나무">반려나무</option>
							<option value="식물">식물</option>
							<option value="부자재">부자재</option>
						</select>
					</td>
				</tr>
			</table>

			<section id="button">
				<button id="button2" type="submit" value="등록">등록</button>
				<button id="button2" type="reset" value="다시쓰기">다시쓰기</button>
				<button id="button2" type="button" value="취소" onclick="history.back()">취소</button>
			</section>
		</form>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>








