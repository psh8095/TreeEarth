<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/mypage.css" rel="stylesheet">

</head>
<body>
	<section id="findIdPhone" id="findIdPhone">
		
	
	
	<!-- 메인 디브 -->
	<div id="mem_main">
	

		<!-- 기능  div -->
		<div id="mem_contnet" >
		
				
			<!-- 샬라샬라 -->
			<h1 class="text_div">핸드폰번호로 찾기</h1>	
				
				
				
			<form name="findIdPhone" action="FindIdPhone.me" method="get">
			
				<hr style="color: gray; opacity: 70%; margin: 20px;">
			
			
			
				<!-- input 바 -->
				<div id="input_from">
					<div >
						<span class="input_sub">이름</span> 
						<input type="text" name="name" required="required">
					</div>
					
					<div >
						<span class="input_sub">휴대폰</span>
						<input type="text" name="phone3" required="required">
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
	
			
			
<!-- 	<section id="findIdPhone"> -->
<!-- 		<h3>이름, 핸드폰번호로 찾기</h3> -->
<!-- 		<form name="findIdPhone" action="FindIdPhone.me" method="get"> -->
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<th>이름</th> -->
<!-- 					<td><input type="text" name="name" required="required"></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>휴대폰</th> -->
<!-- 					<td> -->
<!-- 						<select name="phone1" onchange="changePhone()"> -->
<!-- 							<option value="010">010</option> -->
<!-- 							<option value="011">011</option> -->
<!-- 							<option value="070">070</option> -->
<!-- 							<option value="02">02</option> -->
<!-- 						</select> -->
<!-- 						<input type="text" name="phone2" required="required"> -  -->
<!-- 						<input type="text" name="phone3" required="required"> -->
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
		
		



	</section>
</body>
</html>