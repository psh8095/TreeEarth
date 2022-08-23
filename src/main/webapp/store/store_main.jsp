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
<link href="../css/index.css" rel="stylesheet">
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
	
	<h1>TreeEarth 프로젝트_Store Main</h1>
	
	<%if(storeList.isEmpty()) { %>
	<hr>
	<h1>상품이 없습니다.</h1>
	<%}  %>

		<section id="itemWriteForm">
			<div id="tr1">
			<table>
			<%
			for(Object o : storeList) {
				StoreDTO dto = (StoreDTO)o;
			%>
				<tr>
					<td>
						<a href="StoreItemDetail.st?sto_idx=<%=dto.getSto_idx() %>">
						<img src="img/store/<%=dto.getSto_thum_file() %>" width="200" height="200">
						</a>
					</td>
				</tr>
				<tr>
					<td>상품명 : <%=dto.getSto_subject() %></td>
				</tr>
				<tr>
					<td><%=dto.getSto_content() %></td>
				</tr>
				<tr>
					<td><%=dto.getSto_price() %></td>
				</tr>
				<tr>
					<td><%=dto.getSto_tag() %></td>
				</tr>
			<%	
			}
			%>
			</table>	
			</div>
		</section>

		<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='StoreItemList.st?pageNum=${pageInfo.pageNum - 1}'">
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
					<a href="StoreItemList.st?pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='StoreItemList.st?pageNum=${pageInfo.pageNum + 1}'">
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










