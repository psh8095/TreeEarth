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
				alert("최대 주문 수량은 10개 이하 입니다.");
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
		
		// 위시리스트 담기 버튼 클릭 시 수행되는 작업들
		$("#insertWishlist").on("click", function() {
// 			alert("확인용");
			if(${empty sessionScope.sId}) {
				alert("로그인이 필요한 기능입니다.");
			} else {
				$.ajax({
					type: "post",
					url: "InsertWishlist.my",
					data: {
						sto_idx: ${param.sto_idx}
					},
					dataType: "text",
					success: function(response) {
						alert("위시리스트에 담았습니다!");
					}
				});
			}
		});
		
		// 구매하기
		$("#order").on("click", function() {
			if(${empty sessionScope.sId}) {
				alert("로그인이 필요한 기능입니다.");
			} else {
				location.href="Order.st?sto_idx=" + ${param.sto_idx} + "&quantity=" + $("#quantity_input").val();
			}
		});
	});
</script>
<!-- <link href="css/button.css" rel="stylesheet"> -->
<link href="css/store.css" rel="stylesheet">


</head>
<body>


	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->


	<!-- 디테일 메인 블럭 -->
   <div class="main1">


	 <hr style="color: gray; opacity: 70%; margin: 50px;">

	
		<!-- 썸네일 -->
		<img id="sto_thumbnai" src="img/store/${store.sto_thum_file}" width="600" height="500">


		<!-- 섬네일 옆	 -->
		<div id="content">
		
		
			<div>
					<table>
						<tr>
							<td class="sto_subject">${store.sto_subject }<br></td>
						</tr>
						<tr>
							<td><span class="sto_tag">${store.sto_tag }<br></span></td>
						</tr>
						<tr>
							<td>${store.sto_content }<br></td>
						</tr>
						<tr>
							<td>가격 : ${store.sto_price }원<br></td>
						</tr>
					</table>
					
					
					<!-- 상품  수량  -->
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
			</div>
			
			
			
			<!-- 장바구니 담기 버튼 -->
			
			<div class="sto_flex">
				<input type="button" value="구매하기" id="order" class="sto_od">
				<input type="button" value="위시리스트 담기" id="insertWishlist" class="sto_od">
				<input type="button" value="장바구니 담기" id="insertCart" class="sto_od">
			</div>
<!-- 				<input type="button" value="위시리스트 담기" id="insertWishlist" class="sto_od"> -->
<!-- 				<input type="button" value="장바구니 담기" id="insertCart" class="sto_od"> -->
<!-- 				<input type="button" value="구매하기" id="order" class="sto_od"> -->
<!-- 			</div> -->


		<!-- 섬네일 옆끝 -->
		</div>


	<hr style="color: gray; opacity: 70%; margin: 50px;">

		
		
		<!-- 구매 후기 버튼 / 상품 QnA 버튼 -->
		<div id="qna">	
			<hr style="color: gray; opacity: 70%; margin: 20px;">
			<a href="StoreReviewList.st?sto_idx=${store.sto_idx }"><button class="w-btn-outline w-btn-green-outline" type="button">구매 후기</button></a> / 
			<a href="StoreQnaList.st?sto_idx=${store.sto_idx }&pageNum=1"><button class="w-btn-outline w-btn-green-outline" type="button">상품 문의</button></a>
			<hr style="color: gray; opacity: 70%; margin: 20px;">
		</div>
		
		
		<div>
			<h1>상세페이지</h1>
		</div>

	<!-- 디테일 메인 블럭 끝-->
	</div>


	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->


</body>
</html>






















