<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기</title>
</head>
<body>
	<section id="">
		<h1>자유게시판 신고하기</h1>
		<form action="FreeBoardBlockPro.cm" method="post">
			<input type="hidden" name="free_idx" value="${param.free_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table id="review">
				<tr>
					<td><label for="free_name">글쓴이</label></td>
					<td><input type="text" name="free_name" value="${freeboard.free_name }" required="required"></td>
				</tr>
				<tr>
					<td><label for="free_subject">제목</label></td>
					<td>
						<input type="text" name="free_subject" value="${freeboard.free_subject }" required="required">
					</td>
				</tr>
			</table>
			<table id="free_block">
				<tr>
					<td>신고자</td>
					<td>
						<input type="text" name="free_block_id" value="${sessionScope.sId }" required="required">
					</td>
				</tr>
				<tr>
					<td>신고사유</td>
					<td>
						<textarea id="free_block_reason" name="free_block_reason" cols="40" rows="15" required="required"></textarea>
					</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="신고하기" onclick="location.href='FreeBoardBlockPro.cm?free_idx=${freeboard.free_idx }&free_block_reason=${free_block.free_block_reason}'">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="window.close()">
			</section>
		</form>
	</section>
</body>
</html>