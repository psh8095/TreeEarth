<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/index.css" rel="stylesheet">

<header>
	<div id="logo">
		<h1></h1>
		<a href="./"><img src="img/main/logo33.png" alt="트리어스" width="400"></a>
	</div>
	<div id="font_img_holder">
		<img src="https://cdn.imweb.me/upload/S201808095b6c2aff66469/4c07bab104c64.gif" width="147" alt="" style="max-width: 100%; height: auto;">
	</div>
		<!-- 로그인/마이페이지/장바구니 영역-->
	<section>
		<c:choose>
			<c:when test="${empty sessionScope.sId}">
				<div class="login">
					<a href="MemberLoginForm.me">로그인</a>
				</div>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${sessionScope.sId eq 'admin'}">
						<div class="login">
							<a href="Admin.my">${sessionScope.sId }님</a>
							<a href="MemberLogout.me">로그아웃</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="login">
						    <a href="Cart.my">장바구니</a>
							<div class="dropdown">
								<a class="dropbtn">${sessionScope.sId } 님</a>
								<div class="dropdown-content">
									<ul class="inline">
										<li><a href="">적립금</a></li>
						                <li><a href="">이름</a></li>
						                <li><a href="Wishlist.my">위시리스트</a></li>
						                <li><a href="UpdateMemberInfoForm.my">회원정보수정</a></li>
						                <li><a href="">후원금 내역 조회</a></li>
						                <li><a href="">신청 캠페인 조회</a></li>
						                <li><a href="">작성한 글</a></li>
						                <li><a href="">작성한 댓글</a></li>
						                <li><a href="OrderList.my">주문내역 조회</a></li>
						            </ul>
				        		 </div>   
							</div>
						 <a href="MemberLogout.me">로그아웃</a>
						</div>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</section>
</header>
	
		<!-- 메뉴바 영역 -->
	<nav>
		<ul>
			<li class="dropdown">
            	<div class="dropbtn_menu">캠페인</div>
            	<div class="dropdown-content">
                	<a href="CampaignRecruList.cp">진행중인 캠페인</a>
                	<a href="CampaignExpiredList.cp">종료된 캠페인</a>
                </div>	
             </li>   
			<li class="dropdown">
                <div class="dropbtn_menu">후원하기</div>
                <div class="dropdown-content">
                	<a href="SupportListAction.su">진행중인 후원</a>
                </div>
            </li> 	
            <li class="dropdown">
              	<div class="dropbtn_menu">스토어</div> 
                <div class="dropdown-content">
                	<a href="">반려나무</a>
                    <a href="StoreItemImg.st">반려식물</a>
                    <a href="">부자재</a>
            	</div>
            </li>	
            <li class="dropdown">
                <div class="dropbtn_menu">커뮤니티</div>
                <div class="dropdown-content">
                    <a href="">공지사항</a>
                    <a href="CampaignReviewList.cm">캠페인 참여후기</a>
                    <a href="DiaryList.cm">반려나무 성장일기</a>
                    <a href="FreeBoardList.cm">자유게시판</a>
                    <a href="QnaFaqList.cm">Q & A</a>
               </div>
        	</li>
		</ul>
	</nav>