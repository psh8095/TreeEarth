<%@page import="vo.community.DiaryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%
	// dto 객체 어트리뷰트로 받기
	DiaryDTO diary = (DiaryDTO)request.getAttribute("diary");
	String sId = (String)session.getAttribute("sId");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려나무 성장일지</title>
<link href="../css/index.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<link href="css/community.css" rel="stylesheet">
</head>
<style type="text/css">	

@font-face {
 font-family: 'MICEGothic Bold';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2206-01@1.0/MICEGothic Bold.woff2') format('woff2');
	    font-weight: 700;
	    font-style: normal;
}
#writeForm {
	width: 800px;
	height: 610px;
	margin: auto;
	margin-left: auto;
	margin-right: auto;
}
table {
	margin: auto;
	width: 700px;
}
#commandCell {
	text-align: center;
}

#articleContentArea {
		margin-top: 20px;
		width:auto;
		height: 420px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
		#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
		#commandListUser {
		margin: auto;
		width: 500px;
		text-align: center;
	}
	
	.w-btn-outline {
    position: relative;
    padding: 12px 12px;
    border-radius: 15px;
    font-family:'MICEGothic Bold';
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
}

	
.w-btn-indigo-outline {
    border: 3px solid aliceblue;
    color: #1e6b7b;
}
</style>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	<section id="writeForm">
		<h2> 나만의 반려나무를 자랑해봐요</h2>
		
		
		
		<section id="">
			<table>
			<tr><th width="70">제 목</th><td colspan="3" >${diary.diary_subject }</td></tr>
			<tr>
				<th width="70">작성자</th><td>${diary.diary_id }</td>
				<th width="70">작성일</th><td>${diary.diary_date }</td>
			</tr>
			<tr>
				<th width="70">첨부파일</th>
				<td>
					<a href="upload/${diary.diary_real_img }" download="${diary.diary_img }">
						${diary.diary_img }
					</a>
				</td>
				<th width="70">조회수</th>
				<td>${diary.diary_readcount }</td>
			</tr>
			<tr>
				<th width="70">내용</th>
				<td>
					${diary.diary_content }<br><br>
<%-- 					<img alt="${diary.diary_img }" src="img/community/${diary.diary_real_img }"> --%>
			<img alt="" src="img/community/<%=diary.getDiary_thumb_img() %>" width="70%">
			<img alt="" src="img/community//<%=diary.getDiary_img() %>" width="70%">
				</td>
			</tr>
			</table>
		</section>
			<section id="articleContentArea">
			</section>
	</section>
	
<!-- 	로그인을 해야만 수정, 삭제 가능 -->
	<%if(sId != null){%>
	<section id="commandListUser">
			<button class="w-btn-outline w-btn-indigo-outline" type="button" onclick="location.href='DiaryModifyForm.cm?diary_idx=${diary.diary_idx}&pageNum=${param.pageNum}'">수정</button>
			<button class="w-btn-outline w-btn-indigo-outline"  type="button" onclick="location.href='DiaryDeleteForm.cm?diary_idx=${diary.diary_idx}&pageNum=${param.pageNum}'">삭제</button>
			<button class="w-btn-outline w-btn-indigo-outline" type="button" onclick="location.href='DiaryList.cm?pageNum=${param.pageNum}'">목록</button>
			</section>
<%-- 			<input type="button" value="목록" onclick="location.href='SupportListAction.su?sup_idx=<%=dto.getSup_idx() %> &pageNum=${param.pageNum} '"> --%>
		<%}else{%>
		<section id="commandList">
		<button class="w-btn-outline w-btn-indigo-outline"  type="button" onclick="location.href='DiaryList.cm?pageNum=${param.pageNum}'">목록</button>
		</section>
			
	<%}%>	

	<!-- 푸터 -->
<%-- 	<jsp:include page="../hf/footer.jsp"></jsp:include> --%>
	<!-- 푸터 -->
</body>
</html>