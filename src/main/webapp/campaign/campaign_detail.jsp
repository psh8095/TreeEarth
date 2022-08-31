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

#cam_apply{
   width:150px;
   height: 50px;
    background-color: #96e87b  ;
    color: gray;
   font-size: 16px;
   border:1px solid lightgray;
   border-radius: 2px;
   transition:0.3s;
    position: relative;   
    left:75px;
    top:50px;
   transform: translate(-50%,-50%);
}
#cam_apply:focus {
   outline:0;
}
#cam_apply:hover{
   color:black;
   cursor: pointer;
   border:1px solid black;
}
	
</style>
</head>
<body>
	<div class="img"><img src="img/campaign/${campaign.cam_real_img }" width="100%"></div>
	<div class="img">${campaign.cam_content }</div>
	<div class="img">
		<a href="CampaignApplyForm.cp?cam_idx=${campaign.cam_idx }"><button id="cam_apply" type="button">캠페인 참가 신청</button></a>
	</div>
</body>
</html>