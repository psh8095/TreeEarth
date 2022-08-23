<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 - 캠페인</title>
<style type="text/css">
	#listBar {
		text-align: center;
	}
	
	span {
		border: 0.5px solid #000;
	}
</style>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		// 캠페인 리스트 확인 시 1번 캠페인 출력
		$.ajax({
			type: "post",
			url: "CampaignDetail.cp",
			data: {
				cam_idx: 1
			},
			dataType: "text",
			success: function(response) {
				$("#detailView").html(response);
			}
		});
		
		// 캠페인 제목 클릭 시 해당 캠페인 내용 출력
		$(".cam_subject").on("click", function() {
			$.ajax({
				type: "post",
				url: "CampaignDetail.cp",
				data: {
					cam_idx: $(".cam_idx").eq($(".cam_subject").index(this)).html()
				},
				dataType: "text",
				success: function(response) {
					$("#detailView").html(response);
				}
			});
		});
	});
</script>
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
			<section id="listBar">
				<c:forEach var="cam" items="${campaignList }">
					<span class="cam_subject">${cam.cam_subject }</span>
					<span class="cam_idx" hidden="">${cam.cam_idx }</span>
				</c:forEach>
			</section>
			<section id="detailView"></section>
		</c:otherwise>	
	</c:choose>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>