<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>트리어스</title>
<link href="img/main/icon3.png" rel="shortcut icon" type="image/x-icon">
<link href="css/index.css" rel="stylesheet">

<style type="text/css">

	@font-face {
	    font-family: 'GangwonEduPowerExtraBoldA';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduPowerExtraBoldA.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
	}
	
	@font-face {
    font-family: 'EarlyFontDiary';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_220508@1.0/EarlyFontDiary.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
</style>
</head>
<body>


	<div style="position: relative; z-index: 5;">
   	<!-- 헤더 -->
	<jsp:include page="hf/header.jsp" ></jsp:include>
	<!-- 헤더 -->
	</div>
	
	

	<!-- 슬라이드 배너 -->
	<div class="slider" style="position: relative; width:100%; height: 1100px; z-index: 3;">
		   <input type="radio" name="slide" id="slide1" checked>
		   <input type="radio" name="slide" id="slide2">
		   <input type="radio" name="slide" id="slide3">
		   <input type="radio" name="slide" id="slide4">
		   
		  
		   <ul id="imgholder" class="imgs">
		       <li class="main_forest">
	      		    <div class="backGraound" ></div>
		       		<h1>"나무 1그루가 인간 10마리를 살립니다"</h1>
		       		<h2>숲조성을 도와주세요!</h2>
		       		<a href="CampaignList.cp">캠페인 지원하기</a>
		       		<img src="img/main/main_forest.jpg" width="100%" alt="나무">
		       </li>
		       
		       
		       <li class="main_forest">

		      		<div class="backGraound" ></div>
		      		<h1 >"살고 싶으면 나무 심으세요"</h1>
		       		<h2>나무가 사람을 살린다!</h2>
		       		<a href="SupportList.su">돈쭐 내러가기</a>		       		
		       		<img src="img/main/main_forest2.jpg" width="100%" alt="나무">
		       	</li>
		       	
		       	
		       <li class="main_forest">
		       		<div class="backGraound" ></div>
		       		<h1 >"나무야 나무야 서서자는 나무야"</h1>
		       		<h2>나만의 작고 소중한 반려나무 pick!</h2>
		       		<a href="StoreItemList.st?sto_category=반려나무">나무 입양하기</a>		       		
		       		<img src="img/main/main_forest3.jpg" width="100%" alt="나무">
		       	</li>


		       <li class="main_forest">
		     	  	<div class="backGraound" ></div>
		     	  	<h1 >"이래뵈도 정상 영업 중입니다."</h1>
		       		<h2>공지는 좀 읽어주세요 흑우들아!</h2>
		       		<a href="CampaignList.cp">음머어~</a>		       		
		       		<img src="img/main/main_forest4.jpg" width="100%" alt="나무">
		       </li>
		   </ul>
		   		   
		   
		   <div class="bullets">
		       <label for="slide1">&nbsp;</label>
		       <label for="slide2">&nbsp;</label>
		       <label for="slide3">&nbsp;</label>
		       <label for="slide4">&nbsp;</label>
		   </div>
		   
	 </div>
	

	
    <main style="position: relative; text-align: center;">
  		
  	<!-- 	여기야 여기 ---------------------------->
	
<!-- 		<span style=" font-size: 100px;     font-family: 'EarlyFontDiary'; position: absolute; z-index: 3; top:250px; left: 800px; color: #4288eb">모금자</span> -->
<!-- 		<span style=" font-size: 100px;     font-family: 'EarlyFontDiary'; position: absolute; z-index: 3; top:250px; left: 1910px; color: #81c543">모금액</span> -->
		
<!-- 		<span style=" font-size: 100px;     font-family: 'EarlyFontDiary'; position: absolute; z-index: 3; top:400px; left: 905px; ">,</span> -->
<!-- 		<span style=" font-size: 100px;     font-family: 'EarlyFontDiary'; position: absolute; z-index: 3; top:400px; left: 1955px; ">,</span> -->
<!-- 		<span style=" font-size: 100px;     font-family: 'EarlyFontDiary'; position: absolute; z-index: 3; top:400px; left: 2150px; ">,</span> -->

  		
  	
<!--   	<div style="position: absolute; z-index: 2; left: 700px;"> -->
<%--   		<jsp:include page="hf/roulette2.jsp" ></jsp:include> --%>
<!--   	</div>	 -->
  	

<!--   	<div style="position: absolute; z-index: 2; right: 700px;"> -->
<%--   		<jsp:include page="hf/roulette.jsp" ></jsp:include> --%>
<!--   	</div> -->



<!-- 		<hr style="margin: 0px 200px 800px 200px; z-index: 3; opacity: 0" > -->

		<!-- 이미지 -->
		<div style="position:relative; z-index: 3;">
		    <img style="width: 70%" src="img/main/main_img.png" alt="대충 메인 베너1">
	  	</div> 
   
   
   </main>
   	<!-- 헤더 -->
	<jsp:include page="hf/footer.jsp" ></jsp:include>
	<!-- 헤더 -->

</body>
</html>