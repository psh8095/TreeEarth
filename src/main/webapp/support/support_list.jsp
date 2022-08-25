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
<!-- 스크립트 -->
<script>
	function giveMoney() {
	   window.open("GiveMoneyForm.su", "giveMoney", "width=600,height=400");
	//    window.open(url, name, specs, replace);
	}
</script>
<script src="js/jquery-3.6.0.js"></script>
</head>



<body>
   <!-- 해더 -->
   <jsp:include page="../hf/header.jsp"></jsp:include>
   <!-- 해더 -->
   
   
	<!--  전체의 기준이 되는 태그 -->
   
	<!-- 후원 메인 블럭 -->
   <main >
   
		   <hr style="color: gray; opacity: 70%; padding: 50px;">
		   
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
					         </script>
			            </td>
			         </tr>
			         
			         
			      </table>
			  </div>
			  <%} %>   
			</div>
	
	</main>         
        
         
   <!-- 푸터 -->
   <section id ="foot">
   <jsp:include page="../hf/footer.jsp"></jsp:include>
   </section>
   <!-- 푸터 -->
      
</body>
</html>