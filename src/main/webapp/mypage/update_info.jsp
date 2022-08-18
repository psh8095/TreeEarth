<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#checkPass").on("click", function() {
			$.ajax({
				type: "post",
				url: "CheckPass.my",
				data: {
					mem_pass: $("#mem_pass").val()
				},
				dataType: "text",
				success: function(response) {
					$("#result").html(response);
				}
			});
		});
	});
</script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<h1>회원 정보 수정</h1>
	<div id="result">
		비밀번호를 입력해주세요
		<input type="password" name="mem_pass" id="mem_pass">
		<input type="button" value="확인" id="checkPass"><br><br>
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>