<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<style type="text/css">
	h1 {
		color: #17ab8f;
	}
	
	#su {
		width: 150px;
		color: white;
		background: #7fd49b;
		text-align: center;	
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
		margin-right: 10px;
	}	
</style>
</head>
<body>

	<h1>캠페인후기 신고글 상세조회</h1>
	
	<table>
		<tr>
			<th id=su>신고글제목</th>
			<td>${campaign_review.cam_re_subject }</td>
		</tr>
		<tr>
			<th id=su>신고글내용</th>
			<td>
				${campaign_review.cam_re_content } <br><br>
				<img alt="${campaign_review.cam_re_file }" src="upload/${campaign_review.cam_re_real_file }">
			</td>
		</tr>
		<tr>
			<th id=su>신고이유</th>
			<td>${cam_re_block.cam_re_block_reason }</td>
		</tr>
	</table>
	
	<br>
	<!-- 신고취소 해야될까? 귀찮아.... 일단 주소만 만들어봄..... -->
	<input id="button2" type="button" value="신고취소" onclick="location.href='CampaignReviewBlockCancel.my?cam_re_block_idx=${cam_re_block.cam_re_block_idx}'">
	<input id="button2" type="button" value="신고글삭제" onclick="location.href='CampaignReviewBlockDelete.my?cam_re_ref=${cam_re_block.cam_re_block_ref}'">

</body>
</html>