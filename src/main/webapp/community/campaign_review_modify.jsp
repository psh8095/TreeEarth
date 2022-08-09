<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<section id="writeForm">
		<h1>캠페인 후기 수정</h1>
		<form action="CampaignReviewModifyPro.cm" method="post">
			<input type="hidden" name="cam_re_idx" value="${param.cam_re_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<td><label for="cam_re_id">글쓴이</label></td>
					<td><input type="text" name="cam_re_id" required="required"></td>
				</tr>
				<tr>
					<td><label for="mem_pass">비밀번호</label></td>
					<td>
						<input type="password" name="mem_pass" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="cam_re_subject">제목</label></td>
					<td>
						<input type="text" name="cam_re_subject" value="${campaign_review.cam_re_subject }" required="required">
					</td>
				</tr>
				<tr>
					<td><label for="cam_re_content">내용</label></td>
					<td>
						<textarea id="cam_re_content" name="cam_re_content" cols="40" rows="15" required="required">
							${campaign_review.cam_re_content }
						</textarea>
					</td>
				</tr>
				<tr>
					<td><label for="cam_re_file">파일</label></td>
					<td>${campaign_review.cam_re_file }</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="수정" onclick="location.href='CampaignReviewList.cm?pageNum=${param.pageNum}'">&nbsp;&nbsp;
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