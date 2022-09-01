<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    h1 {
        height: 50px;
        margin: 0 auto;
    }


    @-webkit-keyframes iteration-count{
        from{ top: -790px; }
        to{ top: 210px; }

    }

    /* 첫번째 가리게 */
    #box1 {
        position: absolute;
        z-index: 3;
        width: 220px;
        height: 208px;
        background-color: #e8e8c2;
        top: 0px;
        /* opacity: 0.5; */
    }

    
    /* 번호 나오는 박스 */
    .box2 {
        position: relative;
        z-index: 1;
        width: 25px;
        height: 50px;
        background-color: #e8e8c2;
        display: inline-block;

        /* 위치 */
        top: 150px;
        left: 28px;
    }

    /* 두번째 가리게 */
     #box3 {
        position: absolute;
        z-index: 3;
        width: 220px;
        height: 1000px;
        background-color: #e8e8c2;
        /* opacity: 0.5; */
        top: 258px;
    }

    
    /* 룰렛css */
    .box{
        position:absolute;
        z-index: 2;
        width: 25px;
        height: 50px;
        display: inline-block;
        top: -290px;
    }


    /* 촤라라라라락 */
    #roulette1{
        animation-delay: 0.1s
    }
    #roulette2{
        animation-delay: 0.2s
    }
    #roulette3{
        animation-delay: 0.3s
    }
    #roulette4{
        animation-delay: 0.4s
    }
    #roulette5{
        animation-delay: 0.5s
    }

</style>


<script src="js/jquery-3.6.0.js"></script>
   <script type="text/javascript">
        $(function() {


        // 룰렛 입니다. 
        //    --------------------------------------------------
            var a = 1;
            var b = 2;
            var c = 3;
            var d = 4;
            var e = 5;
            var f = 6;


            var i0 = a+1;
            var i1 = b+1;
            var i2 = c+1;
            var i3 = d+1;
            var i4 = e+1;
            var i5 = f+1;
            
            for(var z = 0; z < 6; z++){
                
                //반복할 때 마다 자리 숫자를 바꾼다.
                if(z == 1){
                    i0 = i1
                } else if (z == 2) {
                    i0 = i2
                } else if (z == 3) {
                    i0 = i3
                } else if (z == 4) {
                    i0 = i4
                } else if (z == 5) {
                    i0 = i5
                }


                //10번 동안 변수를 저장합니다.
                for(var x = 9; x >= 0; x--){
                    
                    //만약 기준 문자가 커지다가 9보다 커지면 초기화
                    if(i0 > 9) {
                        i0 = 0;
                    }
                    
                    $(".roulette"+z+x).html(i0)
                    i0++
                }
            }


                $(".box").css({
                '-webkit-animation-name':'iteration-count',
                'animation-iteration-count':'1',
                // 'animation-timing-function':'linear',
                'animation-timing-function':'ease-in-out',
                'animation-duration':'2s',
                // 'animation-fill-mode': 'forwards'
                });
            

        //    --------------------------------------------------

        });
</script>


</head>
<body>
  

    <h1>촤락</h1>

   <!-- 가림막 -->
   <div id="box1"></div>



    <!-- 1번 룰렛 -->
    <div class="box2"></div>
    <div class="box" id="roulette0">
        <h1 class="roulette00"></h1>
        <h1 class="roulette01"></h1>
        <h1 class="roulette02"></h1>
        <h1 class="roulette03"></h1>
        <h1 class="roulette04"></h1>
        <h1 class="roulette05"></h1>
        <h1 class="roulette06"></h1>
        <h1 class="roulette07"></h1>
        <h1 class="roulette08"></h1>
        <h1 class="roulette09"></h1>
        <h1 class="roulette00"></h1>
        <h1 class="roulette01"></h1>
        <h1 class="roulette02"></h1>
        <h1 class="roulette03"></h1>
        <h1 class="roulette04"></h1>
        <h1 class="roulette05"></h1>
        <h1 class="roulette06"></h1>
        <h1 class="roulette07"></h1>
        <h1 class="roulette08"></h1>
        <h1 class="roulette09"></h1>
        <h1 class="roulette00"></h1>
    </div>

     <!-- 2번 룰렛 -->
    <div class="box2"></div>
    <div class="box" id="roulette1">
        <h1 class="roulette10"></h1>
        <h1 class="roulette11"></h1>
        <h1 class="roulette12"></h1>
        <h1 class="roulette13"></h1>
        <h1 class="roulette14"></h1>
        <h1 class="roulette15"></h1>
        <h1 class="roulette16"></h1>
        <h1 class="roulette17"></h1>
        <h1 class="roulette18"></h1>
        <h1 class="roulette19"></h1>
        <h1 class="roulette10"></h1>
        <h1 class="roulette11"></h1>
        <h1 class="roulette12"></h1>
        <h1 class="roulette13"></h1>
        <h1 class="roulette14"></h1>
        <h1 class="roulette15"></h1>
        <h1 class="roulette16"></h1>
        <h1 class="roulette17"></h1>
        <h1 class="roulette18"></h1>
        <h1 class="roulette19"></h1>
        <h1 class="roulette10"></h1>
    </div>

      <!-- 3번 룰렛 -->
    <div class="box2"></div>
    <div class="box" id="roulette2">
        <h1 class="roulette20"></h1>
        <h1 class="roulette21"></h1>
        <h1 class="roulette22"></h1>
        <h1 class="roulette23"></h1>
        <h1 class="roulette24"></h1>
        <h1 class="roulette25"></h1>
        <h1 class="roulette26"></h1>
        <h1 class="roulette27"></h1>
        <h1 class="roulette28"></h1>
        <h1 class="roulette29"></h1>
        <h1 class="roulette20"></h1>
        <h1 class="roulette21"></h1>
        <h1 class="roulette22"></h1>
        <h1 class="roulette23"></h1>
        <h1 class="roulette24"></h1>
        <h1 class="roulette25"></h1>
        <h1 class="roulette26"></h1>
        <h1 class="roulette27"></h1>
        <h1 class="roulette28"></h1>
        <h1 class="roulette29"></h1>
        <h1 class="roulette20"></h1>
    </div>

      <!-- 4번 룰렛 -->
    <div class="box2"></div>
    <div class="box" id="roulette3">
        <h1 class="roulette30"></h1>
        <h1 class="roulette31"></h1>
        <h1 class="roulette32"></h1>
        <h1 class="roulette33"></h1>
        <h1 class="roulette34"></h1>
        <h1 class="roulette35"></h1>
        <h1 class="roulette36"></h1>
        <h1 class="roulette37"></h1>
        <h1 class="roulette38"></h1>
        <h1 class="roulette39"></h1>
        <h1 class="roulette30"></h1>
        <h1 class="roulette31"></h1>
        <h1 class="roulette32"></h1>
        <h1 class="roulette33"></h1>
        <h1 class="roulette34"></h1>
        <h1 class="roulette35"></h1>
        <h1 class="roulette36"></h1>
        <h1 class="roulette37"></h1>
        <h1 class="roulette38"></h1>
        <h1 class="roulette39"></h1>
        <h1 class="roulette30"></h1>
    </div>

      <!-- 5번 룰렛 -->
    <div class="box2"></div>
    <div class="box" id="roulette4">
        <h1 class="roulette40"></h1>
        <h1 class="roulette41"></h1>
        <h1 class="roulette42"></h1>
        <h1 class="roulette43"></h1>
        <h1 class="roulette44"></h1>
        <h1 class="roulette45"></h1>
        <h1 class="roulette46"></h1>
        <h1 class="roulette47"></h1>
        <h1 class="roulette48"></h1>
        <h1 class="roulette49"></h1>
        <h1 class="roulette40"></h1>
        <h1 class="roulette41"></h1>
        <h1 class="roulette42"></h1>
        <h1 class="roulette43"></h1>
        <h1 class="roulette44"></h1>
        <h1 class="roulette45"></h1>
        <h1 class="roulette46"></h1>
        <h1 class="roulette47"></h1>
        <h1 class="roulette48"></h1>
        <h1 class="roulette49"></h1>
        <h1 class="roulette40"></h1>
    </div>

      <!-- 6번 룰렛 -->
    <div class="box2"></div>
    <div class="box" id="roulette5" style="left: 182px;">
        <h1 class="roulette50"></h1>
        <h1 class="roulette51"></h1>
        <h1 class="roulette52"></h1>
        <h1 class="roulette53"></h1>
        <h1 class="roulette54"></h1>
        <h1 class="roulette55"></h1>
        <h1 class="roulette56"></h1>
        <h1 class="roulette57"></h1>
        <h1 class="roulette58"></h1>
        <h1 class="roulette59"></h1>
        <h1 class="roulette50"></h1>
        <h1 class="roulette51"></h1>
        <h1 class="roulette52"></h1>
        <h1 class="roulette53"></h1>
        <h1 class="roulette54"></h1>
        <h1 class="roulette55"></h1>
        <h1 class="roulette56"></h1>
        <h1 class="roulette57"></h1>
        <h1 class="roulette58"></h1>
        <h1 class="roulette59"></h1>
        <h1 class="roulette50"></h1>
    </div>


    <!-- 가림막 -->
    <div  id="box3"></div>
   


</body>
</html>