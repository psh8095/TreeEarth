<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>treeEarth</title>
<link href="../css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	<section id="">
	<h2>반려나무 성장일지</h2>
		<c:choose>
			<c:when test="${not empty diaryList and pageInfo.itemListCount gt 0}">
				<c:forEach var="diary" items="${diaryList }">
				<div style="float: left; width: 30%;">
					<table>
						<tr>
							<td colspan="2">
								<a href="DiaryBoardDetail.cm?diary_idx=${diary.diary_idx }&pageNum=${pageInfo.pageNum}">
									<c:choose>
										<c:when test="${not empty diary.diary_img}">
											<img alt="" src="upload/${diary.diary_img }" width="40%">
										</c:when>
										<c:otherwise>
											<img alt="썸네일없음" src="img/community/treediary.png" width="550px">
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
	
	<section id="buttonArea">
		<input type="button" value="글쓰기" onclick="location.href='DiaryWriteForm.cm'" />
	</section>
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
					<a href="DiaryList.cm?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='DiaryList.cm?pageNum=${pageNum + 1}'">
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