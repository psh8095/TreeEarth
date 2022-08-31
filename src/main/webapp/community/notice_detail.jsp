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
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	
<!-- 디테일 메인 블럭 -->
   <div class="main">

	 <hr style="color: gray; opacity: 70%; margin: 50px;">
	
	
		<!-- 섬네일 옆	 -->
		<div id="content">

		
			<!-- 제목 -->
			<div >
				<span class="no_subject"> ${notice.no_subject} </span>
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
		<div>
			<input type="button" value="수정" onclick="location.href='NoticeModifyForm.cm?no_idx=${notice.no_idx}&pageNum=${param.pageNum}'">
			<input type="button" value="삭제" onclick="location.href='NoticeDeleteForm.cm?no_idx=${notice.no_idx}&pageNum=${param.pageNum}'">
			<input type="button" value="목록" onclick="location.href='NoticeList.cm?pageNum=${param.pageNum}'">
		</div>
		
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>