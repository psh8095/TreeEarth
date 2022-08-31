<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="css/community.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->

	<!-- 공지사항 메인 -->
   <main>
   
		<hr style="color: gray; opacity: 70%; margin: 50px;">
			   
	   
		<!-- 공지사항 목록 -->
	    <div class="main">
	
			<c:choose>
				<c:when test="${not empty noticeList and pageInfo.itemListCount gt 0}">
					<c:forEach var="notice" items="${noticeList }">
						
						
						<div class="list">
							<a href="NoticeDetail.cm?no_idx=${notice.no_idx }&pageNum=${pageInfo.pageNum}">
								<c:choose>
									<c:when test="${not empty notice.no_img}">
										<img class="img" alt="" src="img/community/${notice.no_img }" width="500px">
									</c:when>
									<c:otherwise>
										<img alt="이미지없음" src="img/community/notice.png" width="500px">
									</c:otherwise>
								</c:choose>
							</a>
							
							
							<!-- 글제목 -->
							<div>
								<a href="NoticeDetail.cm?no_idx=${notice.no_idx }&pageNum=${pageInfo.pageNum}">
									<b>${notice.no_subject }</b>
								</a>
							</div>	
		
							<span>작성자 : ${notice.no_id }</span> 
							<span>작성일 : ${notice.no_date }</span> 
						</div>
						
						
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h1>공지사항이 존재하지 않습니다.</h1>
				</c:otherwise>
			</c:choose>
			
		</div>
	</main>
	
	
	
	<br>
	
	
	
	<!-- 버튼들 -->
	<div style="clear: both;">
	
		<c:if test="${not empty sessionScope.sId}">
			<section id="buttonArea">
				<input type="button" value="글쓰기" onclick="location.href='NoticeWriteForm.cm'" />
			</section>
		</c:if>
		
		<section id="pageList">
			<c:choose>
				<c:when test="${pageInfo.pageNum > 1}">
					<input type="button" value="이전" onclick="location.href='NoticeList.cm?pageNum=${pageNum - 1}'">
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
						<a href="NoticeList.cm?pageNum=${i }">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	
			<c:choose>
				<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
					<input type="button" value="다음" onclick="location.href='NoticeList.cm?pageNum=${pageNum + 1}'">
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