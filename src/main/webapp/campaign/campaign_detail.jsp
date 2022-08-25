<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="../css/index.css" rel="stylesheet">
<style type="text/css">
	.img {
		padding: 2%;
		text-align: center;
	}
</style>
</head>
<body>
	<div class="img"><img src="img/campaign/${campaign.cam_real_img }" width="100%"></div>
	<div class="img">${campaign.cam_content }</div>
	<div class="img">
		<a href="CampaignApplyForm.cp?cam_idx=${campaign.cam_idx }">캠페인 참가 신청</a>
	</div>
</body>
</html>