<%@page import="vo.support.SupportDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	// 리스트 객체 어트리뷰트로 받기
	ArrayList<SupportDTO> List = (ArrayList<SupportDTO>)request.getAttribute("SupportList");
	
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 해더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 해더 -->
	
		<h1>후원 리스트</h1>
		
<a href="SupportWriteFormAdmin.su">글쓰기</a>
			
			<%for(Object o : List){
				
				SupportDTO dto = (SupportDTO)o; 
			%>
				
				<h3><a  href ="SupportDetail.su?sup_idx=<%=dto.getSup_idx() %>">제목 : <%=dto.getSup_subject()%></a></h3>
				<a  href ="SupportDetail.su?sup_idx=<%=dto.getSup_idx() %>"><img alt="썸네일" src="./img/support/<%=dto.getSup_thumbnail_file()%>" width="30%"></a>
			
			<%} %>



	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>