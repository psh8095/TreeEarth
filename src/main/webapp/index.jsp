<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TreeEarth</title>
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	    <main>
        <img src="img/4.png" alt="대충 웅장한 산 사진" width="100%">
        <div class="line">
            <div class="dropdown">
                <a class="dropbtn box">캠페인</a>
                <div class="dropdown-content">
                <ul class="inline">
                    <li><a href="CampaignRecruList.cp">모집 캠페인</a></li>
                    <li><a href="CampaignExpiredList.cp">종료 캠페인</a></li>
                    <li><a href="">캠페인 아이디어 공모</a></li>
                </ul>
                </div>
            </div>
            <div class="dropdown">
                <a class="dropbtn box">후원</a>
                <div class="dropdown-content">
                <ul class="inline">
                    <li><a href="SupportDetail.su">후원하기</a></li>
                </ul>
                </div>
            </div>
            <div class="dropdown">
                <a class="dropbtn box">스토어</a>
                <div class="dropdown-content">
                <ul class="inline">
                    <li><a href="">반려나무</a></li>
                    <li><a href="">식물</a></li>
                    <li><a href="">부자재</a></li>
                </ul>
                </div>
            </div>
            <div class="dropdown">
                <a class="dropbtn box">커뮤니티</a>
                <div class="dropdown-content">
                <ul class="inline">
                    <li><a href="">캠페인 후기</a></li>
                    <li><a href="">반려나무 성장일기</a></li>
                    <li><a href="">Q&A</a></li>
                    <li><a href="">공지사항</a></li>
                    <li><a href="">자유게시판</a></li>
                </ul>
                </div>
            </div>
        </div>
        <img src="img/2.png" alt="대충 메인 베너1" width="100%">
        <img src="img/3.png" alt="대충 메인 베너2" width="100%">
    </main>
    <!-- 푸터 -->
	<jsp:include page="hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>