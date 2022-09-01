<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    session.setAttribute("location", 1);
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="css/member.css" rel="stylesheet">
	<script src="js/jquery-3.6.0.js"></script>
	<script type="text/javascript">
		
		$(function() {		
			
		// ----------------------------------------------------------------------------------------
			
			
			//전체선택 체크박스 클릭
			$("#allCheck").on("change", function() {
				
				
				//전체선택 체크 상태가 true 일 경우
				if($("#allCheck").is(":checked")){
					
					//전체 체크
					$(".check").each(function(index, dirrhks) {
						dirrhks.checked = true;
					});
					
					
				//전체선택 체크 상태가 false 일 경우	
				} else {
					
					//전체 체크 해제
					$(".check").each(function(index, dirrhks) {
						dirrhks.checked = false;
					});
				}
					
			
			});
			
			
		// ----------------------------------------------------------------------------------------
			
		
			//다음 버튼 클릭
			$("#buntton2").on("click", function() {
				
				
				//체크 상태가 모두 true 일 경우 
				if($(".check").length == $(".check:checked").length){
					location.href="identification.me"
				
				//체크상테가 모두 true가 아닐 경우	
				} else {
					alert("약관에 모두 동의해 주세요.")
				}
		
			});
			
		
			//처음으로 버튼 클릭
			$("#buntton1").on("click", function() {
				
				history.back();				
		
			});
		// ----------------------------------------------------------------------------------------

		});
		
	</script>
	
	
</head>
<body>



	
	<form action="">
	
			<div id="mem_main_div">
				<div id="mem_back_div">
						
						
						
					<!-- 회원가입 절차 -->
					<jsp:include page="currentLocation.jsp"></jsp:include>
					<!-- 회원가입 절차 -->
					
					<hr>
					
					<h1 style="text-align: center;">가입 약관</h1>
					
					
							
					<div>
						<input type="checkbox" class="check"> 트리어스 구매 회원 이용약관
						<span>(필수)</span>
					</div>
					
					
					<div>
						<input type="checkbox" class="check"> 전자금융서비스 이용약관
						<span>(필수)</span>
					</div>
					
					
					<div>
						<input type="checkbox" class="check_no"> 개인정보 수집 및 이용
						<span>(선택)</span>
					</div>
					
					
					<div>
						<input type="checkbox" class="check_no"> 개인정보 제3자 제공 동의
						<span>(선택)</span>
					</div>
					
					
					<div>
						<input type="checkbox" id="allCheck"> 전체동의
					</div>
					
					
					<div>
						<!-- 만약 디비를 추가면 디비 작업 추가-->
						<input id="buntton1" type="button"  value="돌아가기" >
						<input id="buntton2" type="button"  value="동의하고 회원가입" >
					</div>
					
					
				</div>
			</div>
			

		
	</form>

		
</body>
</html>