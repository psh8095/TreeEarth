<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	// 제이쿼리
	$(function() {
		$("#findPhone").on("click", function() {
			$.ajax({
				type: "post",
				url: "member/find_id_phone.jsp",
				success: function(response) {
					$("#result").html(response);
				}
			});
		});
		
		$("#findEmail").on("click", function() {
			$.ajax({
				type: "post",
				url: "member/find_id_email.jsp",
				success: function(response) {
					$("#result").html(response);
				}
			});
		});
	});
	
</script>		
	
</head>
<body>
	<h1>아이디 찾기</h1>
	
	<input type="radio" id="findPhone" name="find" value="1" >핸드폰으로 찾기
	<input type="radio" id="findEmail" name="find" value="2">이메일로 찾기
	
	<div id="result"></div>
	
</body>
</html>