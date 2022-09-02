<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

$(document).ready(function() {

    GetList(1);
    /* 카드가 나타나는 애니메이션
    $(document).ready(function() {
        $(window).scroll( function(){
            $('.thumb').each( function(i){

                var bottom_of_element = $(this).offset().top + $(this).outerHeight();
                var bottom_of_window = $(window).scrollTop() + $(window).height();

                if( bottom_of_window > bottom_of_element ){
                    $(this).animate({'opacity':'1','margin-bottom':'0px'},1000);
                }

            }); 
        });
    });
    */

    // 게시물 이미지를 클릭했을 때 실행된다
    // 해당 게시물을 hit+1하는 함수를 호출한다.
    $(document).on('click', '.card-img', function() {
        // 게시물 번호(no)를 idx로 전달받아 저장합니다.
        let no = $(this).attr('idx');

        console.log(no +"에 hit + 1을 함");

        // hit+1하고 그 값을 불러온다.
        $.ajax({
            url : 'picture_view.do',
            type : 'get',
            data : {
                no : no
            },
            success : function(to) {
                let hit = to.hit;

                $('#m_hit'+no).text(hit);
                $('#hit'+no).text(hit);

            },
            error : function() {
                alert('서버 에러');
            }
        });
    });


});

// 창 크기가 변할 때마다 가로세로 길이를 맞춰준다.
$(window).resize(function(){
    $('.box').each(function(){
        $(this).height($(this).width());
    });
}).resize();

$(".heart-click").click(function() {

    // 게시물 번호(no)를 idx로 전달받아 저장합니다.
    let no = $(this).attr('idx');
    console.log("heart-click");

    // 빈하트를 눌렀을때
    if($(this).children('svg').attr('class') == "bi bi-suit-heart"){
        console.log("빈하트 클릭" + no);

        $.ajax({
            url : 'saveHeart.do',
            type : 'get',
            data : {
                no : no,
            },
            success : function(pto) {
                //페이지 새로고침
                //document.location.reload(true);

                let heart = pto.heart;

                // 페이지, 모달창에 하트수 갱신
                $('#m_heart'+no).text(heart);
                $('#heart'+no).text(heart);

                console.log("하트추가 성공");
            },
            error : function() {
                alert('서버 에러');
            }
        });
        console.log("꽉찬하트로 바껴라!");

        // 꽉찬하트로 바꾸기
        $(this).html("<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-suit-heart-fill' viewBox='0 0 16 16'><path d='M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z'/></svg>");
        $('.heart_icon'+no).html("<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-suit-heart-fill' viewBox='0 0 16 16'><path d='M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z'/></svg>");

    // 꽉찬 하트를 눌렀을 때
    }else if($(this).children('svg').attr('class') == "bi bi-suit-heart-fill"){
        console.log("꽉찬하트 클릭" + no);

        $.ajax({
            url : 'removeHeart.do',
            type : 'get',
            data : {
                no : no,
            },
            success : function(pto) {
                //페이지 새로고침
                //document.location.reload(true);

                let heart = pto.heart;
                // 페이지, 모달창에 하트수 갱신
                $('#m_heart'+no).text(heart);
                $('#heart'+no).text(heart);

                console.log("하트삭제 성공");
            },
            error : function() {
                alert('서버 에러');
            }
        });
        console.log("빈하트로 바껴라!");

        // 빈하트로 바꾸기
        $(this).html('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16"><path d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" /></svg>');

        $('.heart_icon'+no).html('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16"><path d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" /></svg>');
    }



});


// 로그인 안한 상태에서 하트를 클릭하면 로그인해야한다는 알림창이 뜹니다.
// (로그인한 상태인 하트의 <a></a> class명: heart-notlogin)
$(".heart-notlogin").unbind('click');
$(".heart-notlogin ").click(function() {
    alert('로그인 하셔야 하트를 누를수 있습니다!');
});

$.ajax({
    url : 'saveHeart.do',
    type : 'get',
    data : {
        no : no,
    },
    success : function(pto) {
        //페이지 새로고침
        //document.location.reload(true);

        let heart = pto.heart;

        // 페이지, 모달창에 하트수 갱신
        $('#m_heart'+no).text(heart);
        $('#heart'+no).text(heart);

        console.log("하트추가 성공");
    },
    error : function() {
        alert('서버 에러');
    }
    
    $(this).html("<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-suit-heart-fill' viewBox='0 0 16 16'><path d='M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z'/></svg>");
    $('.heart_icon'+no).html("<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-suit-heart-fill' viewBox='0 0 16 16'><path d='M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z'/></svg>");
</script>
</head>
<body>

<c:forEach var="tmp" items="${list }">
<c:choose>
    <%-- 로그인 상태일때 - 하트 클릭 되게 --%>
    <c:when test="${not empty sessionScope.nick}">
        <c:choose>
            <c:when test="${empty tmp.hno}">
                <%-- 빈 하트일때 --%>
                <span> <a idx="${tmp.no }" href="javascript:"
                    class="heart-click heart_icon${tmp.no }"><svg
                            xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                            fill="currentColor" class="bi bi-suit-heart"
                            viewBox="0 0 16 16">
                                  <path
                                d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                                </svg></a>
                </span>
            </c:when>
            <c:otherwise>
                <%-- 꽉찬 하트일때 --%>
                <span> <a idx="${tmp.no }" href="javascript:"
                    class="heart-click heart_icon${tmp.no }"><svg
                            xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                            fill="currentColor" class="bi bi-suit-heart-fill"
                            viewBox="0 0 16 16">
                                  <path
                                d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                                </svg></a>
                </span>
            </c:otherwise>
        </c:choose>
    </c:when>
    <%-- 로그인 상태가 아닐때  - 하트클릭 안되게 --%>
    <c:otherwise>
        <span> <a href="javascript:" class="heart-notlogin">
                <svg class="heart3" xmlns="http://www.w3.org/2000/svg"
                    width="16" height="16" fill="currentColor"
                    class="bi bi-suit-heart" viewBox="0 0 16 16">
                          <path
                        d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                        </svg>
        </a>
        </span>
    </c:otherwise>
</c:choose>
<span id="heart${tmp.no }">${tmp.heart }</span>

<c:choose>
    <%-- 로그인 상태일때 - 하트 클릭 되게 --%>
    <c:when test="${not empty sessionScope.nick}">
        <c:choose>
            <c:when test="${empty tmp.hno}">
                <%-- 빈 하트일때 --%>
                <a idx="${tmp.no}" href="javascript:"
                    class="heart-click heart_icon${tmp.no }"><svg
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                        fill="currentColor" class="bi bi-suit-heart"
                        viewBox="0 0 16 16">
                          <path
                            d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                        </svg></a>

            </c:when>
            <c:otherwise>
                <%-- 꽉찬 하트일때 --%>
                <a idx="${tmp.no}" href="javascript:"
                    class="heart-click heart_icon${tmp.no }"><svg
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                        fill="currentColor" class="bi bi-suit-heart-fill"
                        viewBox="0 0 16 16">
                          <path
                            d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                        </svg></a>
            </c:otherwise>
        </c:choose>
    </c:when>
    <%-- 로그인 상태가 아닐때  - 하트클릭 안되게 --%>
    <c:otherwise>
        <a href="javascript:" class="heart-notlogin"> <svg
                class="heart3" xmlns="http://www.w3.org/2000/svg" width="16"
                height="16" fill="currentColor" class="bi bi-suit-heart"
                viewBox="0 0 16 16">
                  <path
                    d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                </svg></a>
    </c:otherwise>
</c:choose>
</span> <span id="m_heart${tmp.no }">${tmp.heart }</span>

</c:forEach>

</body>
</html>