<%@page import="vo.support.SupportDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
	// dto 객체 어트리뷰트로 받기
	SupportDTO dto = (SupportDTO)request.getAttribute("dto");
	
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/button.css" rel="stylesheet">

<style type="text/css">
	#articleForm {
		width: 1000px;
		height: 550px;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		border: 1px solid black;
		border-collapse: collapse; 
	 	width: 1000px;
	 	margin-left:auto;
		margin-right:auto;
	 	
	}
	
	th {
		text-align: center;
	}
	
	td {
		width: 150px;
		text-align: center;
	}
	
	#basicInfoArea {
		height: auto;
		text-align: center;
	}
	
	#articleContentArea {
/* 		background: orange; */
		margin-top: 20px;
		width:auto;
		height: 350px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
	#commandList {
		margin-top: 50px;
		width: auto;
		text-align: center;
	}
</style>


<script src="js/jquery-3.6.0.js"></script>
	<script type="text/javascript">
		
	
		//제이쿼리
		$(function() {
			
			
			//오늘 날짜
			var today = new Date();
			
			//골 날짜
			var goalDate = <%=dto.getSup_goal_date() %>
			var dday = new Date(goalDate)
			
			//디데이 계산
			var gap = dday.getTime() - today.getTime();
			var result = Math.ceil(gap / (1000 * 60 * 60 * 24));
			
			//디데이 표시
			$("#dday").html(result);
			

		});
		
		
</script>


<script>
// 기브머니
function giveMoney() {
	window.open("GiveMoneyForm.su?idx="+<%=dto.getSup_idx()%>, "giveMoney", "width=600,height=450");
// 	window.open(url, name, specs, replace);
}
</script>


</head>
<body>
<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 게시판 상세내용 보기 -->
	<section id="articleForm">
		<h2>후원 작성</h2>
		<section id="basicInfoArea">
			<table border="1">
			
<!-- 			글 번호를 데리고 왔는지 확인하기 위한 작업 -->
			<tr>
				<th width="70">글 번호</th><td><%=dto.getSup_idx() %></td>
			</tr>
			<tr><th width="70">제 목</th><td colspan="3" ><%=dto.getSup_subject() %></td>
			</tr>
			<tr>
				<th width="70">작성일</th><td><%=dto.getSup_date() %></td>
			</tr>
			<tr>
				<th width="70">조회수</th>
				<td><%=dto.getSup_readcount() %></td>
			</tr>
			<tr>
				<th width="70">D-Day</th>
				<td id="goalDate"><%=dto.getSup_goal_date() %></td>
			</tr>
				<tr>
				<th width="70">목표 금액</th>
				<td><%=dto.getSup_goal_price() %></td>
			</tr>
			</table>
				   <button class="w-btn-outline w-btn-green-outline" type="button" onclick="giveMoney()">
        후원
    </button>
		</section>
	
		<section id="articleContentArea">
			<img alt="" src="./img/support/<%=dto.getSup_thumbnail_file() %>" width="70%">
			<img alt="" src="./img/support/<%=dto.getSup_original_file() %>" width="70%">
			<%=dto.getSup_content() %>
		</section>
	</section>
	<section id="commandList">
	<input type="button" value="수정" onclick="location.href='SupportModifyAdmin.su?sup_idx=${dto.sup_idx }&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='SupportDeleteFormAdmin.su?sup_idx=${dto.sup_idx}&pageNum=${param.pageNum}'">
		<button class="w-btn w-btn-gra2 w-btn-gra-anim" type="button" onclick="location.href='SupportListAction.su<%--?sup_idx=<%=dto.getSup_idx() %> &pageNum=${param.pageNum}  --%>'">
        목록</button>
	</section>
</body>
</html>