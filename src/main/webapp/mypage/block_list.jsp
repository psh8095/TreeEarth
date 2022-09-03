<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	<h1>신고 글 조회</h1>
	<h3>1. 캠페인 참여후기</h3>
	
	<table>
		<tr>
			<td>[문제의 글!]</td>
			<td>[신고자]</td>
			<td>[신고일]</td>
			<td>[신고이유]</td>
		</tr>
		<c:choose>
			<c:when test="${not empty blockList }">
				<c:forEach var="cam_re_block" items="${blockList }">
					<tr onclick="location.href='CampaignReviewBlockDetail.my?cam_re_block_ref=${cam_re_block.cam_re_block_ref}'">
						<td>${cam_re_block.cam_re_block_ref }</td>
						<td>${cam_re_block.cam_re_block_id }</td>
						<td>${cam_re_block.cam_re_block_date }</td>
						<td>${cam_re_block.cam_re_block_reason }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>게시물이 존재하지 않습니다.</h1>
			</c:otherwise>
		</c:choose>
	</table>
	
	<h3>2. 자유게시판</h3>
	<table>
		<tr>
			<td>[문제의 글]</td>
			<td>[신고자]</td>
			<td>[신고일]</td>
			<td>[신고이유]</td>
		</tr>
		<c:choose>
			<c:when test="${not empty freeBlockList }">
				<c:forEach var="free_block" items="${freeBlockList }">
					<tr onclick="location.href='FreeBoardBlockDetail.my?free_block_ref=${free_block.free_block_ref}'">
						<td>${free_block.free_block_ref }</td>
						<td>${free_block.free_block_id }</td>
						<td>${free_block.free_block_date }</td>
						<td>${free_block.free_block_reason }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h3>~게시물이 존재하지 않습니다~</h3>
			</c:otherwise>
		</c:choose>
	</table>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>