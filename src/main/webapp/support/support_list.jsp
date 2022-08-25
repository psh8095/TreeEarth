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
   
   
	<!-- 후원 메인 블럭 -->
   <main >
   
	<!-- 글 목록 -->
   <div class="main">
         <%for(Object o : List){
            SupportDTO support = (SupportDTO)o; 
         %>
      <div class="list">
         <table>
         
         
            <tr>
               <td>
              	 <h3><a  href ="SupportDetail.su?sup_idx=<%=support.getSup_idx() %>">제목 : <%=support.getSup_subject()%></a></h3>
               </td>
            </tr>
            
            <tr>
               <td>
                  <a  href ="SupportDetail.su?sup_idx=<%=support.getSup_idx() %>">
                  <img alt="썸네일" src="img/support/<%=support.getSup_thumbnail_file()%>" ></a>
               </td>
            </tr>
            
            <tr>
               <td>
                  <div class="progressBar<%=support.getSup_idx() %>"></div>
                  <div class="myBar<%=support.getSup_idx() %>"></div>
               </td>
            </tr>
            
            
            <tr>
               <td>
                  <div style="display: none;" class="goalDate<%=support.getSup_idx() %>"><%=support.getSup_goal_date() %></div>
               </td>
            </tr>
            
            
            <tr>
           		<td>
		            <script type="text/javascript">
				      //제이쿼리
				      $(function() {
				         
				         //오늘 날짜
				         var today = new Date();
				         
				         //골 날짜
				         var goalDate = $(".goalDate<%=support.getSup_idx() %>").html();
				         var dday = new Date(goalDate)
				         
				         //디데이 계산
				         var gap = dday.getTime() - today.getTime();
				         var result = Math.ceil(gap / (1000 * 60 * 60 * 24));
				         
				         var day =  1 / result * 100
				         
				         
				         //디데이 진행도
				         $(".progressBar<%=support.getSup_idx() %>").css({
				           width: "100%",
				           background: "grey"
				         });
				         
				         $(".myBar<%=support.getSup_idx() %>").css({
				           width: day+"%",
				           height: "30px",
				           background: "skyblue"
				         });
				
				         $(".myBar<%=support.getSup_idx() %>").html(Math.round(day)+"%");
				      });      
			         </script>
	            </td>
	         </tr>
	         
	         
	      </table>
	  </div>
	  <%} %>   
	</div>
	
	</main>         
        
         
<!--    <!-- 푸터 --> -->
<!--    <section id ="foot"> -->
<%--    <jsp:include page="../hf/footer.jsp"></jsp:include> --%>
<!--    </section> -->
<!--    <!-- 푸터 --> -->
   
   
   
</body>
</html>