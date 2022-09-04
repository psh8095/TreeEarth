<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<style type="text/css">
	@font-face {
	    font-family: 'HallymGothic-Regular';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2204@1.0/HallymGothic-Regular.woff2') format('woff2');
	    font-weight: 400;
	    font-style: normal;
	}
	
	*{margin: 0; padding: 0; font-family: 'HallymGothic-Regular';}
	
	.table {
		margin: 0 0 40px 0;
		width: 100%;
		box-shadow: 0 1px 3px rgba(0,0,0,0.2);
		display: table;
	}
	
	.row {
		display: table-row;
	}
	
	.cell {
		display: table-cell;
	}
	
	.header {
		background-color: #c5e096;
		color: #ffffff;
		font-weight: 600;
	}

	h1 {
		text-align: center;
		color: #c5e096;
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
	
	<h1>신고 글 조회</h1>
	<hr style="color: gray; opacity: 50%; margin-bottom: 15px;">
	
	<h3>1. 캠페인 참여후기</h3>
	
	<div class="table">
		<div class="row header">
			<div class="cell">문제의 글</div>
			<div class="cell">신고자</div>
			<div class="cell">신고일</div>
			<div class="cell">신고이유</div>
		</div>
		<c:choose>
			<c:when test="${not empty blockList }">
				<c:forEach var="cam_re_block" items="${blockList }">
					<div class="row">
						<div class="cell" onclick="location.href='CampaignReviewBlockDetail.my?cam_re_block_ref=${cam_re_block.cam_re_block_ref}'">${cam_re_block.cam_re_block_ref }</div>
						<div class="cell">${cam_re_block.cam_re_block_id }</div>
						<div class="cell">${cam_re_block.cam_re_block_date }</div>
						<div class="cell">${cam_re_block.cam_re_block_reason }</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="row">게시물이 존재하지 않습니다.</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<h3>2. 자유게시판</h3>
	
	<div class="table">
		<div class="row header">
			<div class="cell">문제의 글</div>
			<div class="cell">신고자</div>
			<div class="cell">신고일</div>
			<div class="cell">신고이유</div>
		</div>
		<c:choose>
			<c:when test="${not empty freeBlockList }">
				<c:forEach var="free_block" items="${freeBlockList }">
					<div class="row">
						<div class="cell" onclick="location.href='FreeBoardBlockDetail.my?free_block_ref=${free_block.free_block_ref}'">${free_block.free_block_ref }</div>
						<div class="cell">${free_block.free_block_id }</div>
						<div class="cell">${free_block.free_block_date }</div>
						<div class="cell">${free_block.free_block_reason }</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="cell">신고목록이 존재하지 않습니다</div>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>