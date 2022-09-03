<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    session.setAttribute("location", 2);
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="css/member.css" rel="stylesheet">

	<script type="text/javascript">
	
	function checkEmail() {
		window.open("checkEmail.me", "check_email", "width=600,height=400");
	}
	
	</script>

</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
			
			
			<div style="text-align: center;">
				<!-- 회원가입 절차 -->
				<jsp:include page="currentLocation.jsp"></jsp:include>
				<!-- 회원가입 절차 -->
			</div>
			
			
			<div id="mem_main_div" >
		
			

					
					
					<hr>
			
					<div id="mem_back_div">
					
					
					<h1 class="mem_margin">본인 인증</h1>
					
					
					<div class="mem_margin">
						<form action="">
							
							
							<input type="button" value="휴대폰 인증하기" onclick="location.href=''">
							<input type="button" value="이메일 인증하기" onclick="checkEmail()">
							
						</form>
					</div>
	
				</div>
				
				<hr>
				
			</div>	
	
				
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
	
</body>
</html>