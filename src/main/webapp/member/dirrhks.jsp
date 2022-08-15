<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    session.setAttribute("location", 1);
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>

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
			$("#buntton").on("click", function() {
				
				
				//체크 상태가 모두 true 일 경우 
				if($(".check").length == $(".check:checked").length){
					location.href="qhsdlsdlswmd.me"
				
				//체크상테가 모두 true가 아닐 경우	
				} else {
					alert("약관에 모두 동의해 주세요.")
				}
		
			});
			
			
		// ----------------------------------------------------------------------------------------

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
	
	<h1>가입 약관</h1>
	
	<form action="">
	
		<ul>
			<li><input type="checkbox" id="allCheck"> 전체동의</li>
			<li></li>
			<li><input type="checkbox" class="check"> 동의</li>
			<li></li>
			<li><input type="checkbox" class="check"> 어 보감v</li>
			<li></li>
			<li><input type="checkbox" class="check"> 동의</li>
			<li></li>
			<li><input type="checkbox" class="check"> 어 보감</li>
		</ul>
	
		
		<!-- 만약 디비를 추가면 디비 작업 추가-->
		<input id="buntton" type="button"  value="다음" >
		
	</form>
		
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
	
		
</body>
</html>