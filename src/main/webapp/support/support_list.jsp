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
<link href="css/button.css" rel="stylesheet">
<script>
function giveMoney() {
	window.open("GiveMoneyForm.su", "giveMoney", "width=600,height=400");
// 	window.open(url, name, specs, replace);
}
</script>
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
			
			
			//디데이 진행도
			$("#progressBar").css({
			  width: "100%",
			  background: "grey"
			});
			
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
	
	
		<h1>후원 목록</h1>
		<div style="float: left; width: 30%;">
<!-- 		<a href="SupportWriteFormAdmin.su">글쓰기</a> -->
		
<!-- 		글 목록 -->
			<section id="listForm">
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
			</section>
			</div>
			
<!-- 			앨범형 -->
			<div style="clear: both;">
			<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='SupportListAction.su?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<c:choose>
				<c:when test="${pageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="SupportListAction.su?pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='SupportListAction.su?pageNum=${pageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>