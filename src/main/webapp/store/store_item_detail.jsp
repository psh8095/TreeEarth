<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TreeEarth</title>
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
		<form action="">
		<input type="hidden" name="sto_idx" value="${param.sto_idx }">
			<table>
				<tr>
					<td>
<%-- 					<img src="img/store/<%=itemimg2.getSto_thum_file() %>" width="150" height="150"> --%>
					</td>
				</tr>
				<tr>
					<td>${store.sto_subject }<br></td>
				</tr>
				<tr>
					<td>${store.sto_subject }<br></td>
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
		</form>
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






















