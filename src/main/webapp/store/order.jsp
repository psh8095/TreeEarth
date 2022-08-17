<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.js"></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script>
	$(function() {
		var total = ${store.sto_price} * ${param.quantity};
		$("#amount").html(total);
		
		// 결제 기능
		IMP.init("imp73101414");
		
		$("#order").on("click", function() {
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
						type: "post",
						url: "InsertOrder.st",
						data: {
							order_id: rsp.merchant_uid,
							mem_name: rsp.buyer_name,
							mem_phone: rsp.buyer_tel,
							mem_email: rsp.buyer_email,
							amount: total,
							mem_address: rsp.buyer_addr,
							sto_idx: ${param.sto_idx},
							quantity: ${param.quantity}
						},
						dataType: "text",
						success: function(response) {
							location.href="./"; // 후에 주문 내역 조회로 이동
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

	<h1>주문하기</h1>
	<table>
		<tr>
			<td>상품</td>
			<td width="300">상품명</td>
			<td>수량</td>
			<td width="300">금액</td>
		</tr>
		<tr>
			<td><img src="img/store/${store.sto_thum_file }" width="150"></td>
			<td>${store.sto_subject }</td>
			<td>${param.quantity }</td>
			<td><span id="amount"></span>원</td>
		</tr>
	</table>

	<input type="button" id="order" value="결제하기">
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>