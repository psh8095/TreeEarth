<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		// 위시리스트 한 개 삭제
		$(".rm_cart").on("click", function() {
			if(confirm("장바구니에서 삭제하시겠습니까?")) {
				alert("장바구니에서 삭제했습니다.");
				location.href = "DeleteWishlist.my?sto_idx=" + $(".sto_idx").eq($(".rm_wishlist").index(this)).val();
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
	
	<h1>위시리스트</h1>
	<c:choose>
		<c:when test="${empty wishlist}">
			<h1>위시리스트를 채워주세요.</h1>
		</c:when>
		<c:otherwise>
			<table>
				<c:forEach var="wishlist" items="${wishlist }">
					<tr>
						<td><input type="checkbox" class="checkWishlist"></td>
						<td><img src="img/store/${wishlist.sto_thum_file }" width="150"></td>
						<td>${wishlist.sto_subject }</td>
						<td><span class="price">${wishlist.sto_price }</span> 원</td>
						<td><input type="button" class="rm_wishlist" value="삭제하기">
							<input type="hidden" class="sto_idx" value="${wishlist.sto_idx }"></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>	
	</c:choose>
	<hr>
	<div>
		<input type="button" id="allCheck" value="전체 선택">
		<input type="button" id="uncheck" value="전체 해제">
		<input type="button" id="deleteAll" value="위시리스트 비우기">
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>
