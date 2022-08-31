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
	$("#unregister").on("click", function() {
		if(confirm("정말로 탈퇴하시겠습니까?")) {
			location.href="UnregisterMember.me";
		}
	});
</script>
</head>
<body>

	
	<!-- 메인 디브 -->
	<div id="mem_main">
	
	
		<!-- 샬라샬라 -->
		<h1 class="text_div">개인 정보 수정</h1>
		

		<!-- 기능  div -->
		<div id="mem_contnet">
			<form action="UpdateMemberInfo.my" method="post">
		
		
				<hr style="color: gray; opacity: 70%; margin: 50px;">
			
				<!-- input 바 -->
				<div id="input_from">
				
				
					<div >
						<span class="input_sub">이름</span> 
						<input class="mem_input"  type="text" value="${member.mem_name }" readonly="readonly">
					</div>
					
					
					
					<div >
						<span class="input_sub">비밀번호</span>
						<input  class="mem_input"  type="password" name="mem_pass" required="required">
					</div>
					
					
					
					<div >
						<span class="input_sub">휴대폰 번호</span>
						<input  class="mem_input" type="text" name="mem_phone" value="${member.mem_phone }">
					</div>
					
					
					<div >
						<span class="input_sub">주소</span>
						<input  class="mem_input" type="text" name="mem_address" value="${member.mem_address }">
					</div>
					
					
					<div >
						<span class="input_sub">상세주소</span>
						<input  class="mem_input" type="text" name="mem_address_detail" value="${member.mem_address_detail }">
					</div>
					
					
				</div>
				
				
				<hr style="color: gray; opacity: 70%; margin: 50px;">
				
				<div>
					<input class="mem_button" type="submit" value="정보 수정">
					<input class="mem_button" type="button" value="회원 탈퇴" id="unregister">
				</div>
			
			
			</form>
		</div>

	
	</div>
	


</body>
</html>