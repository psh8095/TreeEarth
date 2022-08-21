<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 - 캠페인</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<c:choose>
		<c:when test="${empty campaignList }">
			<h1>현재 진행중인 캠페인이 없습니다.</h1>
		</c:when>
		<c:otherwise>
			<table>
				<c:forEach var="cam" items="${campaignList }">
					<tr>
						<td><img src="img/campaign/${cam.cam_thum_file }" width="100"></td>
					</tr>
					<tr>
						<td>${cam.cam_subject }</td>
					</tr>
					<tr>
						<td>${cam.cam_content }</td>
					</tr>
					<tr>
						<td>${cam.cam_date }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>	
	</c:choose>
	
	<div>
		<a href="CampaignApplyForm.cp?cam_idx=1">캠페인 참가 신청</a>
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>