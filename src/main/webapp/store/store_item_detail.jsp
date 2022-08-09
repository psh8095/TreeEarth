<%@page import="vo.store.StoreDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
out.println(sto_idx);
String sId = session.getAttribute("sId").toString();

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
// 장바구니 담기 버튼 클릭 시 수행되는 작업들
	$(function() {
		$("#insertCart").on("click", function() {
// 			alert("확인용");
			if(<%=sId %> == null) {
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
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	<section>
		<h2>상품 상세 내용 보기</h2>
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
					<td>${store.sto_price }<br></td>
				</tr>
			</table>
			수량 : <input type="hidden" name="quantity" value="">
			<input type="text" name="amount" value="1" size="3" max="">
			<input type="button" value=" + " name="add">
			<input type="button" value=" - " name="minus"><br>
			금액 : <input type="text" name="sum" size="11" readonly="readonly">원
	</section>
	
	
	
	<!-- 장바구니 담기 버튼 -->
	<div>
		<input type="button" value="장바구니 담기" id="insertCart">
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>






















