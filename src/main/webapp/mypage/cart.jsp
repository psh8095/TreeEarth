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
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script type="text/javascript">
	$(function() {
		// 장바구니에 담긴 상품 각각의 가격을 저장할 배열 선언 및 배열에 가격 저장
		var price = [];
		for(var i = 0; i < ${cart.size()}; i++) {
			price[i] = parseInt($(".price").eq(i).html());
// 			alert(price[i]);
		}
		
		// 클릭 시 수량 감소
		$(".minus").on("click", function() {
// 			alert($(".minus").index(this));
			if($(".checkCart").eq($(".minus").index(this)).is(":checked")) {
				alert("선택 해제 후 다시 시도해주세요.");
				return;
			}
			
			var quantity = $(".quantity").eq($(".minus").index(this)).val();
			
			if(quantity > 1) {
				quantity--;
				$(".quantity").eq($(".minus").index(this)).val(quantity);
				$(".price").eq($(".minus").index(this)).html(price[$(".minus").index(this)] * quantity);
			} else {
				alert("최소 수량은 1개입니다.");
			}
		});
		
		// 클릭 시 수량 증가
		$(".plus").on("click", function() {
// 			alert($("button").index(this));
			if($(".checkCart").eq($(".plus").index(this)).is(":checked")) {
				alert("선택을 해제 후 다시 시도해주세요.");
				return;
			}
				
			var quantity = $(".quantity").eq($(".plus").index(this)).val();
			
			if(quantity < 10) {
				quantity++;
				$(".quantity").eq($(".plus").index(this)).val(quantity);
				$(".price").eq($(".plus").index(this)).html(price[$(".plus").index(this)] * quantity);
			} else {
				alert("최대 수량은 10개입니다.");
			}
		});
		
		// 선택한 상품의 가격을 더하기 위한 변수 선언
		var total = 0;
		
		// 선택한 상품의 가격을 더해서 총 결제 금액 표시
		$(".checkCart").on("change", function() {
			if($(".checkCart").eq($(".checkCart").index(this)).is(":checked")) {
				total += parseInt($(".price").eq($(".checkCart").index(this)).html());
// 				alert(total);

				$("#totalPrice").html(total);
			} else {
				if(total > 0) {
					total -= parseInt($(".price").eq($(".checkCart").index(this)).html());
	
					$("#totalPrice").html(total);
				}
			}
		});
		
		// 장바구니에서 삭제
		$(".rm_cart").on("click", function() {
			if(confirm("장바구니에서 삭제하시겠습니까?")) {
				alert("장바구니에서 삭제했습니다.");
				location.href = "DeleteCart.my?sto_idx=" + $(".sto_idx").eq($(".rm_cart").index(this)).val();
			}
		});
		
		// 장바구니 전체 삭제
		$("#deleteAll").on("click", function() {
			if(confirm("장바구니를 비우시겠습니까?")) {
				alert("장바구니를 비웠습니다.");
				location.href = "DeleteCart.my?sto_idx=0";
			}
		});
		
		// 전체 선택 버튼 클릭 시 동작
		$("#allCheck").on("click", function() {
			for(var i = 0; i < ${cart.size()}; i++) {
				if(!$(".checkCart").eq(i).is(":checked")) {
					$(".checkCart").eq(i).prop("checked", true);
					total += parseInt($(".price").eq(i).html());
				}
			}
			
			$("#totalPrice").html(total);
		});
		
		// 전체 해제 버튼 클릭 시 동작
		$("#uncheck").on("click", function() {
			for(var i = 0; i < ${cart.size()}; i++) {
				if($(".checkCart").eq(i).is(":checked")) {
					$(".checkCart").eq(i).prop("checked", false);
					total -= parseInt($(".price").eq(i).html());
				}
			}
			
			$("#totalPrice").html(total);
		});
		
		// 주문하기 버튼 클릭 시 결제 페이지로 이동
		$("#order").on("click", function() {
			var sto_idxs = [];
			var quantities = [];
			var amount = parseInt($("#totalPrice").html());
			
			for(var i = 0; i < ${cart.size()}; i++) {
				if($(".checkCart").eq(i).is(":checked")) {
// 					alert($(".sto_idx").eq(i).val());
// 					alert($(".quantity").eq(i).val());
// 					alert(parseInt($("#totalPrice").html()));
					sto_idxs.push($(".sto_idx").eq(i).val());
					quantities.push($(".quantity").eq(i).val());
				}
			}
			
			if(parseInt($("#totalPrice").html()) > 0) {
				location.href="Payment.st";
			} else {
				alert("결제할 금액이 없습니다.");
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
	
		<h1>장바구니</h1>
		
		
		<hr style="color: gray; opacity: 70%; margin: 50px;">
				
			<div>
				<input type="button" id="allCheck" value="전체 선택">
				<input type="button" id="uncheck" value="전체 해제">
				<input type="button" id="deleteAll" value="장바구니 비우기">
			</div>
		
		<hr>
	
	
				<!-- 게시판 구별 -->
				<div id="my_title">
					<span class="my_img">사진</span>
					<span class="my_subject">제목</span>
					<span class="my_button">수량</span>
					<span class="my_price">가격</span>
				</div>
			
		
		 <hr>
		
		
		<div id="listDiv">
			<c:choose>
				<c:when test="${empty cart }">
					<h1>장바구니가 비어있습니다.</h1>
				</c:when>
				<c:otherwise>
					<c:forEach var="cart" items="${cart }">
					
					
						<div class="my_img">
							<input type="checkbox" class="checkCart">
							<img src="img/store/${cart.sto_thum_file }" width="150">
						</div>
						
						
						<div class="my_subject">
							${cart.sto_subject }
						</div>
				
				
						<!-- 수량 조절 버튼 -->
						<div class="my_button">
							<input type="button" class="minus" value="-">
							<input type="text" class="quantity" value="1" size="1" readonly="readonly">
							<input type="button" class="plus" value="+">
						
						</div>	
						
						
						<div class="my_price">
							<span class="price">${cart.sto_price }</span> 원
							<input type="button" class="rm_cart" value="삭제하기">
							<input type="hidden" class="sto_idx" value="${cart.sto_idx }">
						</div>
						
						<hr>
						
					</c:forEach>
				</c:otherwise>	
			</c:choose>
		</div>
	
	
	
		<div id="orderDiv">
			<div>
				<h2>결제 예정 금액 &nbsp;&nbsp;<span id="totalPrice">0</span>원</h2>
			</div>
			
			
			<div>
				<h3>
					선택한 상품&nbsp;&nbsp;
				</h3>
			</div>
			
			<div >
				<input id="my_order_button" type="button" id="order" value="주문하기">
			</div>
			
		</div>	

	</div>
	
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>
