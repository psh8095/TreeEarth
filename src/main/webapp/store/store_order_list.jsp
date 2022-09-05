<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문관리 - 배송 전/배송 중/배송 완료 주문목록</title>
<script>

	function orderStatus() {
		if(document.fr.subject.options[0].selected) { // 배송 상태 선택하지 않았을 경우
			alert("배송 상태 선택 필수!");
			document.fr.selectedSubject.value = "";
		} else {
			document.fr.selectedSubject.value = document.fr.subject.value;
		}
	}

</script>
<style type="text/css">
	@font-face {
	    font-family: 'HallymGothic-Regular';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2204@1.0/HallymGothic-Regular.woff2') format('woff2');
	    font-weight: 400;
	    font-style: normal;
	}
	
	*{margin: 0; padding: 0; font-family: 'HallymGothic-Regular';}
	
	.table {
		margin: 0 0 40px 0;
		width: 100%;
		box-shadow: 0 1px 3px rgba(0,0,0,0.2);
		display: table;
	}
	
	.row {
		display: table-row;
	}
	
	.cell {
		display: table-cell;
	}
	
	.header {
		background-color: #c5e096;
		color: #ffffff;
		font-weight: 600;
	}
	
	h1 {
		text-align: center;
		color: #c5e096;
	}
	
	#button {
		color: white; 
		padding: 2px 2px;
		background-color: #c5e096;
		display: inline-block;
		border: 1px solid rgba(0,0,0,0.21);
		border-bottom-color: rgba(0,0,0,0.34);
		text-shadow:0 1px 0 rgba(0,0,0,0.15);
		box-shadow: 0 1px 0 rgba(255,255,255,0.34) inset, 
		            0 2px 0 -1px rgba(0,0,0,0.13), 
		            0 3px 0 -1px rgba(0,0,0,0.08), 
		            0 3px 13px -1px rgba(0,0,0,0.21);
	}
	
	#pageList {
		 width: 100px;
 		 margin: 0 auto;
	}
	
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	
	
	<h1>주문관리 - 고객 주문목록</h1>
	<hr style="color: gray; opacity: 50%; margin-bottom: 15px;">

<!-- 	<form action="#" method="get" name="order_status"> -->
<!-- 		<input type="radio" name="status" value="배송 대기" checked="checked">배송 대기 -->
<!-- 		<input type="radio" name="status" value="배송 중">배송 중 -->
<!-- 		<input type="radio" name="status" value="배송 완료">배송 완료 -->
<!-- 		<input type="submit" value="검색"> -->
<!-- 	</form> -->

	<div class="table">
		<div class="row header">
			<div class="cell">주문번호</div>
			<div class="cell">아이디</div>
			<div class="cell">이름</div>
			<div class="cell">주소</div>
			<div class="cell">상세 주소</div>
			<div class="cell">휴대폰 번호</div>
			<div class="cell">이메일</div>
			<div class="cell">결제 금액</div>
			<div class="cell">주문 일자</div>
<!-- 			<div class="cell">주문 상태</div> -->
		</div>
		
		<!-- 게시물 목록 출력(단, 게시물이 하나라도 존재할 경우에만 출력) => JSTL 과 EL 활용 -->
		<!-- JSTL 의 c:choose 태그를 사용하여 게시물 존재 여부 판별 -->
		<!-- 조건 : boardList 객체가 비어있지 않고 pageInfo 객체의 itemListCount 가 0보다 클 경우 -->
		<c:choose>
			<c:when test="${not empty orderList and pageInfo.itemListCount gt 0 }">
				<!-- c:foreach 태그를 사용하여 boardList 객체의 BoardDTO 객체를 꺼내서 출력 -->
				<c:forEach var="orderList" items="${orderList }">
					<div class="row">
						<div class="cell">${orderList.order_id }</div>
						<div class="cell">${orderList.mem_id }</div>
						<div class="cell">${orderList.mem_name }</div>
						<div class="cell">${orderList.mem_address }</div>
						<div class="cell">${orderList.mem_address_detail }</div>
						<div class="cell">${orderList.mem_phone }</div>
						<div class="cell">${orderList.mem_email }</div>
						<div class="cell">${orderList.amount } 원</div>
						<div class="cell">${orderList.order_date }</div>
<!-- 						<div class="cell"> -->
<%-- 							<a href="StoreOrderDetail.st?order_id=${order.order_status }&pageNum=${pageInfo.pageNum}"> --%>
<%-- 								${order.order_status } --%>
<!-- 							</a> -->
<!-- 						</div> -->
					</div>
						
<!-- 						<select name="order_status" onchange="orderStatus()"> 데이터 전송 및 접근을 위한 name 속성 설정 -->
<!-- 							option 태그의 disabled 속성 지정 시 해당 항목 선택 불가 -->
<!-- 							<option value="">주문 상태 변경</option> -->
<!-- 							<option value="A">배송 대기</option> -->
<!-- 							<option value="B">배송 중</option> -->
<!-- 							<option value="C">배송 완료</option> -->
							
<!-- 							<input type="submit" value="변경"> -->
							
<!-- 						</select> -->
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="row">주문 목록이 존재하지 않습니다.</div>
			</c:otherwise>
		</c:choose>
	</div>
	<section id="pageList">
		<!-- 
		현재 페이지 번호(pageNum)가 1보다 클 경우에만 [이전] 링크 동작
		=> 클릭 시 BoardList.bo 서블릿 주소 요청하면서 
		   현재 페이지 번호(pageNum) - 1 값을 page 파라미터로 전달
		-->
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input id="button" type="button" value="이전" onclick="location.href='StoreOrderList.st?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input id="button" type="button" value="이전">
			</c:otherwise>
		</c:choose>
			
		<!-- 페이지 번호 목록은 시작 페이지(startPage)부터 끝 페이지(endPage) 까지 표시 -->
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<!-- 단, 현재 페이지 번호는 링크 없이 표시 -->
			<c:choose>
				<c:when test="${pageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="StoreOrderDetail.st?pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 현재 페이지 번호(pageNum)가 총 페이지 수보다 작을 때만 [다음] 링크 동작 -->
		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input id="button" type="button" value="다음" onclick="location.href='StoreOrderList.st?pageNum=${pageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input id="button" type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>