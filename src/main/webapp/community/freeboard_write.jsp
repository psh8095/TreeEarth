<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 자유게시판 글쓰기</title>
<style type="text/css">
	#writeForm {
		width: 500px;
		height: 450px;
		border: 1px solid red;
		margin: auto;
	}
	
	h1 {
		text-align: center;
	}
	
	table {
		margin: auto;
		width: 450px;
	}
	
	.td_left {
		width: 150px;
		background: orange;
		text-align: center;
	}
	
	.td_right {
		width: 300px;
		background: skyblue;
	}
	
	#commandCell {
		text-align: center;
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
	
	<%
		String free_name = null;
		if (session.getAttribute("free_name") != null) {
			free_name = (String) session.getAttribute("free_name"); // 로그인을 한사람이라면 free_name 에 정보가 담기게 됨
		}
	%>
	<nav>
       <div>
           <ul>
	            <li><a href="index.jsp">트리어스 메인</a></li>
	            <li class="active"><a href="FreeBoardList.cm">자유게시판</a></li>
           </ul>
           <ul>
                <li><a href="MemberLogout.me">로그아웃</a></li>
			</ul>			
		</div>
	</nav>
	<!-- 게시판 등록 -->
	<section id="writeForm">
		<h1>게시판 글 등록</h1>
		<!-- 
		form 데이터 중 파일 정보가 포함될 경우
		<form> 태그 속성에 enctype="multipart/form-data" 명시 필수!
		(생략 시 enctype="application/x-www-form-urlencoded" 속성이 기본값으로 설정됨)
		-->
		<form action="FreeBoardWritePro.cm" name="freeboardForm" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="td_left"><label for="free_name">작성자</label></td>
					<td class="td_right"><input type="text" name="free_name" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_pass">비밀번호</label></td>
					<td class="td_right">
						<input type="password" name="free_pass" required="required" />
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_subject">제목</label></td>
					<td class="td_right"><input type="text" name="free_subject" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_content">내용</label></td>
					<td class="td_right">
						<textarea id="free_content" name="free_content" cols="40" rows="15" required="required"></textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="free_img">사진 첨부</label></td>
					<!-- 파일 첨부 형식은 input 태그의 type="file" 속성 사용 -->
					<td class="td_right"><input type="file" name="free_img" required="required" /></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">&nbsp;&nbsp;
				<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>

