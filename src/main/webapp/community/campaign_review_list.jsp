<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>treeEarth</title>
<link href="css/community.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<!-- 후원 메인 블럭 -->
   <main >
   
		<hr style="color: gray; opacity: 70%; margin: 50px;">
	   
		<!-- 글 목록 -->
	    <div class="main">
	
			<c:choose>
				<c:when test="${not empty campaignReviewList and pageInfo.itemListCount gt 0}">
					<c:forEach var="campaign_review" items="${campaignReviewList }">
						
						<div class="list">
							<a href="CampaignReviewDetail.cm?cam_re_idx=${campaign_review.cam_re_idx }&pageNum=${pageInfo.pageNum}">
								<c:choose>
									<c:when test="${not empty campaign_review.cam_re_file}">
										<img class="img" alt="" src="img/community/${campaign_review.cam_re_file }" width="500px">
									</c:when>
									<c:otherwise>
										<img class="img" alt="이미지없음" src="img/community/tree.png" width="500px">
									</c:otherwise>
								</c:choose>
							</a>
							
							<!-- 글제목 -->
							<div>
								<a href="CampaignReviewDetail.cm?cam_re_idx=${campaign_review.cam_re_idx }&pageNum=${pageInfo.pageNum}">
									<b>${campaign_review.cam_re_subject }</b>
								</a>
							</div>	
		
							<span>작성자 ${campaign_review.cam_re_id }</span> 
							<span>작성일 ${campaign_review.cam_re_date }</span> 
							<span>조회수 ${campaign_review.cam_re_readcount }</span> 
						</div>
						
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h1>게시물이 존재하지 않습니다.</h1>
				</c:otherwise>
			</c:choose>
			
		</div>
	</main>
	
	
	
	<br>
	
	
	
	<!-- 버튼들 -->
	<div style="clear: both;">
	
		<!-- 글쓰기 -->
		<c:if test="${not empty sessionScope.sId}">
			<section id="buttonArea">
				<button id ="pencil" onclick="location.href='CampaignReviewWriteForm.cm'" >
					<img src="img/community/free-icon-writing-6782423.png" width="47px" height="50px">
				</button>
			</section>
		</c:if>
		
		<section id="pageList">
			<c:choose>
				<c:when test="${pageInfo.pageNum > 1}">
					<input type="button" value="이전" onclick="location.href='CampaignReviewList.cm?pageNum=${pageInfo.pageNum - 1}'">
				</c:when>
				<c:otherwise>
					<input type="button" value="이전">
				</c:otherwise>
			</c:choose>
				
			<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
				<c:choose>
					<c:when test="${pageInfo.pageNum eq i}">
						${i }
					</c:when>
					<c:otherwise>
						<a href="CampaignReviewList.cm?pageNum=${i }">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	
			<c:choose>
				<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
					<input type="button" value="다음" onclick="location.href='CampaignReviewList.cm?pageNum=${pageInfo.pageNum + 1}'">
				</c:when>
				<c:otherwise>
					<input type="button" value="다음">
				</c:otherwise>
			</c:choose>
		</section>
	</div>
	
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>