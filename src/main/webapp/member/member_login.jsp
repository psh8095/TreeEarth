<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //페이지 번호
    session.setAttribute("location", 1);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

	function findId() {
		window.open("FindIdForm.me", "findId", "width=700, height=450");
	}

	function findPass() {
		window.open("FindPassForm.me", "findPass", "width=630, height=300");
	}
	
	function kakaoLogin() {
		window.Kakao.Auth.login({
			scope: 'profile_nickname, account_email, gender, birthday',
			success: function(response) {
				console.log(response)
				window.Kakao.API.request({
					url: '/v2/user/me',
					success: (res) => {
						const kakao_account = res.kakao_account;
						console.log(kakao_account)
					}
				});
			},
			fail: function(error) {
				console.log(error)
			}
		});
	}
	
</script>
<link href="css/member.css" rel="stylesheet">
</head>
<body>


	<form action="MemberLoginPro.me" method="post">
	
	
		<div class="login_main">
			<div class="login_back">
			
				<h1 style="text-align: center; margin-bottom: 60px;">트리어스</h1>
				
				<hr>
					
					
					<div>
						<input class="login_input" type="text" name="mem_id" placeholder="아이디">
					</div>
		
		
					<div>
						<input class="login_input" type="password" name="mem_pass" placeholder="비밀번호">
					</div>
						
				
					<div >
						<input class="login_button" type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
					</div>

				<hr>
									
					<div >
						<input  type="button" value="카카오톡으로 로그인" onclick="kakaoLogin()">
					</div>
		
		
					<div>
						<span id="searchId" onclick="findId()">아이디 찾기</span>&nbsp;&nbsp;&nbsp;
						<span id="searchPass" onclick="findPass()">비밀번호찾기</span>
					</div>				
				
				
				<hr>
					
			</div>
		</div>
		
		
	</form>
	
</body>
</html>







