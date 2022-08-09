<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="js/jquery-3.6.0.js"></script>
	<script type="text/javascript">
		
		//제이쿼리
		$(function() {		
			
		// 이메일 형식 판별 ---------------------------------------------------------------------------------

			//인증 코드 전송 버튼 제한
			var isEmail = false;
			
			
			//이메일 창에 입력
			$("#email").on("change", function() {
				
				
				//입력 이메일
				var email = $("#email").val();
			
				//정규표현식('문자x개', '@', '문자x개', '.', '문자2개,3개')   		// 끝자리 판별이 이상하다.@@@@@@@@@@@@@@@@
				var regex = /[A-Za-z0-9-_\.]*@[A-Za-z0-9-_\.]*.[A-Za-z]{2,3}$/;
				
				//이메일 스팬태그
				var emailSpan = $("#emailSpan");
				
				
				//이메일 형식 판별
				if(!regex.exec(email)){
					emailSpan.html("불가능한 이메일 형식입니다.").css("color","red");
					
				} else {
					emailSpan.html("");
					//인증 코드 전송 버튼 제한 해제
					isEmail = true;
			
				}
				
			});
			
			
		// 인증 코드 발송 ---------------------------------------------------------------------------------

			
			//인증코드 발송 버튼 클릭
			$("#sendAuthCode").on("click", function() {
				
			
				//이메일 양식이 맞다면
				if(isEmail){
					
					//ajax로 이동
					$.ajax({
						type: "post",
						url: "sendAuthCodeAction.me",
						data: $("form").serialize(),
						dataType: "text",
						success: function() {

						}
					});
		
					
		// 인증 메일 타이머 ---------------------------------------------------------------------------------
				
		
				var time = 180;
				var min = "";
				var sec = "";

				
					//인증 타이머 
					var intervalTime = null;
					
					
						//클릭시 타이머 종료  @@@@@@@@@@@@@@@@@@@@@@@@제발 멈춰
						clearInterval(intervalTime);
						$("#authCodeSpan").html("");
					
						
						//타이머 시작
						intervalTime = setInterval(function() {
						
						
						min = parseInt(time/60);
						sec = time%60;
						
						
						$("#authCodeSpan").html(min + "분" + sec + "초");
						
						//갱신될 때마다 실행되는 코드
						time--;
						
						//시간 종료시
						if(time == 0) {
							clearInterval(intervalTime);
							$("#authCodeSpan").html("인증시간초과.");

						}
						
					}, 1000);
					
					
				}    
				
				
			});
		
		// 이메일 체크---------------------------------------------------------------------------------
	
		
		//인증 확인 클릭 시
		$("#checkCode").on("click", function() {

			//입력 이메일
			var email = $("#email").val();
			
			//입력 코드
			var authCode = $("#authCode").val();
			
			//코드 판별 이동
			location.href="checkAuthCodeAction.me"

			
		})
			
		
		});
		
	</script>
	
</head>
<body>


	<h1>이메일 인증</h1>
	
	<form action="checkAuthCodeAction.me" method="post" >
		<table border="1">
		
		
			<tr>
				<td>이메일</td>
				<td>
					<input id="email" type="text" name="email">
					<span id="emailSpan"></span>
				</td>
				
			</tr>
			
			
			<tr>		
				<td>인증 번호</td>
				<td>
					<input id="authCode" type="text" name="authCode">
					<input id="sendAuthCode" type="button" value="인증번호 전송" >
					<span id="authCodeSpan"></span>
				</td>
			</tr>
		
		
		</table>
		<input id="checkCode" type="submit" value="인증확인" >
		
	</form>
	<span id="time2"></span>
</body>
