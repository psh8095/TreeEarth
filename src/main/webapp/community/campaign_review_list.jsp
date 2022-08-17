<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>treeEarth</title>
<link href="../css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<section id="">
	<h2>캠페인후기 글 목록</h2>
		<c:choose>
			<c:when test="${not empty campaignReviewList and pageInfo.itemListCount gt 0}">
				<c:forEach var="campaign_review" items="${campaignReviewList }">
					<div style="float: left; width: 33%;">
						<table>
							<tr>
								<td colspan="2">
									<a href="CampaignReviewDetail.cm?cam_re_idx=${campaign_review.cam_re_idx }&pageNum=${pageInfo.pageNum}">
										<c:choose>
											<c:when test="${not empty campaign_review.cam_re_file}">
												<img alt="" src="upload/${campaign_review.cam_re_file }">
											</c:when>
											<c:otherwise>
												<img alt="이미지없음" src="img/community/tree.png" width="500px">
											</c:otherwise>
										</c:choose>
									</a>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<a href="CampaignReviewDetail.cm?cam_re_idx=${campaign_review.cam_re_idx }&pageNum=${pageInfo.pageNum}">
										<b>${campaign_review.cam_re_subject }</b>
									</a>
								</td>
							</tr>
							<tr>
								<td>작성자</td>
								<td>${campaign_review.cam_re_id }</td>
							</tr>
							<tr>
								<td>작성일</td>
								<td>${campaign_review.cam_re_date }</td>
							</tr>
							<tr>
								<td>조회수</td>
								<td>${campaign_review.cam_re_readcount }</td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>게시물이 존재하지 않습니다.</h1>
			</c:otherwise>
		</c:choose>
	</section>
	
	<br>
	
	<section id="buttonArea">
		<input type="button" value="글쓰기" onclick="location.href='CampaignReviewWriteForm.cm'" />
	</section>
	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='CampaignReviewList.cm?pageNum=${pageNum - 1}'">
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
					<a href="CampaignReviewList.bo?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='CampaignReviewList.bo?pageNum=${pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>