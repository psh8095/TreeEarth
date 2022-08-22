<%@page import="vo.support.SupportDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	int idx = Integer.parseInt(request.getParameter("idx"));
// 	out.print(idx);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<link href="css/button.css" rel="stylesheet">

<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script src="js/jquery-3.6.0.js"></script>

<script type="text/javascript">


// 수량 버튼 추가, 감소 조작 작업
$(function() {
	
<%-- 	alert(<%=idx%>); --%>
	var total_money = 0;
	
	
	//직접 입력
	$("#text_money").on("change", function() {
		var text_money = $("#text_money").val();
		total_money = Number(text_money); //값을 숫자로 형변환
		
		$("#text_money").val(total_money);
		$("#total_money").html(total_money);
		
	});
	
	
	//10000원 버튼
	$("#button_money_10000").on("click", function() {
		var button_money1 = 10000;
		total_money += button_money1;
		
		$("#text_money").val(total_money);
		$("#total_money").html(total_money);
		
	});
	
	
	//20000원 버튼
	$("#button_money_20000").on("click", function() {
		var button_money2 = 20000;
		total_money += button_money2;
		
		$("#text_money").val(total_money);
		$("#total_money").html(total_money);
	});
	
	
	//30000원 버튼
	$("#button_money_30000").on("click", function() {
		var button_money3 = 30000;
		total_money += button_money3;
		
		$("#text_money").val(total_money);
		$("#total_money").html(total_money);
	});
	
	
	
	//이미 결제가 이루어진 건입니다??
	// 결제 기능
	IMP.init("imp73101414");
	
	$("#donate").on("click", function() {

		IMP.request_pay({
			pg: "html5_inicis",
			pay_method: "card",
			merchant_uid: "order_" + <%=idx%>,
			name: "트리어스",
			amount: total_money,
			buyer_email: "${member.mem_email}",
			buyer_name: "${member.mem_name}",
			buyer_tel: "${member.mem_phone}",
			buyer_addr: "${member.mem_address}"
		}, function(rsp) {
			if(rsp.success) {
				alert("결제가 정상적으로 완료되었습니다.");
				location.href="GiveMoneyPro.su?total_money="+total_money+"&idx="+<%=idx%>;

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
<h1>DONATE</h1>


	<form action="GiveMoneyPro.su">
		
		<!-- 금액 직접 입력 -->
		<input type="text" id="text_money" name="sup_money" placeholder="후원금">
		<!-- 금액 버튼 -->
	    <button id="button_money_10000" class="w-btn w-btn-yellow" type="button"> 10000원  </button>
	    <button id="button_money_20000" class="w-btn w-btn-yellow" type="button"> 20000원  </button>
	    <button id="button_money_30000" class="w-btn w-btn-yellow" type="button"> 30000원  </button><br>
	    
	    
		<span>총 후원금&nbsp;&nbsp;</span>
		<span id="total_money"></span>
		<span>원</span>
		
		<!-- 후원 버튼 -->
		<button id="donate" class="w-btn w-btn-gra2"  type="button"> 후원 </button><br>
		
		<div id="CheckMoneyResult"></div>
		
	</form>
	
	
</body>
</html>