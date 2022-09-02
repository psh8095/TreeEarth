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
<link href="css/member.css" rel="stylesheet">
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

	//아이디 찾기 창
	function findId() {
		window.open("FindIdForm.me", "findId", "width=400, height=600");
	}

	//비밀번호 찾기 창
	function findPass() {
		window.open("FindPassForm.me", "findPass", "width=400, height=600");
	}
	
	//카카오 API key
	Kakao.init('3881606b6752efe09dea2830d84fd642');
	//sdk초기화 여부 판단
	console.log(Kakao.isInitialized());
	
	function kakaoLogin() {
		Kakao.Auth.login({
			success: function (response) {
				Kakao.API.request({
					url: '/v2/user/me',
					success: function (response) {
						console.log(response)
						alert("로그인 완료!");
						
						$.ajax({
							type: "post",
							url: "MemberLoginPro.me",
							data: {
								mem_id: response.profile_nickname
							},
							dataType: "text",
							success: function(response) {
								session.setAttribute("sId", mem_id);
								opener.location.reload();
								window.close();
							}
						});
						
					},
					fail: function (error) {
						console.log(error)
					},
				})
			},
			fail: function (error) {
				console.log(error)
			},
		})
	}
	
	function kakaoLogout() {
		if (Kakao.Auth.getAccessToken()) {
			Kakao.API.request({
				url: '/v1/user/unlink',
				success: function (response) {
					console.log(response)
					alert("로그아웃!");
				},
				fail: function (error) {
					console.log(error)
				},
			})
			Kakao.Auth.setAccessToken(undefined)
		}
	}
	
</script>
</head>
<body>


	<form action="MemberLoginPro.me" method="post">
	
	
		<div class="login_main">
			<div class="login_back">
			
				<h1 style="text-align: center;  margin: 60px 0px 60px 0px;; position:relative; top: 35px;">트리어스</h1>
				
				<hr>
					
					
					<div class="contnet_div">
						<input class="login_input" type="text" name="mem_id" placeholder="  아이디">
					</div>
		
		
					<div class="contnet_div">
						<input class="login_input" type="password" name="mem_pass" placeholder="  비밀번호">
					</div>
						
				
					<div >
						<input class="login_button" type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
					</div>

				<hr>
									
					<div class="contnet_div">
						<input  type="button" value="카카오톡으로 로그인" onclick="kakaoLogin()">
						<input  type="button" value="카카오톡 로그아웃" onclick="kakaoLogout()">
					</div>
		
		
					<div>
						<span id="searchId" onclick="findId()">아이디 찾기</span>&nbsp;&nbsp;&nbsp;
						<span id="searchPass" onclick="findPass()">비밀번호찾기</span>
						<span><a href="requiredTerms.me">회원가입</a></span>
					</div>				
				
				
				<hr>
					
			</div>
		</div>
		
		
	</form>
	
</body>
</html>







