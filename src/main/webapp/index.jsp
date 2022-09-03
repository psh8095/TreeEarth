<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TreeEarth</title>
<link href="css/index.css" rel="stylesheet">

</head>
<body>


	<div style="position: relative; z-index: 5;">
   	<!-- 헤더 -->
	<jsp:include page="hf/header.jsp" ></jsp:include>
	<!-- 헤더 -->
	</div>
	
	
	
	<!-- 나무 이미지-->
<!-- 	<div > -->
	
<!-- 		<!-- 헤더 산 사진 --> 
<!-- 		<div style=" width:100%; height:800px; background-color: white; position: absolute; z-index: 1; overflow: hidden; "> -->
<!-- 		    <img src="img/main/main_forest.jpg" width="100%" alt="나무"> -->
<!-- 	 	</div> -->
	 	
<!-- 		<!-- 밝기 조절 -->
<!-- 		<div id="backGraound" style=" width:100%; height:800px; background-color: black; position: absolute; z-index: 1; opacity: 0.33;"></div> -->
	
<!-- 	</div> -->
	
		
	
	
 	<!-- 배너 --> 
<%-- 	<jsp:include page="hf/mainBanner.jsp" ></jsp:include> --%>
	<!-- 배너 --> 
	
	<!-- 슬라이드 배너 -->
	<div class="slider" style="position: relative; width:100%; height: 1100px">
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
	
	
    <main style="position: relative;">
  		
<!--   	<div style="position: absolute; z-index: 4;"> -->
<%--   		<jsp:include page="hf/roulette.jsp" ></jsp:include> --%>
<!--   	</div> -->
	
  		
<!-- <!-- 	백그라운드 --> -->
<!--     	<div id="main_back0"> -->
<!--     	    <div> -->
<!--     	     	<div id="backGraound" style=" width:100%; height:100%; background-color: black; position: absolute; z-index: 2; opacity: 0.33;"></div> -->
<!--     	   		<img id="main_fixed" src="img/main/treeearth_text.png" alt="대충 메인 베너1" width="80%"> -->
<!--     		</div> -->
<!--     	</div> -->


		<!-- 이미지 -->
		<div id="main_back1">
	  	</div> 
	  	
		<div id="main_back2">
	  	</div> 
   
   
   </main>
   	<!-- 헤더 -->
	<jsp:include page="hf/footer.jsp" ></jsp:include>
	<!-- 헤더 -->

</body>
</html>