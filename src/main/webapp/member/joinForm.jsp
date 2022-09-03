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

<!-- 주소api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 제이쿼리 -->
	<script src="js/jquery-3.6.0.js"></script>
<!-- 스크립트 -->
	<script type="text/javascript">
		
		//제이쿼리
		$(function() {		
			var passPasswd = false;
			var passCheckPasswd = false;
			var passName = false;
			var passBirth = false;
			var passGender = false;
			var passAddress = false;
			
		// 아이디 형식 판별 ---------------------------------------------------------------------------------
			
			var checkId = false;
		
			
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
					checkId = false;
					
				} else {
					idSpan.html("").css("color","green");
					checkId = true;
				}
				
				
			});	
		
		
		// 아이디 중복확인 ---------------------------------------------------------------------------------
			
		
			$("#checkId").on("click", function() {
				
				
				//올바른 아이디 형식을 가졌을 때 
				if(checkId)	{
					
					//아이디 입력시
					var id = $("#id").val();
					location.href="checkIdAction.me?id="+id;
				
					
				//올바르지 않은 아이디 형식을 가졌을 때
				} else {
					//아이디 스팬태그
					$("#idSpan").html("올바른 아이디 형식을 사용해 주세요!").css("color","red");

				}

				
				
			})
		
			
		// 비밀번호 형식 판별 ---------------------------------------------------------------------------------

			
			$("#passwd").on("change", function() {
				
				//입력 비밀번호 
				var passwd = $("#passwd").val();
				
				//비밀번호 스팬태그
				var passwdSpan = $("#passwdSpan");
				
				
				
				//정규표현식
				var regex = /[A-Za-z0-9-_\.@]{8,16}$/
				// 2. 영문 대문자 규칙
				var engUpperRegex = /[A-Z]/;
				// 3. 영문 소문자 규칙
				var engLowerRegex = /[a-z]/;
				// 4. 숫자 규칙
				var numRegex = /[0-9]/;
				// 5. 특수문자 규칙
				var specRegex = /[!@#$%]/;
				

				
				//비밀번호 형식 판별
				if(regex.exec(passwd)){
					var count = 0; // 포인트
					
					
					//포인트 적용 코드
					if(engUpperRegex.exec(passwd)) { // 대문자 검사
						count++;
					}
					
					if(engLowerRegex.exec(passwd)) { // 소문자 검사
						count++;
					}
					
					if(numRegex.exec(passwd)) { // 숫자 검사
						count++;
					}
					
					if(specRegex.exec(passwd)) { // 특수문자 검사
						count++;
					}
					
					
					//포인트 체크 코드
					if(count == 4) {
						passwdSpan.html("비밀번호 안전도 | 높음" + "<br>" + "예측하기 힘든 비밀번호로 더욱 안전합니다.").css("color","GREEN");
						passPasswd = true;
							
					} else if(count == 3) {
						passwdSpan.html("비밀번호 안전도 | 적정" + "<br>" + "안전하게 사용하실 수 있는 비밀번호입니다.").css("color","ORANGE");
						passPasswd = true;

						
					} else if(count == 2) {
						passwdSpan.html("비밀번호 안전도 | 낮음" + "<br>" + "안전도가 높은 비밀번호를 권장합니다.").css("color","ORANGE");
						passPasswd = true;

					} else {
						passwdSpan.html("사용불가:비밀번호 재작성 필요" + "<br>" + "8~16 자의 영문 대소문자, 숫자 및 특수문자 사용").css("color","RED");

					}
					
				} else { // 패스워드 길이 또는 사용 가능 문자 체크 부적합 시
					passwdSpan.html("사용불가:비밀번호 재작성 필요" + "<br>" + "8~16 자의 영문 대소문자, 숫자 및 특수문자 사용").css("color","RED");

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
					passCheckPasswd = true;
				}
				
			});	
			
			
			
		// 주민등록번호 판별 ---------------------------------------------------------------------------------
			
			
// 			$("#gender").on("change", function() {
				
				
// 				//입력 주민등록번호 뒷 첫자리
// 				var gender = $("#gender").val();
				
// 				//정규표현식
// 				var regex = /^[1-4]$/;
				
// 				//성별 스팬태그
// 				var genderSpan = $("#genderSpan");
				
// 				//주민등록번호 형식 판별
// 				if(!regex.exec(gender)){
// 					genderSpan.html("올바르지 않은 주민등록 형식입니다.").css("color","red");
				
// 				//형식이 올바를 떄	
// 				} else {
// 					genderSpan.html("");
			
// 				}
				
// 			});
		
		
		// 주민등록번호 판별 ---------------------------------------------------------------------------------
		
			
// 			$("#birth").on("change", function() {
				
				
// 				//입력 주민등록번호 뒷 첫자리
// 				var birth = $("#birth").val();
				
// 				//정규표현식
// 				var regex = /^[0-9]{6}$/;
				
// 				//성별 스팬태그
// 				var birthSpan = $("#birthSpan");
				
// 				//주민등록번호 형식 판별
// 				if(!regex.exec(birth)){
// 					birthSpan.html("올바르지 않은 주민등록 형식입니다.").css("color","red");
				
// 				//형식이 올바를 떄	
// 				} else {
// 					birthSpan.html("");
			
// 				}
				
// 			});
		
		
		
		//이름 체크
		$("#name").on("change", function() {
			//왜 밖으로 빼면 얼럿에서 인식을 못하는 건지
			var passNameVal = $("#name").val();
			
			alert(passNameVal)
			
			if(passNameVal != ""){
				passName = true;
			} else {
				passName = false;
			}
			
		})
		
		//생일 체크
		

		$("#birth").on("change", function() {
			var passBirthVal = $("#birth").val();
			
			if(passBirthVal != ""){
				passBirth = true;
			}  else {
				passBirth = false;
			}
		})
		
		


		
		// 가입 버튼 ---------------------------------------------------------------------------------

		
			//가입 버튼 클릭
			$("#join").on("click", function() {
				
				var allCheck = 0;
				
				if(passPasswd){
					allCheck++
					alert(passPasswd)
				}
				
				if(passCheckPasswd){
					allCheck++
					alert(passCheckPasswd)
				}
				
				if(passName){
					allCheck++
					alert(passName)
				}
				
				if(passBirth){
					allCheck++
					alert(passBirth)
				}
				
				
				alert(allCheck);
				
				
				// 조인으로 이동
				if(allCheck == 4){
	 				$("form").submit();
				}
				
			});
			
		
		});
		
		// 다음 우편번호 API ---------------------------------------------------------------------------------
			
		
		function execDaumPostcode() {
		 new daum.Postcode({
            oncomplete: function(data) {

                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

           
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = roadAddr;
            }
		 
        }).open();
	}	
		
	</script>
	<link href="css/member.css" rel="stylesheet">

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

			<div id="mem_main_div">
			
			
				<hr>
			
						
				<h1 class="mem_margin">회원가입</h1>
				<form action="joinProAction.me" method="get">
				
						
						<div class="mem_margin">
						
							<div>
								<span>ID</span>
								<input id="id" type="text" name="id" placeholder="5~20글자 사이 입력" required="required">
								<input id="checkId" type="button" value="아이디 중복확인."><br>
								<span id="idSpan"></span>
							</div>
						
						
						
						
							<div>
								<span>비밀번호</span>
								<input id="passwd" type="password" name="pass" placeholder="8 ~ 16글자 사이 입력" required="required"><br>
								<span id="passwdSpan"></span>
							</div>
						
						
						
						
							<div>
								<span>비밀번호확인</span>
								<input id="checkPasswd" type="password" name="passwd2" required="required"><br>
								<span id="checkPasswdSpan"></span>
							</div>
						
						
						
						
							<div>
								<span>이름</span>
								<input id="name" type="text" name="name" required="required">
								<span></span>
							</div>
						
						
			
						
							<div>
								<span>생년월일</span>
								<input id="birth" type="date" name="birth" required="required" > 
								<span></span>
							</div>
						
						
						
						
							
							<div>
								<span>성별</span>
								<input type="radio" name="gender" value="남" checked="checked">남
								<input type="radio" name="gender" value="여">여 
								<span></span>
							</div>
						
						
						
						
							<div>
							<span>주소</span>
								<input type="text" id="postcode" name="post_code" placeholder="우편번호" required="required" readonly="readonly" onclick="execDaumPostcode()">
								<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
							<span></span>
								<input type="text" id="address" name="address" required="required" placeholder="도로명 주소">
								<input type="text" id="address_detail" name="address_detail" required="required" placeholder="상세주소">
								<span></span>
								
							</div>
						
						
						
						
							<div>
								<span>핸드폰</span>
								<input id="phone" type="text" name="phone" placeholder="숫자로 입력해주세요" required="required">
								<span></span>
							</div>
						
						
						
						
							<div>
								<span>E-Mail</span>
								<input id="email" type="text" name="email" readonly="readonly" value="<%=email %>" >
								<span></span>
							</div>
						
						
						
							<div class="mem_margin">
								<input type="button" id="join" value="가입">
								<input type="reset" value="초기화">
								<input type="button" value="돌아가기" onclick="history.back()">
							</div>
						</div>
				</form>
			<hr>
		</div>	
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
	
</body>
</html>