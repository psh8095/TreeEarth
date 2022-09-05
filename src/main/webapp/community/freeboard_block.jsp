<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기</title>
<style type="text/css">
	#blockForm {
		width: 500px;
		height: 450px;
		border: 1px #c5e096;
		margin: auto;
	}
	
	h1 {
		color: #c5e096;
		margin: auto;
	}
	
	block {
		margin: auto;
		width: 450px;
		color: white;
	}
	
	.td_left {
		width: 150px;
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
	<section id="blockForm">
		<h1>자유게시판 신고하기</h1>
		<form action="FreeBoardBlockPro.cm" method="post">
			<input type="hidden" name="free_idx" value="${param.free_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table id="block">
				<tr>
					<td id="td_left"><label for="free_name">글쓴이</label></td>
					<td><input type="text" name="free_name" value="${freeboard.free_name }" required="required"></td>
				</tr>
				<tr>
					<td id="td_left"><label for="free_subject">제목</label></td>
					<td>
						<input type="text" name="free_subject" value="${freeboard.free_subject }" required="required">
					</td>
				</tr>
			</table>
			
			<table id="free_block">
				<tr>
					<td id="td_left">신고자</td>
					<td>
						<input type="text" name="free_block_id" value="${sessionScope.sId }" required="required">
					</td>
				</tr>
				<tr>
					<td id="td_left">신고사유</td>
					<td>
						<textarea id="free_block_reason" name="free_block_reason" cols="40" rows="15" required="required"></textarea>
					</td>
				</tr>
			</table>
			<section>
				<input id="button2" type="submit" value="신고하기" onclick="location.href='FreeBoardBlockPro.cm?free_idx=${freeboard.free_idx }&free_block_reason=${free_block.free_block_reason}'">&nbsp;&nbsp;
				<input id="button2" type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input id="button2" type="button" value="취소" onclick="window.close()">
			</section>
		</form>
	</section>
</body>
</html>