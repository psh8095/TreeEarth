<%@page import="vo.support.SupportDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
   // 리스트 객체 어트리뷰트로 받기
   ArrayList<SupportDTO> List = (ArrayList<SupportDTO>)request.getAttribute("SupportList");
   
   %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="style.css" rel="stylesheet"> -->
<link href="css/support.css" rel="stylesheet">
<style type="text/css">
/* 위로 올라가기 버튼 */
body {
	font: .88em/150% Arial, Helvetica, sans-serif;
	margin: 30px auto;
}
h1 {
	font: bold 80%/120% Arial, Helvetica, sans-serif;
	text-transform: uppercase;
	margin: 0 0 10px;
	color: #999;
}
h2 {
	font-size: 2.5em;
	margin: 0 0 8px;
}
h3 {
	font-size: 1.6em;
	margin: 20px 0 5px;
}
a {
	color: #69C;
	text-decoration: none;
}
a:hover {
	color: #F30;
}
p {
	margin: 0 0 10px;
}
.credits {
	border-bottom: solid 1px #eee;
	padding-bottom: 10px;
	margin: 0 0 30px;
}
#pagewrap {
	margin: 0 auto;
	width: 600px;
	padding-left: 150px;
	position: relative;
}

/*
Back to top button 
*/
#back-top {
	position: fixed;
	bottom: 30px;
	margin-left: -150px;
}
#back-top a {
	width: 108px;
	display: block;
	margin-left:1200px;
	text-align: center;
	font: 11px/100% Arial, Helvetica, sans-serif;
	text-transform: uppercase;
	text-decoration: none;
	color: #bbb;
	/* background color transition */
	-webkit-transition: 1s;
	-moz-transition: 1s;
	transition: 1s;
}
#back-top a:hover {
	color: #000;
}
/* arrow icon (span tag) */
#back-top span {
	width: 108px;
	height: 108px;
	display: block;
	margin-bottom: 7px;
	background: #ddd url(up-arrow.png) no-repeat center center;
	/* rounded corners */
	-webkit-border-radius: 15px;
	-moz-border-radius: 15px;
	border-radius: 15px;
	/* background color transition */
	-webkit-transition: 1s;
	-moz-transition: 1s;
	transition: 1s;
}
#back-top a:hover span {
	background-color: #777;
}
</style>
<!-- 스크립트 -->
<script>
	function giveMoney() {
	   window.open("GiveMoneyForm.su", "giveMoney", "width=600,height=400");
	//    window.open(url, name, specs, replace);
	}
</script>
<script src="js/jquery-3.6.0.js"></script>
</head>



<body id="top">
   <!-- 해더 -->
   <jsp:include page="../hf/header.jsp"></jsp:include>
   <!-- 해더 -->
   
   
	<!--  전체의 기준이 되는 태그 -->
   
	<!-- 후원 메인 블럭 -->
   <main >
   
	 <hr style="color: gray; opacity: 70%; margin: 50px;">
		   
			<!-- 글 목록 -->
		   <div class="main">
		         <%for(Object o : List){
		            SupportDTO support = (SupportDTO)o; 
		         %>
		      <div class="list">
		         <table>
		         
		
		            <tr>
		               <td>
		             	 <span class="dDay<%=support.getSup_idx() %>"></span>
		               </td>
		            </tr>
		            
		            <tr>
		               <td>
		                  <a  href ="SupportDetail.su?sup_idx=<%=support.getSup_idx() %>">
		                  <img class="img" alt="썸네일" src="img/support/<%=support.getSup_thumbnail_file()%>" ></a>
		               </td>
		            </tr>
		                     
		            <tr>
		               <td>
		              	 <a class="subject" href ="SupportDetail.su?sup_idx=<%=support.getSup_idx() %>"><%=support.getSup_subject()%></a>
		               </td>
		            </tr>
		            
		            <tr>
		               <td>
		                  <div class="progressBar<%=support.getSup_idx() %>"></div>
		                  <div class="myBar<%=support.getSup_idx() %>"></div>
		                  <span class="money<%=support.getSup_idx() %>"><%=support.getSup_money() %></span>원
		                  <span style="text-align: left;" class="moneyPer<%=support.getSup_idx() %>"></span>
		               </td>
		            </tr>
		            
		            
		            <tr>
		               <td>
							<!--  제이쿼리용 디스플레이 none 처리 -->
		                  <div style="display: none;" class="money<%=support.getSup_idx() %>"><%=support.getSup_money() %></div>
		                  <div style="display: none;" class="goalPrice<%=support.getSup_idx() %>"><%=support.getSup_goal_price() %></div>
		                  <div style="display: none;" class="goalDate<%=support.getSup_idx() %>"><%=support.getSup_goal_date() %></div>
		               </td>
		            </tr>
		            
		            
		            <tr>
		           		<td>
				            <script type="text/javascript">
						      //제이쿼리
						      $(function() {
									
		
						    	 // D-Day 구하기 -----------------------------------------------------------------------------
						    	  
							         //오늘 날짜
							         var today = new Date();
							         
							         //골 날짜
							         var goalDate = $(".goalDate<%=support.getSup_idx() %>").html();
							         var dday = new Date(goalDate)
							         
							         //디데이 계산
							         var gap = dday.getTime() - today.getTime();
							         var result = Math.ceil(gap / (1000 * 60 * 60 * 24));
							         
							         var day =  1 / result * 100
							         
						         
						    	 //  D-Day 프로그레스 바 -----------------------------------------------------------------------------
		
						         
			// 				         //프로그레스 바 전체
			<%-- 				         $(".progressBar<%=support.getSup_idx() %>").css({ --%>
			// 				           width: "100%",
			// 				           background: "grey"
			// 				         });
							         
			// 				         //프로그레스 바 진행도
			<%-- 				         $(".myBar<%=support.getSup_idx() %>").css({ --%>
			// 				           width: day+"%",
			// 				           height: "30px",
			// 				           background: "skyblue"
			// 				         });
									
			// 				         //프로그레스 바 진행도 퍼센트
			<%-- 				         $(".myBar<%=support.getSup_idx() %>").html(Math.round(day)+"%"); --%>
			
			
			
								// 후원금 구하기 -----------------------------------------------------------------------------
							
												    	  
							         //모인 후원금
							         var money = $(".money<%=support.getSup_idx() %>").html();
									
									 //골 프라이스(전체값)
							         var goalPrice = $(".goalPrice<%=support.getSup_idx() %>").html();
									
									 //일부값
							         var moneyPer = Number(goalPrice) / Number(money) * 100;;
							        	 
									 if(moneyPer == "Infinity"){
										 moneyPer = 0;
									 }
							        	 
									 
									
								// 후원금 프로그레스 바 -----------------------------------------------------------------------------
							
								
								         //프로그레스 바 전체
							         $(".progressBar<%=support.getSup_idx() %>").css({
								           width: "100%",
								           height: "5px",
								           background: "grey"
								         });
							         
								         //프로그레스 바 진행도
							         $(".myBar<%=support.getSup_idx() %>").css({
								           width: moneyPer+"%",
								           height: "5px",
								           background: "skyblue"
								         });
									
								     //프로그레스 바 진행도 퍼센트
							         $(".moneyPer<%=support.getSup_idx() %>").html(Math.round(moneyPer)+"%");
							         //디데이
								     $(".dDay<%=support.getSup_idx() %>").html(result+"일 남음");
							     
							     
		
						      });      
						      
							// back to top 버튼 -----------------------------------------------------------------------------
										$(document).ready(function(){
							
											// 사용하지 않을 때 숨김처리
											$("#back-top").hide();
											
											// 사라지기 효과
											$(function () {
												$(window).scroll(function () {
													if ($(this).scrollTop() > 100) {
														$('#back-top').fadeIn();
													} else {
														$('#back-top').fadeOut();
													}
												});
							
												// scroll body to 0px on click
												$('#back-top a').click(function () {
													$('body,html').animate({
														scrollTop: 0
													}, 800);
													return false;
												});
											});
							
										});
					         </script>
			            </td>
			         </tr>
			         
			         
			      </table>
			  </div>
			  <%} %>   
			</div>
	
	</main>         
	
	<div id="pagewrap">
		<p id="back-top">
			<a href="#top"><span></span>Back to Top</a>
		</p>
	</div>
        
         
   <!-- 푸터 -->
   <jsp:include page="../hf/footer.jsp"></jsp:include>
   <!-- 푸터 -->
      
</body>
</html>