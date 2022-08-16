<%@page import="vo.support.SupportDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	// 리스트 객체 어트리뷰트로 받기
	ArrayList<SupportDTO> List = (ArrayList<SupportDTO>)request.getAttribute("SupportList");
	
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.js"></script>
	<script type="text/javascript">
		
	
		//제이쿼리
		$(function() {
			
			//오늘 날짜
			var today = new Date();
			
			//골 날짜
			var goalDate = $("#goalDate").html();
			var dday = new Date(goalDate)
			
			//디데이 계산
			var gap = dday.getTime() - today.getTime();
			var result = Math.ceil(gap / (1000 * 60 * 60 * 24));
			
			var day =  1 / result * 100
			
			
			
			//프로그레스 바
			$("#progressBar").css({
			  width: "100%",
			  background: "grey"
			});
			
			//
			$("#myBar ").css({
			  width: day+"%",
			  height: "30px",
			  background: "green"
			});

		});
		
		

		
</script>
</head>
<body>
	<!-- 해더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 해더 -->
	
	
		<h1>후원 리스트</h1>
		
		<a href="SupportWriteFormAdmin.su">글쓰기</a>
		
			
			<%for(Object o : List){
				SupportDTO support = (SupportDTO)o; 
			%>
				
				<h3><a  href ="SupportDetail.su?sup_idx=<%=support.getSup_idx() %>">제목 : <%=support.getSup_subject()%></a></h3>
				<a  href ="SupportDetail.su?sup_idx=<%=support.getSup_idx() %>"><img alt="썸네일" src="img/support/<%=support.getSup_thumbnail_file()%>" width="30%"></a>
				
				<div id="progressBar">
			  		<div id="myBar"></div>
				</div>
				
				<div id="goalDate"><%=support.getSup_goal_date() %></div>
					
			<%} %>


	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>