<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/mypage.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#checkPass").on("click", function() {
			$.ajax({
				type: "post",
				url: "CheckPass.my",
				data: {
					mem_pass: $("#mem_pass").val()
				},
				dataType: "text",
				success: function(response) {
					$("#mem_main").html(response);
				}
			});
		});
	});
</script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<hr style="color: gray; opacity: 50%; margin: 50px;">
	
	
	<!-- 메인 디브 -->
	<div id="mem_main">
		<h1 class="text_div">개인 정보 수정</h1>
		
		<div class="text_div">
			<h4 style="margin-bottom: 5px;">비밀 번호 재확인</h4>
			<span>회원님의 정보를 안전하게 보호하기위해 비밀번호를 다시 한번 확인해 주세요</span>
		</div>

		<!-- 기능  div -->
		<div id="mem_contnet">
			<hr style="color: gray; opacity: 70%; margin: 20px;">
			<!-- input 바 -->
			<div id="input_from">
				<div >
					<span class="input_sub">아이디</span> 
					<input class="mem_input" type="text" name="mem_id" id="mem_id" readonly="readonly" value="${sessionScope.sId }">
				</div>
				
				<div >
					<span class="input_sub">비밀번호</span>
					<input class="mem_input" type="password" name="mem_pass" id="mem_pass" placeholder="  비밀번호를 입력해주세요.">
				</div>
			</div>
			
			<hr style="color: gray; opacity: 70%; margin: 20px;">
			
			<div>
				<input type="button" value="확인" id="checkPass"><br><br>
			</div>
		</div>
	</div>
	
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>