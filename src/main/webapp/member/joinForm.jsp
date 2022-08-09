<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
	
		String email = request.getParameter("email"); 
	    session.setAttribute("location", 3);
	    
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
			
			
		// 아이디 형식 판별 ---------------------------------------------------------------------------------
			
			
			$("#id").on("change", function() {
				
				
				//입력 아이디 
				var id = $("#id").val();
				
				//정규표현식
				var regex = /[A-Za-z0-9-_\.]{5,20}$/;
				
				//아이디 스팬태그
				var idSpan = $("#idSpan");
				
				
				//아이디 형식 판별
				if(!regex.exec(id)){
					idSpan.html("불가능한 아이디 형식입니다!").css("color","red");
					
				} else {
					idSpan.html("멋진 아이디네요!").css("color","green");
			
				}
				
				
			});	
		
		
		// 아이디 중복확인 ---------------------------------------------------------------------------------
			
		
			$("#checkId").on("click", function() {
				
				
				//아이디 입력시
				var id = $("#id").val();
				location.href="checkIdAction.me?id="+id;
				
				
			})
		
			
		// 비밀번호 형식 판별 ---------------------------------------------------------------------------------

			
			$("#passwd").on("change", function() {
				
				
				//입력 비밀번호 
				var passwd = $("#passwd").val();
				
				//정규표현식
				var regex = /[A-Za-z0-9-_\.@]{8,16}$/;
				
				//비밀번호 스팬태그
				var passwdSpan = $("#passwdSpan");
				
				
				//비밀번호 형식 판별
				if(!regex.exec(passwd)){
					passwdSpan.html("올바르지 않은 비밀번호 형식입니다!").css("color","red");
				
				//형식이 올바를 떄	
				} else {
					passwdSpan.html("");
			
				}
				
				
			});
			
			
			//비밀번호 확인
			$("#checkPasswd").on("change", function() {


				var passwd = $("#passwd").val();
				var checkPasswd = $("#checkPasswd").val();

				
				if(passwd != checkPasswd){
					$("#checkPasswdSpan").html("비밀번호가 일치하지 않습니다!").css("color","red");
				} else {
					$("#checkPasswdSpan").html("비밀번호가 일치합니다.").css("color","green");
				}
				
			});	
			
			
			
		// 주민등록번호 판별 ---------------------------------------------------------------------------------
			
			
			$("#gender").on("change", function() {
				
				
				//입력 주민등록번호 뒷 첫자리
				var gender = $("#gender").val();
				
				//정규표현식
				var regex = /^[1-4]$/;
				
				//성별 스팬태그
				var genderSpan = $("#genderSpan");
				
				//주민등록번호 형식 판별
				if(!regex.exec(gender)){
					genderSpan.html("올바르지 않은 주민등록 형식입니다.").css("color","red");
				
				//형식이 올바를 떄	
				} else {
					genderSpan.html("");
			
				}
				
			});
		
		
		// 주민등록번호 판별 ---------------------------------------------------------------------------------
		
			
			$("#birth").on("change", function() {
				
				
				//입력 주민등록번호 뒷 첫자리
				var birth = $("#birth").val();
				
				//정규표현식
				var regex = /^[0-9]{6}$/;
				
				//성별 스팬태그
				var birthSpan = $("#birthSpan");
				
				//주민등록번호 형식 판별
				if(!regex.exec(birth)){
					birthSpan.html("올바르지 않은 주민등록 형식입니다.").css("color","red");
				
				//형식이 올바를 떄	
				} else {
					birthSpan.html("");
			
				}
				
			});
		
		
		// ---------------------------------------------------------------------------------

			
		
		});
		
	</script>

</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<!-- 회원가입 절차 -->
	<jsp:include page="currentLocation.jsp"></jsp:include>
	<!-- 회원가입 절차 -->
	
	<h1>회원가입</h1>
	<form action="joinProAction.me" method="get">
		<table border="1">
			
			
			<tr>
				<td>ID</td>
				<td>
					<input id="id" type="text" name="id" placeholder="4 ~ 8글자 사이 입력" required="required">
					<input id="checkId" type="button" value="아이디 중복확인."><br>
					<span id="idSpan"></span>
				</td>
			</tr>
			
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input id="passwd" type="password" name="pass" placeholder="8 ~ 16글자 사이 입력" required="required"><br>
					<span id="passwdSpan"></span>
				</td>
			</tr>
			
			
			<tr>
				<td>비밀번호확인</td>
				<td>
					<input id="checkPasswd" type="password" name="passwd2" required="required"><br>
					<span id="checkPasswdSpan"></span>
				</td>
			</tr>
			
			
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" required="required">
				</td>
			</tr>
			

			<tr>
				<td>생년월일</td>
				<td>
					<input id="birth" type="date" name="birth" required="required" > 
					<span id="birthSpan"></span>
					<span id="genderSpan"></span>
					
				</td>
			</tr>
			
			
			<tr>
				<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="남">남
					<input type="radio" name="gender" value="여">여 
					
				</td>
			</tr>
			
			
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="address" required="required">
				</td>
			</tr>
			
			
			<tr>
				<td>상세 주소</td>
				<td>
					<input type="text" name="address_detail" required="required">
				</td>
			</tr>
			
			
			<tr>
				<td>핸드폰</td>
				<td>
					<input type="text" name="phone" placeholder="숫자로 입력해주세요" required="required">
				</td>
			</tr>
			
			
			<tr>
				<td>E-Mail</td>
				<td>
					<input id="email" type="text" name="email" readonly="readonly" value="<%=email %>" >
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
					<input type="reset" value="초기화">
					<input type="button" value="돌아가기" onclick="history.back()">
				</td>
			</tr>
			
			
		</table>
	</form>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
	
</body>
</html>