<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@font-face {
    font-family: 'HallymGothic-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2204@1.0/HallymGothic-Regular.woff2') format('woff2');
    font-weight: 400;
    font-style: normal;
}

*{margin: 0; padding: 0; font-family: 'HallymGothic-Regular';}

.table {
	margin: 0 0 40px 0;
	width: 100%;
	box-shadow: 0 1px 3px rgba(0,0,0,0.2);
	display: table;
}

.row {
	display: table-row;
}

.cell {
	display: table-cell;
}

.header {
	background-color: #c5e096;
	color: #ffffff;
	font-weight: 600;
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
	
	<div style="height: 50px"></div>
	<h1>참가 내역</h1>
	<hr style="color: gray; opacity: 50%; margin-bottom: 15px;">
	
	<c:choose>
		<c:when test="${empty applyList }">
			<h1>캠페인 참가 내역이 존재하지 않습니다.</h1>
		</c:when>
		
		<c:otherwise>
			<c:choose>
				<c:when test="${sessionScope.sId eq 'admin' }">
					<div class="table">
						<div class="row header">
							<div class="cell">캠페인</div>
							<div class="cell">회원 아이디</div>
							<div class="cell">이름</div>
							<div class="cell">연락처</div>
							<div class="cell">신청 인원</div>
							<div class="cell">기타 사항</div>
						</div>
						
						<c:forEach var="apply" items="${applyList }">
							<div class="row">
								<div class="cell">${apply.cam_subject }</div>
								<div class="cell">${apply.mem_id }</div>
								<div class="cell">${apply.mem_name }</div>
								<div class="cell">${apply.mem_phone }</div>
								<div class="cell">${apply.apply_people }</div>
								<div class="cell">${apply.apply_etc }</div>
							</div>
						</c:forEach>
					</div>
				</c:when>
				
				<c:otherwise>
					<div class="table">
						<div class="row header">
							<div class="cell">캠페인</div>
							<div class="cell">회원 아이디</div>
							<div class="cell">이름</div>
							<div class="cell">연락처</div>
							<div class="cell">신청 인원</div>
							<div class="cell">기타 사항</div>
						</div>
						
						<c:forEach var="apply" items="${applyList }">
							<div class="row">
								<div class="cell">${apply.cam_subject }</div>
								<div class="cell">${apply.mem_id }</div>
								<div class="cell">${apply.mem_name }</div>
								<div class="cell">${apply.mem_phone }</div>
								<div class="cell">${apply.apply_people }</div>
								<div class="cell">${apply.apply_etc }</div>
							</div>
						</c:forEach>
					</div>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>