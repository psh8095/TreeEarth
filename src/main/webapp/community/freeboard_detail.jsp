<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 자유게시판 상세보기</title>
<script>
	function blockForm() {
		window.open("FreeBoardBlockForm.cm?free_idx=${freeboard.free_idx}&pageNum=${param.pageNum}", 
				'treeEarth', 'width=450,height=550');
	}
</script>
<link href="css/community.css" rel="stylesheet">
<style type="text/css">
</style>
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	
	
   <div class="main">

	 <hr style="color: gray; opacity: 70%; margin: 50px;">
	
	
		<!-- 섬네일 옆	 -->
		<div id="content">

		
			<!-- 제목 -->
			<div >
				<span class="free_subject">제목 : ${freeboard.free_subject} </span>
			</div>
			
			
			<!-- 작성자 -->
			<div>
				<span >작성자 : ${freeboard.free_name } </span>
			</div>
			
			
			<!-- 데이트 -->	
			<div>
				<span >작성일 : ${freeboard.free_date } </span>
			</div>	
					
						
			<!-- 조회수 -->		
			<div>
				<span >조회수 : ${freeboard.free_readcount }</span>
			</div>		
		</div>
		
		
		<!-- 내용 -->		
		<div class="content">
			<span >${freeboard.free_content }</span>
		</div>			
		
			
		<!-- 상세이미지 -->	
		<div >
			<a href="img/community/${freeboard.free_img }"><img id="free_img" alt="${freeboard.free_img }" src="img/community/${freeboard.free_img }"></a>
		</div>		
						
				
		<div>
			<input type="button" value="답변" onclick="location.href='FreeBoardReplyForm.cm?free_idx=${freeboard.free_idx }&pageNum=${param.pageNum}'">
			<input type="button" value="수정" onclick="location.href='FreeBoardModifyForm.cm?free_idx=${freeboard.free_idx }&pageNum=${param.pageNum}'">
			<input type="button" value="삭제" onclick="location.href='FreeBoardDeleteForm.cm?free_idx=${freeboard.free_idx }&pageNum=${param.pageNum}'">
			<input type="button" value="목록" onclick="location.href='FreeBoardList.cm?pageNum=${param.pageNum }'">

			<c:if test="${not empty sessionScope.sId}">
				<input type="button" value="신고하기" onclick="blockForm()">
			</c:if>
		</div>
		
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>
















