<%@page import="vo.support.SupportDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	SupportDTO dto = (SupportDTO)request.getAttribute("dto");
	int idx = Integer.parseInt(request.getParameter("idx"));
	String sId = (String)session.getAttribute("sId");
	String sup_subject = request.getParameter("sup_subject");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<link href="css/button.css" rel="stylesheet">
<link href="css/support.css" rel="stylesheet">
<style type="text/css">


/* .w-btn-outline { */
/*     position: relative; */
/*     padding: 15px 30px; */
/*     border-radius: 15px; */
/*    font-family: 'HallymGothic-Regular'; */
/*     font-size: 25px; */
/*     box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2); */
/*     text-decoration: none; */
/*     font-weight: 600; */
/*     transition: 0.25s; */
/* } */

/* #don{ */
/* text-align: center; */
/* margin: auto; */
/* padding: 55px; */
/* } */
/* .bnt_group button{ */
/* 	width:100px; */
/*    height: 70px; */
/*     background-color:   #c5e096;; */
/*     color: black; */
/*      font-family: 'HallymGothic-Regular'; */
/*    font-size: 18px; */
/*    font-weight:bold; */
/*    border:1px solid lightgray; */
/*    transition:0.3s; */
/*  top:-32px; */
/* /*  float:left; */ */
/*  margin:0 -3px -10px; */
/* }   */

/* #don2{ */
/* text-align: center; */
/* margin: auto; */
/* padding-bottom: 50px; */
/* } */
/* #sub{ */
/* text-align: center; */
/* margin: auto; */
/* } */
/* #text_money{ */
/* /* margin-left: 370px; */ */
/* text-align: center; */
/* margin-top: 30px; */
/* font-size: 20px; */
/* } */

/* .con{ */
/* display: block; */
/* 	font-size: 0; /* 가장 중요한 font-size: 0; 속성 */ */
/* 	margin: 0 -5px; */
/* } */

</style>

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
	
	
	
	// 결제 기능
	IMP.init("imp73101414");
	
	$("#donate").on("click", function() {
		
		var date = new Date();
		var now = date.getHours() + "" + date.getMinutes() + "" + date.getSeconds();

		
		IMP.request_pay({
			pg: "html5_inicis",
			pay_method: "card",
			merchant_uid: "order_" + <%=idx%> + now,
			name: "트리어스",
			amount: total_money,
			buyer_email: "${member.mem_email}",
			buyer_name: "${member.mem_name}",
			buyer_tel: "${member.mem_phone}",
			buyer_addr: "${member.mem_address}"
		}, function(rsp) {
			if(rsp.success) {
				alert("결제가 정상적으로 완료되었습니다.");

				$.ajax({
					type: "post",
					url: "GiveMoneyPro.su",
					data: {
						total_money: total_money,
						idx: ${param.idx},
						mem_id: "${sessionScope.sId }",
						sup_idx: ${param.idx},
						suphi_money: total_money
					},
					dataType: "text",
					success: function(response) {
						opener.location.href='SupportList.su'
						window.close();
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



	<div class="gm_main_div">
		<form action="GiveMoneyPro.su">
			
				<div class="donator"> </div>
				<div class="gm_main_text1">["<%=sId %>" 후원자님, 감사합니다!  ]</div>
				
			<hr style="margin-bottom: 30px; opacity: 0.5; ">
				
				<div class="gm_main_text2">"진정한 후원은 후원이 끝나게 하는 것입니다."</div>
				<div class="gm_main_text3">"사람을 구하는건 나무밖에 없습니다."</div>
				
			<hr style="margin-bottom: 30px; opacity: 0.5; ">
			
			
				<div class="gm_money">
				
					<div>
						<input class="gm_text_money" type="text" id="text_money" name="sup_money" placeholder="금액 직접 입력">
						<span style="font-size: 30px; font-weight: 700">원</span>
					</div>
					
					
					<div class="gm_button_money">
						
						  	<button id="button_money_10000" type="button"> 1만원  </button>
						    <button id="button_money_20000" type="button"> 2만원  </button>
						    <button id="button_money_30000" type="button"> 3만원  </button>
						
					</div>
					
				</div>

				
				
				<div class="gm_order_money">
					<div style="background-color: #dcdcdc; border-radius: 3px; padding: 15px;">
					
							<div style="padding: 10px;">연말정산 또는 종합소득세 신고시 연간 소득금액 한도 내에서 기부금액의 15%를 세액공제 받으실 수 있습니다.</div>
						
							<hr style="margin: 10px;">
						
							<div  style="padding: 10px;">
								<input type="checkbox"> 유료 이용약관 동의<br>
								<input type="checkbox"> 트리어스 마케팅 알람 동의
							</div>
						
							<hr style="margin: 10px;">
						
							<div style="display: none;">
								<div>총 후원금&nbsp;&nbsp;</div>
								<div id="total_money"></div>원
								<div id="CheckMoneyResult"></div>
							</div>
							
						
						<button id="donate" class="w-btn-outline w-btn-green-outline" type="button"> 후원 </button><br>
					
					</div>
				</div>
				
			
		</form>
	</div>
	
	
	

	
<!-- 	<form action="GiveMoneyPro.su"> -->
<%-- 		<input type="hidden" name="mem_id" value="${sessionScope.sId }"> --%>
		
		
		
<!-- 	<div class="con"> -->
<!-- 	  <div id="mon"> -->
<!-- 		<div id="tex"> -->
<!-- 		<input type="text" id="text_money" name="sup_money" placeholder="금액 직접 입력"> -->
<!-- 		</div> -->
<!-- 		<!-- 금액 버튼 --> 
<!-- 		<div class="bnt_group"> -->
<!-- 		<section id="don"> -->
<!-- 	    <button id="button_money_10000" type="button"> 1만원  </button> -->
<!-- 	    <button id="button_money_20000" type="button"> 2만원  </button> -->
<!-- 	    <button id="button_money_30000" type="button"> 3만원  </button><br> -->
<!-- 		</section> -->
<!-- 	  </div> -->
<!-- 		</div> -->
<!-- 	</div>	 -->
	    
<!-- 	    <div id="don2"> -->
<!-- 		<span>총 후원금&nbsp;&nbsp;</span> -->
<!-- 		<span id="total_money"></span> -->
<!-- 		<span>원</span> -->
		
<!-- 		<!-- 후원 버튼 -->
<!-- 		<button id="donate" class="w-btn-outline w-btn-green-outline" type="button"> 후원 </button><br> -->
<!-- 	    </div> -->
		
<!-- 		<div id="CheckMoneyResult"></div> -->
		
<!-- 	</form> -->
	
	
</body>
</html>