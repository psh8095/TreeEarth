<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<section id="qna_writeModifyForm">
		<h1>상품 문의글 수정</h1>
		<form action="StoreQnaModifyPro.st" name="qnaModifyForm" method="post">
			<input type="hidden" name="sto_idx" value="${param.sto_idx }">
			<input type="hidden" name="sto_qna_idx" value="${param.sto_qna_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td><label for="mem_id">작성자</label></td>
					<td>
						<input type="text" name="mem_id" value="${sessionScope.sId }" id="mem_id" required="required" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${store_qna.sto_qna_date }</td>
				</tr>
				<tr>
					<td><label for="mem_pass">비밀번호</label></td>
					<td>
						<input type="password" name="mem_pass" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="sto_qna_content">문의 내용</label></td>
					<td>
						<textarea cols="50" rows="15" id="sto_qna_content" name="sto_qna_content" required="required">${store_qna.sto_qna_content }</textarea>
					</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="수정하기">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>