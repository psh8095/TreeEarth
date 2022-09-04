<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="../css/index.css" rel="stylesheet">
<style type="text/css">

#cam_apply{
	width:500px;
	height: 100px;
    background-color: #c5e096;  ;
    color: black;
    font:bold;
    font-size: 50px;
    border:1px solid lightgray;
    border-radius: 2px;
    transition:0.3s;
    position: relative;   
    left:250px;
    top:100px;
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
	
	<div class="cam_main_div">	
	
		<hr style="color: gray; opacity: 70%; width: 70%; display: block; margin: 50px auto;" >
	
	
		<div class="cam_img_div1">
			<div class="cam_sub_img"><img alt="" src="img/campaign/${campaign.cam_img }"></div>
			<div style=" width:100%; height:500px; background-color: black; position: absolute; z-index: 1; opacity: 0.20;"></div>
			<div class="cam_sub_span"><span>${campaign.cam_content }</span></div>
		</div>
		
			
		
		<div class="cam_img_div2">
			<img alt="" src="img/campaign/${campaign.cam_img }">
		</div>
		
		
		
		<div class="img">
			<a href="CampaignApplyForm.cp?cam_idx=${campaign.cam_idx }"><button id="cam_apply" type="button">캠페인 참가 신청</button></a>
		</div>
		
		
	</div>
	
</body>
</html>