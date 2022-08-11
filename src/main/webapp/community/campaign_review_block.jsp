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
		<h1>캠페인 후기 신고하기</h1>
		<form action="CampaignReviewBlockPro.cm" method="post">
			<input type="hidden" name="cam_re_idx" value="${param.cam_re_idx }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table id="review">
				<tr>
					<td><label for="cam_re_id">글쓴이</label></td>
					<td><input type="text" name="cam_re_id" value="${campaign_review.cam_re_id }" required="required"></td>
				</tr>
				<tr>
					<td><label for="cam_re_subject">제목</label></td>
					<td>
						<input type="text" name="cam_re_subject" value="${campaign_review.cam_re_subject }" required="required">
					</td>
				</tr>
			</table>
			<table id="review_block">
				<tr>
					<td>신고자</td>
					<td>
						<input type="text" name="cam_re_block_id" value="${sessionScope.sId }" required="required">
					</td>
				</tr>
				<tr>
					<td>신고사유</td>
					<td>
						<textarea id="cam_re_block_content" name="cam_re_block_content" cols="40" rows="15" required="required"></textarea>
					</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="신고하기" onclick="location.href='CampaignReviewBlockPro.cm?cam_re_idx=${campaign_review.cam_re_idx }&cam_re_block_content=${cam_re_block.cam_re_block_content}'">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="window.close()">
			</section>
		</form>
	</section>
</body>
</html>