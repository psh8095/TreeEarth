<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/community.css" rel="stylesheet">
<style type="text/css">
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
	
#best{
align: center;
 width:fit-content;
 margin:auto;
}

#insta{
margin-left:400px;
 width:fit-content;
}

#buttonArea{
        display:block;
}

#pageList{
margin:auto;
display:block;
margin-left: -100px;
}


	/* 한림예고 */
	@font-face {
	    font-family: 'HallymGothic-Regular';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2204@1.0/HallymGothic-Regular.woff2') format('woff2');
	    font-weight: 400;
	    font-style: normal;
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
	
	<div style="text-align: center;">
   		<h1 style="display: block; margin: 70px auto; font-size: 40px; font-family: 'HallymGothic-Regular'; font-weight: 700;">[ 반려나무 일기 ]</h1>
	</div>
			<hr style="color: gray; opacity: 70%; margin: 50px;">
	
	
<!-- 	목록 전체 -->
	<section id ="best">
		<img alt="diarybanner" src="img/community/diarybanner.png">
	</section>
	
	<!-- 인스타 위젯 적용 -->
	<section id="insta">
		<script src="https://snapwidget.com/js/snapwidget.js"></script>
		<iframe src="https://snapwidget.com/embed/1007907" class="snapwidget-widget" allowtransparency="true" frameborder="0" scrolling="no" style="border:none; overflow:hidden; width:400%; "></iframe>
	</section>

<!-- 성장일지 회원 작성  -->
	<main >
   
		<hr style="color: gray; opacity: 70%; margin: 50px;">
		
		<div class="main">
<!-- 			목록 기능구현 -->
		<c:choose>
			<c:when test="${not empty diaryList and pageInfo.itemListCount gt 0}">
				<c:forEach var="diary" items="${diaryList }">
<!-- 				앨범형 작업 -->
<!-- 					<table> -->
<!-- 						<tr> -->
<!-- 							<td colspan="2"> -->
							<div class="list">
								<a href="DiaryBoardDetail.cm?diary_idx=${diary.diary_idx }&pageNum=${pageInfo.pageNum}">
									<c:choose>
										<c:when test="${not empty diary.diary_img}">
											<img class="img"  alt="" src="img/community/${diary.diary_img }" width="500px">
										</c:when>
										<c:otherwise>
											<img class="img"  alt="" src="img/community/treediary.png" width="500px">
										</c:otherwise>
									</c:choose>
								</a>
								
<!-- 								글제목 -->
								<div>
									<a href="DiaryBoardDetail.cm?diary_idx=${diary.diary_idx }&pageNum=${pageInfo.pageNum}">
										<b>${diary.diary_subject }</b>
									</a>
								</div>
								
							 <span>작성자 ${diary.diary_id }</span> 
						 	 <span>작성일 ${diary.diary_date }</span> 
							 <span>조회수 ${diary.diary_readcount }</span> 
							</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>게시물이 존재하지 않습니다.</h1>
			</c:otherwise>
		</c:choose>
	</div>
	</main>
	
	<br>
	
<!-- 	버튼 목록 -->
	<div style="clear: both;">
	
		<div id="buttonArea">
			<c:if test="${not empty sessionScope.sId}">
			   <button id ="pencil" onclick="location.href='DiaryWriteForm.cm'" ><img src="img/community/free-icon-writing-6782423.png" width="47px" height="50px"></button>
			</c:if>
		</div>
			
<<<<<<< HEAD
	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input id="button" type="button" value="이전" onclick="location.href='DiaryList.cm?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input id="button" type="button" value="이전">
			</c:otherwise>
		</c:choose>
			
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
=======
		<section id="pageList">
>>>>>>> branch 'master' of https://github.com/psh8095/TreeEarth.git
			<c:choose>
				<c:when test="${pageInfo.pageNum > 1}">
					<input type="button" value="이전" onclick="location.href='DiaryList.cm?pageNum=${pageInfo.pageNum - 1}'">
				</c:when>
				<c:otherwise>
					<input type="button" value="이전">
				</c:otherwise>
			</c:choose>
<<<<<<< HEAD
		</c:forEach>

		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input id="button" type="button" value="다음" onclick="location.href='DiaryList.cm?pageNum=${pageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input id="button" type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
=======
				
			<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
				<c:choose>
					<c:when test="${pageInfo.pageNum eq i}">
						${i }
					</c:when>
					<c:otherwise>
						<a href="DiaryList.cm?pageNum=${i }">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	
			<c:choose>
				<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
					<input type="button" value="다음" onclick="location.href='DiaryList.cm?pageNum=${pageInfo.pageNum + 1}'">
				</c:when>
				<c:otherwise>
					<input type="button" value="다음">
				</c:otherwise>
			</c:choose>
		</section>
>>>>>>> branch 'master' of https://github.com/psh8095/TreeEarth.git
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>