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
	#listForm {
		width: 1024px;
		max-height: 610px;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		margin: auto;
		width: 1024px;
	}
	
	#tr_top {
		background: orange;
		text-align: center;
	}
	
	table td {
		text-align: center;
	}
	
	#subject {
		text-align: left;
		padding-left: 20px;
	}
	
	#pageList {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#emptyArea {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<!-- 게시판 리스트 -->
	<section id="listForm">
	<h2>주문관리 - 배송 전/배송 중/배송 완료 주문목록</h2>
	<form action="#" method="get" name="order_status">
		<input type="radio" name="status" value="배송 대기" checked="checked">배송 대기
		<input type="radio" name="status" value="배송 중">배송 중
		<input type="radio" name="status" value="배송 완료">배송 완료
		<input type="submit" value="검색">
	</form>
	<table>
		<tr id="tr_top">
			<td width="300px">주문번호</td>
			<td width="300px">아이디</td>
			<td width="300px">이름</td>
			<td width="800px">주소</td>
			<td width="800px">상세 주소</td>
			<td width="500px">휴대폰 번호</td>
			<td width="200px">이메일</td>
			<td width="300px">결제 금액</td>
			<td width="300px">주문 일자</td>
			<td width="300px">주문 상태</td>
		</tr>
		<!-- 게시물 목록 출력(단, 게시물이 하나라도 존재할 경우에만 출력) => JSTL 과 EL 활용 -->
		<!-- JSTL 의 c:choose 태그를 사용하여 게시물 존재 여부 판별 -->
		<!-- 조건 : boardList 객체가 비어있지 않고 pageInfo 객체의 itemListCount 가 0보다 클 경우 -->
		<c:choose>
			<c:when test="${not empty orderList and pageInfo.itemListCount gt 0 }">
				<!-- c:foreach 태그를 사용하여 boardList 객체의 BoardDTO 객체를 꺼내서 출력 -->
				<c:forEach var="orderList" items="${orderList }">
					<tr>
						<td>${orderList.order_id }</td>
						<td>${orderList.mem_id }</td>
						<td>${orderList.mem_name }</td>
						<td>${orderList.mem_address }</td>
						<td>${orderList.mem_address_detail }</td>
						<td>${orderList.mem_phone }</td>
						<td>${orderList.mem_email }</td>
						<td>${orderList.amount } 원</td>
						<td>${orderList.order_date }</td>
						<td id="order_status">
							<a href="StoreOrderDetail.st?order_id=${order.order_status }&pageNum=${pageInfo.pageNum}">
								${order.order_status }
							</a>
						</td>
						
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
				<tr><td colspan="5">주문 목록이 존재하지 않습니다.</td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</section>
	<section id="pageList">
		<!-- 
		현재 페이지 번호(pageNum)가 1보다 클 경우에만 [이전] 링크 동작
		=> 클릭 시 BoardList.bo 서블릿 주소 요청하면서 
		   현재 페이지 번호(pageNum) - 1 값을 page 파라미터로 전달
		-->
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='StoreOrderDetail.st?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
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
				<input type="button" value="다음" onclick="location.href='StoreOrderDetail.st?pageNum=${pageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>