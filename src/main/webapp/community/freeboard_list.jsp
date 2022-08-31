<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 자유게시판</title>
<link href="css/community.css" rel="stylesheet">
</head>
<body>


	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	

	<!-- 게시판 리스트 -->
	<div class="main">
	
	
	 	 <hr style="color: gray; opacity: 70%; margin: 50px;">

				<!-- 자유게시판 타이틀-->
				<div class="free_title">
					<span>자유게시판</span>
				</div>
				 
				
				<!-- 글쓰기 -->
				<div class="free_title_button">
					<input type="button" value="글쓰기" onclick="location.href='FreeBoardWriteForm.cm'" />
				</div>
			
		
		 <hr>
	
	
				<!-- 게시판 구별 -->
				<div >
					<span class="free_subject">제목</span>
					<span class="free_name">작성자</span>
					<span class="free_date">작성일</span>
					<span class="free_read">조회수</span>
				</div>
			
		
		 <hr>
		
		
		
		<!-- 게시판 내용 -->
		<div >
		
			<c:choose>
				<c:when test="${not empty boardList and pageInfo.itemListCount gt 0 }">
					<c:forEach var="freeboard" items="${boardList }">
					
					
							<!-- 제목 -->
							<div class="free_subject">
								<a href="FreeBoardDetail.cm?free_idx=${freeboard.free_idx }&pageNum=${pageInfo.pageNum}">
									<c:forEach var="i" begin="1" end="${freeboard.free_re_lev }">
										&nbsp;&nbsp;
									</c:forEach>
									${freeboard.free_subject }
								</a>
							</div>
							
							<!-- 작성자 -->
							<div class="free_name">
								${freeboard.free_name }
							</div>
							
							

							<div class="free_date">
								${freeboard.free_date }
							</div>
							
							
							<!-- 조회수 -->
							<div class="free_read">
								${freeboard.free_readcount }
							</div>
							
						
		 					<hr style="color: gray; opacity: 70%; margin: 20px; clear: both;">
						
					</c:forEach>
					
					
				</c:when>
				<c:otherwise>
					<div>게시물이 존재하지 않습니다.</div> 
				</c:otherwise>
			</c:choose>
			
		</div>
		
		
	</div>
	




		
		
		
	<section style="text-align: center;">
		<!-- 
		현재 페이지 번호(pageNum)가 1보다 클 경우에만 [이전] 링크 동작
		=> 클릭 시 BoardList.cm 서블릿 주소 요청하면서 
		   현재 페이지 번호(pageNum) - 1 값을 page 파라미터로 전달
		-->
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='FreeBoardList.cm?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>
			
		<!-- 페이지 번호 목록은 시작 페이지(startPage)부터 끝 페이지(endPage) 까지 표시 -->
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<!-- 단, 현재 페이지 번호는 링크 없이 표시 -->
			<c:choose>
				<c:when test="${pageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="FreeBoardList.cm?pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 현재 페이지 번호(pageNum)가 총 페이지 수보다 작을 때만 [다음] 링크 동작 -->
		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='FreeBoardList.cm?pageNum=${pageInfo.pageNum + 1}'">
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













