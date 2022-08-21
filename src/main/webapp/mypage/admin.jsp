<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<h1>관리자 페이지</h1>
	<h3>1. 상품 관리</h3>
		<!-- 등록한 상품 목록 -->
		<input type="button" value="등록 된 상품 목록" onclick="location.href='store_list.jsp'"><br><br>
		<!-- 상품 등록 -->
		<input type="button" value="상품 등록" onclick="location.href='StoreWriteForm.st'"><br>
	
	<h3>2. 주문 관리</h3>
		<!-- 배송 전 주문목록 -->
		<input type="button" value="배송 전인 주문목록" onclick="'#'"><br><br>
	
		<!-- 배송 중 주문목록 -->
		<input type="button" value="배송 중인 주문 목록" onclick="'#'"><br><br>
	
		<!-- 배송 완료 주문목록 -->
		<input type="button" value="배송완료 된 주문 목록" onclick="'#'"><br><br>
	
	<h3>3. 간단 리뷰/문의 답변</h3>

		<!-- 간단 리뷰 답변 -->
		<input type="button" value="간단리뷰 답변하기" onclick="'#'"><br><br>
		<!-- 회원문의 답변 -->
		<input type="button" value="회원문의 답변하기" onclick="'#'"><br><br>
	<h3>4. 캠페인</h3>
		<!-- 캠페인 등록 -->
		<input type="button" value="캠페인 공고 작성" onclick="location.href='CampaignWriteForm.cp'"><br><br>
	<h3>5. 후원</h3>
		<!-- 후원 글 작성하기 -->
		<input type="button" value="후원 등록하기" onclick="location.href='SupportWriteFormAdmin.su'"><br><br>
	<h3>6. 커뮤니티</h3>
		<!-- 신고 글 조회 -->
		<input type="button" value="신고 글 관리" onclick="location.href='CampaignReviewBlockList.my'"><br><br>
</body>
</html>