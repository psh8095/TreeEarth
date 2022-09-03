<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    int location = (int)session.getAttribute("location");
    
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
			
			//페이지에 따라 색깔 변경
			if(<%=location%> == 1){
				$("#1").css("color", "#4288eb");
				
			} else if(<%=location%> == 2){
				$("#2").css("color", "#4288eb");
				
			} else if(<%=location%> == 3){
				$("#3").css("color", "#4288eb");
				
			} else if(<%=location%> == 4){
				$("#4").css("color", "#4288eb");
			}
		});
	</script>
	
		<link href="css/member.css" rel="stylesheet">
	
</head>
<body>
	
	<div class="location">
		
		<div id="1">
			<h2 >약관</h2>
		</div>
		
		
		<div id="2">
			<h2 >본인인증</h2>
		</div>
		
		
		<div id="3"> 
			<h2 >정보입력</h2>
		</div>
		
		
		<div id="4">
			<h2 >가입완료</h2>
		</div>
	
	</div>
	
</body>
</html>