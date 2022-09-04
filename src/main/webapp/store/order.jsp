<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/mypage.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<style type="text/css">
td {
	text-align: center;
}
</style>
<script>
	$(function() {
		// 파라미터를 저장할 배열 및 변수 생성
		var total = 0;
		var sto_idx = [];
		var quantity = [];
		for(var i = 0; i < ${storeList.size()}; i++) {
			total += parseInt($(".amount").eq(i).html());
			sto_idx.push($(".sto_idx").eq(i).val());
			quantity.push($(".quantity").eq(i).html());
		}
		
// 		for(var i = 0; i < sto_idx.length; i++) {
// 			alert(sto_idx[i]);
// 			alert(quantity[i]);
// 		}
		
		$(".totalPrice").html(total);
		
		// 결제 기능
		IMP.init("imp73101414");
		
		$("#my_order_button2").on("click", function() {
			// 결제 기능 - 변수 선언
			var date = new Date();
			var today = date.getFullYear() + "" + (date.getMonth()+1) + "" + date.getDate() + "" + 
						date.getHours() + "" + date.getMinutes() + "" + date.getSeconds();
			
			IMP.request_pay({
				pg: "html5_inicis",
				pay_method: "card",
				merchant_uid: "order_" + today,
				name: "트리어스",
				amount: total,
				buyer_email: "${member.mem_email}",
				buyer_name: "${member.mem_name}",
				buyer_tel: "${member.mem_phone}",
				buyer_addr: "${member.mem_address}"
			}, function(rsp) {
				if(rsp.success) {
					alert("결제가 정상적으로 완료되었습니다.");
					
					$.ajax({
						type: "get",
						url: "InsertOrder.st",
						data: {
							order_id: rsp.merchant_uid,
							mem_name: rsp.buyer_name,
							mem_phone: rsp.buyer_tel,
							mem_email: rsp.buyer_email,
							amount: total,
							mem_address: rsp.buyer_addr,
							sto_idx: sto_idx,
							quantity: quantity
						},
						dataType: "text",
						success: function(response) {
							location.href="OrderList.my"; // 후에 주문 내역 조회로 이동
						}
					});
				} else {
					alert("결제에 실패하였습니다.");
					alert(rsp.error_msg);
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


	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->


	<h1>주문하기</h1>
	<table>
		<tr>
			<td>상품</td>
			<td width="300">상품명</td>
			<td>수량</td>
			<td width="300">금액</td>
		</tr>
		<c:forEach var="store" items="${storeList }" varStatus="vs">
			<tr>
				<td><img src="img/store/${store.sto_thum_file }" width="150"></td>
				<td>${store.sto_subject }</td>
				<td><span class="quantity">${paramValues.quantity[vs.index] }</span></td>
				<td><span class="amount">${store.sto_price * paramValues.quantity[vs.index]}</span>원</td>
			</tr>
			<input type="hidden" class="sto_idx" value="${store.sto_idx }">
		</c:forEach>
	</table>
	
	<!-- 결제 창 -->
	<div id="orderDiv">
		<div class="my_back">
			<div class="orderSpan">
				<span>상품 금액<span class="totalPrice">0</span>원</span>
			</div>
			<div class="orderSpan">
				<span>상품 할인 금액<span>0</span>원</span>
			</div>
			<div class="orderSpan">
				<span>배송비<span >0</span>원</span>
			</div>
			<div class="orderSpan4">
				<h3>결제 예정 금액<span class="totalPrice">0</span>원</h3>
			</div>
		</div>
		<div >
			<input id="my_order_button2" type="button" value="결제하기">
		</div>
	</div>	

	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>