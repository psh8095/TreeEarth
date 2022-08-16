<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 자유게시판 글쓰기</title>
</head>
<body>
	<%
		String free_userID = null;
		if (session.getAttribute("free_userID") != null) {
			free_userID = (String) session.getAttribute("free_userID"); // 로그인을 한사람이라면 free_userID 에 정보가 담기게 됨
		}
	%>
	<nav>
       <div>
           <ul>
	            <li><a href="index.jsp">트리어스 메인</a></li>
	            <li class="active"><a href="FreeBoardList.cm">자유게시판</a></li>
           </ul>
           <%
           		if (free_userID == null) {
           %>
			<ul>
               	<li><a href="member_login.jsp">로그인</a></li>
               	<li><a href="member_login.jsp">회원가입</a></li> <!-- 주소 변경예정!!! -->
			</ul>
           <%
           		} else {
           %>
           <ul>
				<li><a href="#">회원정보수정</a></li> <!-- 주소 변경예정!!! -->
                <li><a href="logoutAction.jsp">로그아웃</a></li> <!-- 주소 변경예정!!! -->
			</ul>			
           <%
        		}
           %>
		</div>
	</nav>
			<form action="FreeBoardWritePro.cm" name="freeboardForm" method="post" enctype="multipart/form-data">
				<table style="text-align: center; border: 1px"> 
					<thead>
						<tr>
						 	<th colspan="2" style="text-align: center;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" placeholder="글 제목" name="free_subject" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea placeholder="글 내용" name="free_content" maxlength="2048" style="height:300px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="글쓰기">
			</form>
</body>
</html>