<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<script type="text/javascript">
</script>
<link href="css/community.css" rel="stylesheet">
<style type="text/css">
	.main {
		width: 500px;
		height: 450px;
		border: 1px #c5e096;
		margin: auto;
	}
	
	h1 {
		color: #c5e096;
	}

	#button {
		position: absolute;
	}
	
	#button2 {
		color: white; 
		padding: 4px 10px;
		background-color: #c5e096;
		display: inline-block;
		border: 1px solid rgba(0,0,0,0.21);
		border-bottom-color: rgba(0,0,0,0.34);
		text-shadow:0 1px 0 rgba(0,0,0,0.15);
		box-shadow: 0 1px 0 rgba(255,255,255,0.34) inset, 
		            0 2px 0 -1px rgba(0,0,0,0.13), 
		            0 3px 0 -1px rgba(0,0,0,0.08), 
		            0 3px 13px -1px rgba(0,0,0,0.21);
	}
	
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	
<!-- 디테일 메인 블럭 -->
   <div class="main">
		<br><br>
		<h1>공지사항 상세조회</h1>
	 <hr style="color: gray; opacity: 70%; margin: 20px;">
	
		<!-- 섬네일 옆	 -->
		<div id="content">
		

		
			<!-- 제목 -->
			<div >
				<span class="no_subject">제목 : ${notice.no_subject} </span>
			</div>
			
			
			<!-- 작성자 -->
			<div>
				<span >작성자 : ${notice.no_id } </span>
			</div>
			
			
			<!-- 데이트 -->	
			<div>
				<span >작성일 : ${notice.no_date } </span>
			</div>	
						
		</div>
		
		
		<!-- 내용 -->		
		<div class="content">
			<span >${notice.no_content }</span>
		</div>			
		
			
		<!-- 상세이미지 -->	
		<div >
			<a href="img/community/${notice.no_img }"><img id="no_img" alt="${notice.no_img }" src="img/community/${notice.no_img }"></a>
		</div>		
						
				
		<!-- 버튼 -->	
		<div id="button">
			<input id="button2" type="button" value="수정" onclick="location.href='NoticeModifyForm.cm?no_idx=${notice.no_idx}&pageNum=${param.pageNum}'">
			<input id="button2" type="button" value="삭제" onclick="location.href='NoticeDeleteForm.cm?no_idx=${notice.no_idx}&pageNum=${param.pageNum}'">
			<input id="button2" type="button" value="목록" onclick="location.href='NoticeList.cm?pageNum=${param.pageNum}'">
		</div>
		
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>