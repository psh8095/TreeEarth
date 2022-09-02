<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/mypage.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		// 위시리스트 한 개 삭제
		$("#rm_wishlist").on("click", function() {
			if(confirm("위시리스트에서 삭제하시겠습니까?")) {
				// 파라미터 저장할 배열 생성
				var sto_idxs = [];
				
				for(var i = 0; i < ${wishlist.size()}; i++) {
					if($(".checkWishlist").eq(i).is(":checked")) {
						sto_idxs.push($(".sto_idx").eq(i).val());
					}
				}
				
				// 파라미터 연결할 변수 선언
				var p = "";
				
				for(var i = 0; i < sto_idxs.length; i++) {
					p += "sto_idx=" + sto_idxs[i] + "&";
				}
			
				alert("위시리스트에서 삭제했습니다.");
				location.href = "DeleteWishlist.my?" + p;
			}
		});
		
		// 위시리스트 전체 삭제
		$("#deleteAll").on("click", function() {
			if(confirm("위시리스트를 비우시겠습니까?")) {
				alert("위시리스트를 비웠습니다.");
				location.href = "DeleteWishlist.my?sto_idx=0";
			}
		});
		
		// 전체 선택 버튼 클릭 시 동작
		$("#allCheck").on("click", function() {
			for(var i = 0; i < ${wishlist.size()}; i++) {
				if(!$(".checkWishlist").eq(i).is(":checked")) {
					$(".checkWishlist").eq(i).prop("checked", true);
				}
			}
		});
		
		// 전체 해제 버튼 클릭 시 동작
		$("#uncheck").on("click", function() {
			for(var i = 0; i < ${wishlist.size()}; i++) {
				if($(".checkWishlist").eq(i).is(":checked")) {
					$(".checkWishlist").eq(i).prop("checked", false);
				}
			}
		});
		
	});
</script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<div id="main">
		<h1 style="margin: 30px 0px 50px 0px">위시리스트</h1>
			<div>
				<input type="button" id="allCheck" value="전체 선택">
				<input type="button" id="uncheck" value="전체 해제">
				<input type="button" id="rm_wishlist" value="선택 삭제">
				<input type="button" id="deleteAll" value="위시리스트 비우기">
			</div>
		<hr>
			<!-- 게시판 구별 -->
			<div id="my_title">
				<span class="my_check"></span>
				<span class="my_img">사진</span>
				<span class="my_subject">제목</span>
				<span class="my_button">수량</span>
				<span class="my_price">가격</span>
			</div>
		 <hr>
		<div id="listDiv">
			<c:choose>
				<c:when test="${empty wishlist }">
						<h1>위시리스트를 채워주세요.</h1>
				</c:when>
				<c:otherwise>
					<c:forEach var="wishlist" items="${wishlist }">
						<div class="my_check">
							<input type="checkbox" class="checkWishlist">
						</div>
						<div class="my_img">
							<img src="img/store/${wishlist.sto_thum_file }" width="150">
						</div>
						<div class="my_subject">
							${wishlist.sto_subject }
						</div>
						<div class="my_price">
							<span class="price">${wishlist.sto_price }</span> 원
							<input type="hidden" class="sto_idx" value="${wishlist.sto_idx }">
						</div>
						<hr>
					</c:forEach>
				</c:otherwise>	
			</c:choose>
		</div>
	
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>
