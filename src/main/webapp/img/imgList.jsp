<%@page import="vo.ImgDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 
	 ArrayList<ImgDTO> boardList = (ArrayList<ImgDTO>)request.getAttribute("boardList");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

ul{
    list-style:none;
    }




</style>
<link rel="stylesheet" href="imgList.css">
</head>
<body>


	<h1>엘범형</h1>
	
	
			<div class="inline">
				<%-- 실제 게시물 목록이 표시될 위치 --%>
				<%
				for(Object o : boardList) {					
					ImgDTO imgList = (ImgDTO)o; 
					%>
					<div>
					
					<ul>

	                	<li><a href=""><img alt="" src="./upload/<%=imgList.getBoard_file() %>" width="33%"></a></li>
<%-- 	                	<li><a href=""><%=imgList.getBoard_Name() %></a></li> --%>
<!-- 	                	<li><a href="">이름</a></li> -->
<%-- 	                	<li><a href=""><%=imgList.getBoard_subject() %></a></li> --%>
<%-- 	                	<li><a href=""><%=imgList.getBoard_content()%></a></li> --%>
	 

          			</ul>
					
		
					</div>
					<%
				}
				%>
			</div>
	
</body>
</html>