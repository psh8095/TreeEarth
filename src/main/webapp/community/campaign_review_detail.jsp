<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<script type="text/javascript">

	function blockForm() {
		window.open("CampaignReviewBlockForm.cm?cam_re_idx=${campaign_review.cam_re_idx}&pageNum=${param.pageNum}", 
				'treeEarth', 'width=450,height=550');
	}
	
</script>
<link href="css/community.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
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

	 <hr style="color: gray; opacity: 70%; margin: 50px;">
	
		<!-- 섬네일 옆	 -->
		<div id="content">
		
			<!-- 제목 -->
			<div >
				<span class="cam_subject"> ${campaign_review.cam_re_subject} </span>
			</div>
			
			<!-- 작성자 -->
			<div>
				<span >작성자 : ${campaign_review.cam_re_id } </span>
			</div>
			
			<!-- 데이트 -->	
			<div>
				<span >작성일 : ${campaign_review.cam_re_date } </span>
			</div>	
						
			<!-- 조회수 -->		
			<div>
				<span >조회수 : ${campaign_review.cam_re_readcount }</span>
			</div>		
		</div>
		
		<!-- 내용 -->		
		<div class="content">
			<span >${campaign_review.cam_re_content }</span>
		</div>			
			
		<!-- 상세이미지 -->	
		<div >
			<a href="img/community/${campaign_review.cam_re_real_file }">
				<img id="cam_img" alt="${campaign_review.cam_re_file }" src="img/community/${campaign_review.cam_re_real_file }">
			</a>
		</div>		
				
		<br>
		
		<!-- 버튼 -->	
		<div id="commandCell">
			<input class="btn" type="button" value="수정" onclick="location.href='CampaignReviewModifyForm.cm?cam_re_idx=${campaign_review.cam_re_idx}&pageNum=${param.pageNum}'">
			<input class="btn" type="button" value="삭제" onclick="location.href='CampaignReviewDeleteForm.cm?cam_re_idx=${campaign_review.cam_re_idx}&pageNum=${param.pageNum}'">
			<input class="btn" type="button" value="목록" onclick="location.href='CampaignReviewList.cm?pageNum=${param.pageNum}'">
		
			<c:if test="${not empty sessionScope.sId}">
				<input class="btn" type="button" value="신고하기" onclick="blockForm()">
			</c:if>
		
		</div>
		
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>