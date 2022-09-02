<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@font-face {
    font-family: 'HallymGothic-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2204@1.0/HallymGothic-Regular.woff2') format('woff2');
    font-weight: 400;
    font-style: normal;
}

*{margin: 0; padding: 0; font-family: 'HallymGothic-Regular';}

td {
text-align: center;
}
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<div id="main">
		<h1 style="margin: 30px 0px 50px 0px">주문 내역</h1>
	</div>
	<hr>
	
	<c:choose>
		<c:when test="${empty orderList }">
			<h1>주문한 상품이 없습니다.</h1>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<td width="100">배송 현황</td>
					<td width="150">주문 번호</td>
					<td width="200">상품</td>
					<td width="200">상품명</td>
					<td width="50">수량</td>
					<td width="150">상품별 가격</td>
					<td width="150">총 결제 금액</td>
					<td width="150">구매 일자</td>
					<td>후기 작성</td>
				</tr>
				<c:forEach var="order" items="${orderList }">
					<tr>
						<td>${order.order_status }</td>
						<td width="150">${order.order_id }</td>
						<td width="200"><img src="img/store/${order.sto_thum_file }" width="150"></td>
						<td width="200">${order.sto_subject }</td>
						<td width="50">${order.quantity }</td>
						<td width="150">${order.sto_price * order.quantity}</td>
						<td width="150">${order.amount }</td>
						<td width="150">${order.order_date }</td>
						<td onclick="location.href='StoreReviewWriteForm.st?sto_idx=${order.sto_idx }'"><button class="w-btn-outline w-btn-green-outline" type="button">구매 후기 작성</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>	
	</c:choose>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>