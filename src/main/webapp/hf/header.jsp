<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<div id="header">
		<a href="./"><h1 class="title">트리어스</h1></a>
	    <a href="Cart.my" class="dropbtn">장바구니</a>
		<div class="dropdown">
			<a class="dropbtn">마이페이지</a>
			<div class="dropdown-content">
				<ul class="inline">
					<li><a href="">적립금</a></li>
	                <li><a href="">이름</a></li>
	                <li><a href="Wishlist.my">위시리스트</a></li>
	                <li><a href="">회원정보수정</a></li>
	                <li><a href="">후원금 내역 조회</a></li>
	                <li><a href="">신청 캠페인 조회</a></li>
	                <li><a href="">작성한 글</a></li>
	                <li><a href="">작성한 댓글</a></li>
	            </ul>
			</div>
		</div>
		<c:choose>
			<c:when test="${empty sessionScope.sId}">
				<a href="MemberLoginForm.me">로그인</a>
			</c:when>
			<c:otherwise>
				<a href="">${sessionScope.sId } 님</a>
				<a href="MemberLogout.me">로그아웃</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>