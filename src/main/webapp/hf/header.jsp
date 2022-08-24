<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="css/header.css" rel="stylesheet">


<!-- 제이쿼리 -->
	<script src="js/jquery-3.6.0.js"></script>
	
	
<!-- 스크립트 -->
	<script type="text/javascript">
	$(function(){
		
		//스크롤 이벤트
	    var lastScrollTop = 0; 
	    var delta = 15;
	    
	    $(window).scroll(function(event){
	       var st = $(this).scrollTop();
	       
	       if(Math.abs(lastScrollTop - st) <= delta)
	          return; // 스크롤값을 받아서 리턴한다.
		          
			if ((st > lastScrollTop) && (lastScrollTop>0)) {
		       // downscroll code
		  		$("#header1").css({
		  			"background-color":"white",
		  			"position" : "fixed ",
		  			"transition-duration" : "0.5s"
		  		});
		   } else {
		      // upscroll code
		  		$("#header1").css({
		  			"background-color":"",
		  			"position" : "fixed",
		  			"transition-duration" : "0.5s"
		  		});
		   }
		       lastScrollTop = st;
	    });
	    
	    
	});
	
	function login() {
		window.open("MemberLoginForm.me", "login", "width=350, height=400");
	}
	
	</script>




<!-- 헤더 -->
<header style="position: relative; width:100%; height: 800px">
	
	
	
	<!-- 헤더 산 사진 -->
	<div style="height:70px; width:100%; height:800px; background-color: white; position:  absolute; z-index: 1; overflow: hidden;">
	    <img src="img/4961757.jpg" width="100%" alt="나무">
 	</div>
	
	
	
	<!-- 헤더 기능 메뉴 -->
	<div id="header1" style=" width:100%; position: absolute; z-index: 2;">
	
	
<!-- 				로고 -->
<!-- 			<div id="logo"> -->
<!-- 				<a href="./"><img src="img/main/logo33.png" alt="트리어스" width="250"></a> -->
<!-- 			</div> -->

		
	<!-- 	<!-- 촤락  -->
	<!-- 	<div id="font_img_holder"> -->
	<!-- 		<img src="https://cdn.imweb.me/upload/S201808095b6c2aff66469/4c07bab104c64.gif" width="147" alt="" style="max-width: 100%; height: auto;"> -->
	<!-- 	</div> -->
		
		<!-- 로그인/마이페이지/장바구니 영역 -->
		<div id=login>

		
			<section>
				<c:choose>
					<c:when test="${empty sessionScope.sId}">
						<div class="login">
							<span onclick="login()">로그인</span>
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



								<div id="myPage">
									<div class="myPage">
									
										<span id="sId">/ ${sessionScope.sId }님</span>
											<ul class="subMyPage">
												<li><a href="">적립금</a></li>
												<li><a href="">이름</a></li>
												<li><a href="Wishlist.my">위시리스트</a></li>
												<li><a href="UpdateMemberInfoForm.my">회원정보수정</a></li>
												<li><a href="">후원금 내역 조회</a></li>
												<li> <a href="">신청 캠페인 조회</a></li>
												<li><a href="">작성한 글</a></li>
												<li> <a href="">작성한 댓글</a></li>
												<li><a href="OrderList.my">주문내역 조회</a></li>
											</ul>
										
									</div>
								</div>
								
								<div id="cart">
									<a href="Cart.my">장바구니 </a>
								</div>
								
								
							</c:otherwise>
							
							
						</c:choose>
					</c:otherwise>
				</c:choose>
			</section>
		
		</div>
		
	
	
	 	<!-- 메뉴바 영역 -->
		<div id="menu">
			<ul class="menu">
			
			
				<li>캠페인
					<ul class="subMenu">
						<li><a href="CampaignList.cp">진행중인 캠페인</a></li>
						<li><a href="CampaignExpiredList.cp">종료된 캠페인</a></li>
					</ul>
				</li>
				
				
				<li>후원하기
					<ul class="subMenu">
						<li><a href="SupportList.su">진행중인 후원</a></li>
					</ul>
				</li>
				
				
				<li>스토어
					<ul class="subMenu">
						<li><a href="StoreItemList.st?sto_category=반려나무">반려나무</a></li>
						<li><a href="StoreItemList.st?sto_category=식물">반려식물</a></li>
						<li><a href="StoreItemList.st?sto_category=부자재">부자재</a></li>
					</ul>
				</li>
				
				
				<li>커뮤니티
					<ul class="subMenu">
						<li><a href="">공지사항</a></li>
						<li><a href="CampaignReviewList.cm">캠페인 참여후기</a></li>
						<li><a href="DiaryList.cm">반려나무 성장일기</a></li>
						<li><a href="FreeBoardList.cm">자유게시판</a></li>
						<li><a href="QnaList.cm">Q & A</a></li>
					</ul>
				</li>
				
				
			</ul>
		</div>
	</div>
</header>
