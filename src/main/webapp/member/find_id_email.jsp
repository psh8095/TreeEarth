<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeDomain() {
		document.findIdEmail.email2.value = document.findIdEmail.emailDomain.value;
	}
</script>
<link href="css/mypage.css" rel="stylesheet">
</head>
<body>


	<!-- 메인 디브 -->
	<div id="mem_main" id="findIdEmail">
	

		<!-- 기능  div -->
		<div id="mem_contnet">
		
				
			<!-- 샬라샬라 -->
			<h1 class="text_div">이메일로 찾기</h1>	
				
				
				
			<form name="findIdEmail" action="FindIdEmail.me" method="get">
			
				<hr style="color: gray; opacity: 70%; margin: 20px;">
			
			
			
				<!-- input 바 -->
				<div id="input_from">
					<div >
						<span class="input_sub">이름</span> 
						<input type="text" name="name" required="required">
					</div>
					
					<div >
						<span class="input_sub">이메일</span>
						<input type="text" name="email1" required="required">
					</div>
				</div>
				
				
				
				<hr style="color: gray; opacity: 70%; margin: 20px;">
				
				<div>
					<input type="submit" value="찾기">
					<input type="button" value="취소" onclick="window.close()">
				</div>
				
			</form>
			
		</div>

	
	</div>
	

<!-- 	<section id="findIdEmail"> -->
<!-- 		<h3>이름, 이메일로 찾기</h3> -->
<!-- 		<form name="findIdEmail" action="FindIdEmail.me" method="get"> -->
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<th>이름</th> -->
<!-- 					<td><input type="text" name="name" required="required"></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>이메일</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="email1" required="required"> -->
<!-- <!-- 						<input type="text" name="email2" required="required"> --> -->
<!-- <!-- 						<select name="emailDomain" onchange="changeDomain()"> --> -->
<!-- <!-- 							<option value="">직접입력</option> --> -->
<!-- <!-- 							<option value="naver.com">naver.com</option> --> -->
<!-- <!-- 							<option value="gmail.com">gmail.com</option> --> -->
<!-- <!-- 							<option value="nate.com">google.com</option> --> -->
<!-- <!-- 						</select> --> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td colspan="2"> -->
<!-- 						<input type="submit" value="찾기"> -->
<!-- 						<input type="button" value="취소" onclick="window.close()"> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<!-- 		</form> -->
<!-- 	</section> -->
</body>
</html>