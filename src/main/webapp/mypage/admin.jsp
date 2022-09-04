<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style type="text/css">
	@font-face {
	    font-family: 'HallymGothic-Regular';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2204@1.0/HallymGothic-Regular.woff2') format('woff2');
	    font-weight: 400;
	    font-style: normal;
	}
	
	*{margin: 0; padding: 0; font-family: 'HallymGothic-Regular';}
	
	#adminPage {
		display: flex;
	}
	
	.adminMenu {
		padding: 5%;
	}
	
	.adminMenu > h3 {
		margin-bottom: 1em;
	}
	
	#button {
			color: black; 
			padding: 2px 2px;
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
	
	h3 {
		color: #c5e096;
	}
	
	h1 {
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
	
	<h1>관리자 페이지</h1><br>
	<hr style="color: gray; opacity: 50%;">
	
	<div id="adminPage">
		<div class="adminMenu">
			<h3>상품 관리</h3>
			<!-- 등록한 상품 목록 -->
			<input id="button" type="button" value="등록 된 상품 목록" onclick="location.href='StoreList.st'"><br><br>
			<!-- 상품 등록 -->
			<input id="button" type="button" value="상품 등록" onclick="location.href='StoreWriteForm.st'"><br><br>
		</div>
		
		<div class="adminMenu">
			<h3>주문 관리</h3>
			<!-- 배송 전 주문목록 -->
			<input id="button" type="button" value="주문목록" onclick="location.href='StoreOrderList.st'"><br><br>
		</div>
		
		<div class="adminMenu">
			<h3>캠페인</h3>
			<!-- 캠페인 등록 -->
			<input id="button" type="button" value="캠페인 공고 작성" onclick="location.href='CampaignWriteForm.cp'"><br><br>
			<!-- 캠페인 참가 신청자 조회 -->
			<input id="button" type="button" value="캠페인 신청자 목록" onclick="location.href='CampaignApplyList.cp'"><br><br>
		</div>
		
		<div class="adminMenu">
			<h3>후원</h3>
			<!-- 후원 글 작성하기 -->
			<input id="button" type="button" value="후원 등록하기" onclick="location.href='SupportWriteFormAdmin.su'"><br><br>
			<!-- 후원 내역 조회 -->
			<input id="button" type="button" value="후원 내역 조회" onclick="location.href='SupportHistoryAdmin.my'"><br><br>
		</div>
		
		<div class="adminMenu">
			<h3>커뮤니티</h3>
			<!-- 신고 글 조회 -->
			<input id="button" type="button" value="신고 글 관리" onclick="location.href='CampaignReviewBlockList.my'"><br><br>
		</div>
		
		<div class="adminMenu">
			<h3>회원 목록</h3>
			<!-- 회원 목록 조회 -->
			<input id="button" type="button" value="회원 목록" onclick="location.href='MemberList.my'"><br><br>
		</div>
	</div>
	
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>