<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트리어스 자유게시판 ~ ★</title>
<style type="text/css">
	#listForm {
		width: 1024px;
		max-height: 610px;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		margin: auto;
		width: 1024px;
	}
	
	#tr_top {
		background: orange;
		text-align: center;
	}
	
	table td {
		text-align: center;
	}
	
	#subject {
		text-align: left;
		padding-left: 20px;
	}
	
	#pageList {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#emptyArea {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#buttonArea {
		margin: auto;
		width: 1024px;
		text-align: right;
	}
	
	a {
		text-decoration: none;
	}
</style>
</head>
<body>


	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	

	<!-- 게시판 리스트 -->
	<section id="listForm">
	<h2>게시판 글 목록</h2>
	<table>
		<tr id="tr_top">
			<td width="100px">번호</td>
			<td>제목</td>
			<td width="150px">작성자</td>
			<td width="150px">작성일</td>
			<td width="100px">조회수</td>
		</tr>
		<!-- 게시물 목록 출력(단, 게시물이 하나라도 존재할 경우에만 출력) => JSTL 과 EL 활용 -->
		<!-- JSTL 의 c:choose 태그를 사용하여 게시물 존재 여부 판별 -->
		<!-- 조건 : boardList 객체가 비어있지 않고 pageInfo 객체의 itemListCount 가 0보다 클 경우 -->
		<c:choose>
			<c:when test="${not empty boardList and pageInfo.itemListCount gt 0 }">
				<!-- c:foreach 태그를 사용하여 boardList 객체의 BoardDTO 객체를 꺼내서 출력 -->
				<c:forEach var="freeboard" items="${boardList }">
					<tr>
						<td>${freeboard.free_idx }</td>
						<td id="subject">
							<a href="FreeBoardDetail.cm?free_idx=${freeboard.free_idx }&pageNum=${pageInfo.pageNum}">
								<!-- 답글에 대한 들여쓰기(공백 추가) 작업 처리 -->
								<c:forEach var="i" begin="1" end="${freeboard.free_re_lev }">
									&nbsp;&nbsp;
								</c:forEach>
								${freeboard.free_subject }
							</a>
						</td>
						<td>${freeboard.free_name }</td>
						<td>${freeboard.free_date }</td>
						<td>${freeboard.free_readcount }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><td colspan="5">게시물이 존재하지 않습니다.</td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</section>
	<section id="buttonArea">
		<input type="button" value="글쓰기" onclick="location.href='FreeBoardWriteForm.cm'" />
	</section>
	<section id="pageList">
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













