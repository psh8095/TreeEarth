<%@page import="vo.store.StoreDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ArrayList<StoreDTO> storeList = (ArrayList<StoreDTO>)request.getAttribute("storeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TreeEarth</title>
<link href="css/store.css" rel="stylesheet">
</head>

<body>


	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	
	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->
	

	 <hr style="color: gray; opacity: 70%; margin: 70px;">

	<!-- 	상품이 없을 때 -->
	<%if(storeList.isEmpty()) { %>
	<hr>
	<h1>상품이 없습니다.</h1>
	<%}  %>



		<!-- 상품 목록 -->
		<div class="main">
			
				<%
				for(Object o : storeList) {
					StoreDTO dto = (StoreDTO)o;
				%>
					<div class="list">
							
							<!-- 상품이미지	 -->
							<a href="StoreItemDetail.st?sto_idx=<%=dto.getSto_idx() %>">
							<img class="img" src="img/store/<%=dto.getSto_thum_file() %>" alt="" width="500" height="500">
<%-- 							<img class="img" src="img/store/<%=dto.getSto_thum_file() %>" alt="" width="500" height="500"> --%>
							</a>
							
							<!-- 상품명	 -->
							<div class="list_subject">
								<%=dto.getSto_subject() %>
							</div>

							<!-- 가격	 -->
							<div class="list_subject">
								<%=dto.getSto_price() %>원
							</div>
							
							
							<!-- 태그	 -->
							<div class="list_subject">
								<span class="sto_tag main_tag"><%=dto.getSto_tag() %></span>
							</div>
							
					</div>
				<%	
				}
				%>
				
		</div>



	<!-- 페이징 처리 -->
	<div class="page">
		<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='StoreItemList.st?sto_category=${sto_category }&pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<c:choose>
				<c:when test="${pageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="StoreItemList.st?sto_category=${sto_category }&pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='StoreItemList.st?sto_category=${sto_category }&pageNum=${pageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
	</div>



	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
	
	
	
</body>
</html>










