<%@page import="vo.store.StoreDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
// out.println(sto_idx);
// String sId = session.getAttribute("sId").toString();


// StoreDTO store = new StoreDTO();
// store.setSto_thum_file("sto_thum_file"); 
// store.setSto_content_file("sto_content_file");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TreeEarth</title>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() { // 수량 버튼 추가, 감소 조작 작업
		var quantity = $("#quantity_input").val(); // 수량 값
	
		var quantity_price = $("#quantity_price").html(); // 상품 가격 값
		
		var totalPrice = 0; // 총 금액 합계 변수 선언 및 초기화
		
		$("#plus_btn").on("click", function() {
			if(quantity < 10) {
				$("#quantity_input").val(++quantity); // 객체이기 때문에
				var plusBtn = $("#quantity_input").val(); // 변수 선언 후 따로 val 값을 줌(=> 상품 수량 변경 총 금액 합계 계산)
	// 			alert(quantity_price); // 상품 가격 확인용
	
				totalPrice = quantity_price * plusBtn;
	// 			alert(quantity_price); // 상품 금액 확인
	// 			alert(totalPrice); // 금액 총 합계 확인
				$("#quantity_price").html(totalPrice); // 수량 + 버튼 클릭 시 총 상품 금액 화면 표시	
			} else {
				alert("최대 주문 수량은 10개 이상 입니다.");
			}
		});
		
		$("#minus_btn").on("click", function() {
			if(quantity > 1) {
				$("#quantity_input").val(--quantity);
				var minusBtn = $("#quantity_input").val();
				
				totalPrice = totalPrice - quantity_price;
// 				alert(quantity_price);
// 				alert(totalPrice);
				$("#quantity_price").html(totalPrice); // 수량 - 버튼 클릭 시 총 상품 금액 화면 표시
			} else {
				alert("최소 주문 수량은 1개 이상 입니다.");
			}
		});
		
		// 장바구니 담기 버튼 클릭 시 수행되는 작업들
		$("#insertCart").on("click", function() {
// 			alert("확인용");
			if(${empty sessionScope.sId}) {
				alert("로그인이 필요한 기능입니다.");
			} else {
				$.ajax({
					type: "post",
					url: "InsertCart.my",
					data: {
						sto_idx: ${param.sto_idx}
					},
					dataType: "text",
					success: function(response) {
						alert("장바구니에 담았습니다!");
					}
				});
			}
		});
		
		// 구매하기
		$("#order").on("click", function() {
			location.href="Order.st?sto_idx=" + ${param.sto_idx} + "&quantity=" + $("#quantity_input").val();
		});
	});
</script>
<link href="css/index.css" rel="stylesheet">
<style type="text/css">
	#buttonArea {
		margin: auto;
		width: 1024px;
		text-align: right;
	}
	
	#tr1 {
	display: flex;
	display: inline;
	}
	
	#quantity_price {
	font-size: 20px;
	}
	
/* 	#txt { */
/* 	font-size: 16px; */
/* 	} */
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	<section>
		<h2>상품 상세 내용 보기</h2>
		<h1>${store.sto_idx }</h1>
			<table>
				<tr>
					<td><img src="img/store/${store.sto_thum_file}" width="300" height="500"></td>
				</tr>
				<tr>
					<td>${store.sto_subject }<br></td>
				</tr>
				<tr>
					<td>${store.sto_content }<br></td>
				</tr>
				<tr>
					<td>${store.sto_tag }<br></td>
				</tr>
				<tr>
					<td>판매가 : ${store.sto_price }원<br></td>
				</tr>
			</table>
			<div id="button">
				<div id="button_quantity"> 
					<span>
						<button id="minus_btn">-</button>
					</span>
						<input type="text" id="quantity_input" name="amount" value="1" size="2" readonly="readonly">
					<span>
						<button id="plus_btn">+</button>
					</span><br>
						<span>총 상품금액&nbsp;&nbsp;</span><span id="quantity_price">${store.sto_price }</span><span>원</span>
				</div>
			</div>
	</section>
	
	<!-- 장바구니 담기 버튼 -->
	<div>
		<input type="button" value="장바구니 담기" id="insertCart">
		<input type="button" value="구매하기" id="order">
	</div>
	<hr>
	<!-- 구매 후기 버튼 / 상품 QnA 버튼 -->
	<div>
		<a href="StoreReviewList.st?sto_idx=${store.sto_idx }"><input type="button" value="구매 후기" id="store_review"></a>
		<a href="StoreQnaList.st?sto_idx=${store.sto_idx }"><input type="button" value="상품 문의" id="store_qna"></a>
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>






















