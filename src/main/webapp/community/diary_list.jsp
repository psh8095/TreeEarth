<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>treeEarth</title>
<link href="../css/index.css" rel="stylesheet">
<style type="text/css">
#best{
align: center;
 width:fit-content;
 margin:auto;
}
#insta{
/* align: center; */
margin-left:400px;
 width:fit-content;
}
#buttonArea{
   margin-left:auto;
        display:block;
          width:100px;
}
#pageList{
margin:auto;
display:block;
}

#pencil{
	width:120px;
	height: 40px;
	color:#fff;
	background: #0080ff ;
	font-size: 16px;
	border:none;
	border-radius: 12px;
	transition:0.3s;
	transform: translate(-50%,-50%);
}
#pencil:focus {
	outline:0;
}
#pencil:hover{
	background: #3fffa7 ;
	cursor: pointer;
}
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
<!-- 	목록 전체 -->
	<section id="">
	<section id ="best">
		<img alt="diarybanner" src="img/community/diarybanner.png"  >
	</section>
<section id="insta">
<script src="https://snapwidget.com/js/snapwidget.js"></script>
<iframe src="https://snapwidget.com/embed/1007907" class="snapwidget-widget" allowtransparency="true" frameborder="0" scrolling="no" style="border:none; overflow:hidden; width:400%; "></iframe>
</section>
<h2>반려나무 성장일지</h2>
<!-- 			목록 기능구현 -->
		<c:choose>
			<c:when test="${not empty diaryList and pageInfo.itemListCount gt 0}">
				<c:forEach var="diary" items="${diaryList }">
<!-- 				앨범형 작업 -->
				<div style="float: left; width: 30%; padding: 20px;">
					<table>
						<tr>
							<td colspan="2">
								<a href="DiaryBoardDetail.cm?diary_idx=${diary.diary_idx }&pageNum=${pageInfo.pageNum}">
									<c:choose>
										<c:when test="${not empty diary.diary_img}">
											<img alt="" src="img/community/${diary.diary_img }" width="500px">
										</c:when>
										<c:otherwise>
											<img alt="썸네일없음" src="img/community/treediary.png" width="500px">
										</c:otherwise>
									</c:choose>
								</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="DiaryBoardDetail.cm?diary_idx=${diary.diary_idx }&pageNum=${pageInfo.pageNum}">
									<b>${diary.diary_subject }</b>
								</a>
							</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>${diary.diary_id }</td>
						</tr>
						<tr>
							<td>작성일</td>
							<td>${diary.diary_date }</td>
						</tr>
						<tr>
							<td>조회수</td>
							<td>${diary.diary_readcount }</td>
						</tr>
					</table>
						</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>게시물이 존재하지 않습니다.</h1>
			</c:otherwise>
		</c:choose>
	</section>
	
	<br>
	
<!-- 	버튼 목록 -->
	<div style="clear: both;">
	
			<div id="buttonArea">
	<c:if test="${not empty sessionScope.sId}">
		   <button id="pencil" onclick="location.href='DiaryWriteForm.cm'" >✏ 글쓰기</button>
		</c:if>
			</div>
			
	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='DiaryList.cm?pageNum=${pageNum - 1}'">
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
	</div>
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>