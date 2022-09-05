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
	.detail {
		width: 500px;
		height: 450px;
		border: 1px #c5e096;
		margin: auto;
	}
	
	h1 {
		color: #c5e096;
	}
	
	.td_left {
		width: 150px;
		background: #c5e096;
		text-align: center;
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
	
   <div class="detail">

	 <hr style="color: gray; opacity: 70%; margin: 50px;">
	
	
		<!-- 섬네일 옆	 -->
		<div id="content">
			<h1>자유게시판</h1>
		
			<!-- 제목 -->
			<div>
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
			<input id="button2" type="button" value="답변" onclick="location.href='FreeBoardReplyForm.cm?free_idx=${freeboard.free_idx }&pageNum=${param.pageNum}'">
			<input id="button2" type="button" value="수정" onclick="location.href='FreeBoardModifyForm.cm?free_idx=${freeboard.free_idx }&pageNum=${param.pageNum}'">
			<input id="button2" type="button" value="삭제" onclick="location.href='FreeBoardDeleteForm.cm?free_idx=${freeboard.free_idx }&pageNum=${param.pageNum}'">
			<input id="button2" type="button" value="목록" onclick="location.href='FreeBoardList.cm?pageNum=${param.pageNum }'">

			<c:if test="${not empty sessionScope.sId}">
				<input id="button2" type="button" value="신고하기" onclick="blockForm()">
			</c:if>
		</div>
		
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>