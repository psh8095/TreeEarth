<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TreeEarth</title>
<link href="css/index.css" rel="stylesheet">
</head>
<style type="text/css">	
	#writeForm {
		width: 500px;
		height: 450px;
		border: 1px #c5e096;
		margin: auto;
	}
	
	h2 {
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
		bottom: 8px;
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
	<jsp:include page="../hf/header.jsp"></jsp:include>
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<section id="writeForm">
		<h2>후원 등록</h2>
		<form action="SupportWriteProAdmin.su" method="post"
			enctype="multipart/form-data" name="boardForm" >
			<input type="hidden" name="mem_id" value="${param.mem_id }">
			<table>
				<tr>
					<td class="td_left"><label for="sup_subject">제목</label></td>
					<td class="td_right"><input type="text" name="sup_subject"
						id="board_name" required="required"></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="sup_pass">비밀번호</label></td> -->
<!-- 					<td class="td_right"><input type="password" name="sup_pass" -->
<!-- 						id="board_pass" required="required"></td> -->
<!-- 				</tr> -->
				
				<tr>
					<td class="td_left"><label for="sup_goal_price">목표 금액</label></td>
					<td class="td_right"><input type="text" name="sup_goal_price"
						id="board_subject" required="required"></td>
				</tr>
				
				
				
				<tr>
					<td class="td_left"><label for="">목표 날짜</label></td>
					<td class="td_right"><input type="date" name="sup_goal_date"
						id="board_name" required="required"></td>
				</tr>
				
				
				
				
				<tr>
					<td class="td_left"><label for="sup_content">내용</label></td>
					<td><textarea name="sup_content" rows="15" cols="40" required="required"></textarea>
					</td>
				</tr>
				
				
				<tr>
					<td class="td_left"><label for="sup_thumbnail_file">썸네일 파일 첨부</label></td>
					<td class="td_right"><input name="sup_thumbnail_file" type="file"
						 required="required"></td>
				</tr>
				
				
				<tr>
					<td class="td_left"><label for="sup_original_file">파일 첨부</label></td>
					<td class="td_right"><input name="sup_original_file" type="file"
						 required="required"></td>
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