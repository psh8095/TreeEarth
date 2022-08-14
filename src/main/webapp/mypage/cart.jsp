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
		// 장바구니에 담긴 상품 각각의 가격을 저장할 배열 선언 및 배열에 가격 저장
		var price = [];
		for(var i = 0; i < ${cart.size()}; i++) {
			price[i] = parseInt($(".price").eq(i).html());
// 			alert(price[i]);
		}
		
		// 클릭 시 수량 감소
		$("table input[type=button]").on("click", function() {
// 			alert($("input[type=button]").index(this));
			if($(".checkCart").eq($("input[type=button]").index(this)).is(":checked")) {
				alert("선택을 해제 후 다시 시도해주세요.");
				return;
			}
			
			var amount = $("table input[type=text]").eq($("input[type=button]").index(this)).val();
			
			if(amount > 1) {
				amount--;
				$("table input[type=text]").eq($("input[type=button]").index(this)).val(amount);
				$(".price").eq($("input[type=button]").index(this)).html(price[$("input[type=button]").index(this)] * amount);
			} else {
				alert("최소 수량은 1개입니다.");
			}
		});
		
		// 클릭 시 수량 증가
		$("table button").on("click", function() {
// 			alert($("button").index(this));
			if($(".checkCart").eq($("button").index(this)).is(":checked")) {
				alert("선택을 해제 후 다시 시도해주세요.");
				return;
			}
				
			var amount = $("table input[type=text]").eq($("button").index(this)).val();
			
			if(amount < 10) {
				amount++;
				$("table input[type=text]").eq($("button").index(this)).val(amount);
				$(".price").eq($("button").index(this)).html(price[$("button").index(this)] * amount);
			} else {
				alert("최대 수량은 10개입니다.");
			}
		});
		
		// 선택한 상품의 가격을 더하기 위한 변수 선언
		var total = 0;
		
		// 선택한 상품의 가격을 더해서 총 결제 금액 표시
		$(".checkCart").on("click", function() {
			if($(".checkCart").eq($(".checkCart").index(this)).is(":checked")) {
				total += parseInt($(".price").eq($(".checkCart").index(this)).html());
// 				alert(total);

				$("#totalPrice").html(total);
			} else {
				total -= parseInt($(".price").eq($(".checkCart").index(this)).html());

				$("#totalPrice").html(total);
			}
		});
		
		$("#rm_cart").on("click", function() {
			if(confirm("장바구니에서 삭제하시겠습니까?")) {
// 				$.ajax({
// 					type: "post",
// 					url: "DeleteCart.my",
// 					data: {
// 						sto_idx: 
// 					},
// 					dataType: "text",
// 					success: function(response) {
						
// 					}
// 				});
// 				alert("삭제되었습니다");
			}
		});
	});
</script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<h1>장바구니</h1>
	<c:choose>
		<c:when test="${empty cart }">
			<h1>장바구니가 비어있습니다.</h1>
		</c:when>
		<c:otherwise>
			<table>
				<c:forEach var="cart" items="${cart }">
					<tr>
						<td><input type="checkbox" class="checkCart"></td>
						<td><img src="img/store/${cart.sto_thum_file }" width="150"></td>
						<td>${cart.sto_subject }</td>
						<td>
							<!-- 수량 조절 버튼 -->
							<input type="button" value="-">
							<input type="text" class="amount" value="1" size="1">
							<button id="plus">+</button>
						</td>
						<td><span class="price">${cart.sto_price }</span> 원</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>	
	</c:choose>
	
	<hr>
	<div>
		<h2>결제 예정 금액 &nbsp;&nbsp;<span id="totalPrice">0</span>원</h2>
	</div>
	<div>
		<h3>
		선택한 상품&nbsp;&nbsp;
		<input type="button" id="order" value="주문하기">&nbsp;&nbsp;
		<input type="button" id="rm_cart" value="삭제하기">
		</h3>
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>