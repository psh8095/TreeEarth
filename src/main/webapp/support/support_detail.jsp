<%@page import="vo.support.SupportDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
	// dto 객체 어트리뷰트로 받기
	SupportDTO dto = (SupportDTO)request.getAttribute("dto");
	String sId = (String)session.getAttribute("sId");

	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/support.css" rel="stylesheet">

<script src="js/jquery-3.6.0.js"></script>
	<script type="text/javascript">
		
	
		//제이쿼리
		$(function() {
			
			
		// D-Day 구하기 -----------------------------------------------------------------------------
	    	  
	         //오늘 날짜
	         var today = new Date();
	         
	         //골 날짜
	         var goalDate = $(".goalDate").html();
	         var dday = new Date(goalDate)
	         
	         //디데이 계산
	         var gap = dday.getTime() - today.getTime();
	         var result = Math.ceil(gap / (1000 * 60 * 60 * 24));
	         
	         var day =  1 / result * 100
	        

			
		// 후원금 구하기 -----------------------------------------------------------------------------
	
						    	  
	         //모인 후원금
	         var money = $(".money").html();
			
			 //골 프라이스(전체값)
	         var goalPrice = $(".goalPrice").html();
			
			 //일부값
	         var moneyPer = Number(goalPrice) / Number(money) * 100;;
	        	 
			 if(moneyPer == "Infinity"){
				 moneyPer = 0;
			 }
	        
			
		// 후원금 프로그레스 바 -----------------------------------------------------------------------------
	
		
		         //프로그레스 바 전체
	         $(".progressBar").css({
		           width: "100%",
		           height: "5px",
		           background: "grey"
		         });
	         
		         //프로그레스 바 진행도
	         $(".myBar").css({
		           width: moneyPer+"%",
		           height: "5px",
		           background: "skyblue"
		         });
			
		     //프로그레스 바 진행도 퍼센트
	         $(".moneyPer").html(Math.round(moneyPer)+"%");
	         //디데이
		     $(".dDay").html(result+"일 남음");
	     
		
		// 후원 버튼 -----------------------------------------------------------------------------

			
			//후원 버튼
			$("#giveMoney").on("click", function() {
				var sId = '<%=sId%>'
				if(sId == 'null') {
					alert("로그인 이후 사용해 주세요!");
					window.open("MemberLoginForm.me?returnUrl=SupportList.su");
// 				// 회원만 작성하게 만드세요
				} else if(sId != 'null'){ 
					window.open("GiveMoneyForm.su?idx="+<%=dto.getSup_idx() %>, "giveMoney", "width=1000,height=310");
				}
			});

		});
</script>
		
		


</head>
<body>


   <!-- 해더 -->
   <jsp:include page="../hf/header.jsp"></jsp:include>
   <!-- 해더 -->
   
   
   
	<!-- 디테일 메인 블럭 -->
   <div class="main">


	 <hr style="color: gray; opacity: 70%; margin: 50px;">
	
	
		<!-- 썸네일 -->
		<img id="sup_thumbnai" alt="" src="./img/support/<%=dto.getSup_thumbnail_file() %>" width="70%">

			
			
			
		<!-- 섬네일 옆	 -->
		<div id="content">
			<table >
			
				<!-- 후원 제목 -->
				<tr>
					<td class="sup_subject"><%=dto.getSup_subject() %></td>
					
				</tr>
				
				
				
				<!-- D-Day -->
				<tr>
					<td><span class="dDay"></span></td>
					<td class="goalDate"><%=dto.getSup_goal_date() %></td>
				</tr>
				
				
				
				<!-- 목표 금액 -->
				<tr>
					<td class="money" ><%=dto.getSup_money() %></td>
					<td class="goalPrice" ><%=dto.getSup_goal_price() %></td>
				</tr>
				
		            <tr>
		               <td>
		                  <div class="progressBar"></div>
		                  <div class="myBar"></div>
		                  <span class="money"><%=dto.getSup_money() %></span>원
		                  <span style="text-align: left;" class="moneyPer<%=dto.getSup_idx() %>"></span>
		               </td>
		            </tr>
				
				<!-- idx, date, readcount 안보이게 -->
				<tr style="display: none;">
					<td><%=dto.getSup_date() %></td>
					<td><%=dto.getSup_idx() %></td>
					<td><%=dto.getSup_readcount() %></td>
				</tr>
				
			</table>
			
			
			
			<!-- 후원 버튼 -->			
		 	<button class="w-btn-outline w-btn-green-outline"  id="giveMoney"  type="button" >후원</button>
		
		</div>
		
		
		
		
			<!-- 내용 -->
			<div class="content"><%=dto.getSup_content() %></div>
		
			<!-- 상세 페이지 -->		
			<img id="sup_original" alt="" src="./img/support/<%=dto.getSup_original_file() %>" width="70%">
			
		
		
		
		
	
	   <%if(sId == null){%>
      <section id="List">
      <button class="w-btn w-btn-gra2 w-btn-gra-anim" type="button" onclick="location.href='SupportList.su<%--?sup_idx=<%=dto.getSup_idx() %> &pageNum=${param.pageNum}  --%>'">목록</button>   
      </section>

      <%}else if(sId.equals("admin")){%>
       
            <button class="w-btn w-btn-gra2 w-btn-gra-anim"  type="button" onclick="location.href='SupportModifyAdmin.su?sup_idx=${dto.sup_idx }&pageNum=${param.pageNum}'">수정</button>
            <button class="w-btn w-btn-gra2 w-btn-gra-anim" onclick="location.href='SupportDeleteFormAdmin.su?sup_idx=${dto.sup_idx}&pageNum=${param.pageNum}'">삭제</button>
            <button class="w-btn w-btn-gra2 w-btn-gra-anim" type="button" onclick="location.href='SupportList.su<%--?sup_idx=<%=dto.getSup_idx() %> &pageNum=${param.pageNum}  --%>'">목록</button>
         <%}else{ %>
  
      <button class="w-btn w-btn-gra2 w-btn-gra-anim" type="button" onclick="location.href='SupportList.su<%--?sup_idx=<%=dto.getSup_idx() %> &pageNum=${param.pageNum}  --%>'">목록</button>   
 
      
      <%}%>   
	</div>
	
	<!-- 푸터 -->
   <jsp:include page="../hf/footer.jsp"></jsp:include>
   <!-- 푸터 -->
	
</body>
</html>