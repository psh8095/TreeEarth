<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="">
	<h2>캠페인후기 글 목록</h2>
	<table border="1">
		<tr id="tr_top">
			<td width="100px">번호</td>
			<td>제목</td>
			<td width="150px">작성자</td>
			<td width="150px">날짜</td>
			<td width="100px">조회수</td>
		</tr>
		
		<c:choose>
			<c:when test="${not empty campaignReviewList and pageInfo.itemListCount gt 0}">
				<c:forEach var="campaign_review" items="${campaignReviewList }">
					<tr>
						<td>${campaign_review.cam_re_idx }</td>
						<td id="subject">
							<a href="CampaignReviewDetail.cm?cam_re_idx=${campaign_review.cam_re_idx }&pageNum=${pageInfo.pageNum}">
								${campaign_review.cam_re_subject }
							</a>
						</td>
						<td>${campaign_review.cam_re_id }</td>
						<td>${campaign_review.cam_re_date }</td>
						<td>${campaign_review.cam_re_readcount }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</table>
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
</body>
</html>