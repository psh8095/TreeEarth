<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
</head>
<body>

	<h1>캠페인후기 신고글 상세조회</h1>
	
	<table>
		<tr>
			<th>신고글제목</th>
			<td>${campaign_review.cam_re_subject }</td>
		</tr>
		<tr>
			<th>신고글내용</th>
			<td>
				${campaign_review.cam_re_content } <br><br>
				<img alt="${campaign_review.cam_re_file }" src="upload/${campaign_review.cam_re_real_file }">
			</td>
		</tr>
		<tr>
			<th>신고이유</th>
			<td>${cam_re_block.cam_re_block_reason }</td>
		</tr>
	</table>

	<!-- 신고취소 해야될까? 귀찮아.... 일단 주소만 만들어봄..... -->
	<input type="button" value="신고취소" onclick="location.href='CampaignReviewBlockCancel.my?cam_re_block_idx=${cam_re_block.cam_re_block_idx}'">
	<input type="button" value="신고글삭제" onclick="location.href='CampaignReviewBlockDelete.my?cam_re_ref=${cam_re_block.cam_re_block_ref}'">

</body>
</html>