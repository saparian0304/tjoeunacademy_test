<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>오목 대결</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap');
        .btn{
            width: 1000px; height: 60px;
            margin: 0 auto;
        }
        .btn_start, .btn_end{
            width: 100px; height: 50px;
            border-radius: 20px;
    		border:0; outline:0;
            background: linear-gradient(45deg, Violet, Orange);
            font-size: 20px; font-weight: bold;
            font-family: 'Gamja Flower', cursive;
            color: #fff;
            padding: 0px;  margin: 0px;
            cursor: pointer;
        }
        .board{
            width: 988px; height: 988px;
            margin: 0px auto;
            border: 1px none black;
            box-sizing: border-box;
            background-image: url("../resources/image/startGame.jpg");
            background-size: calc(988px - 34px) calc(988px + 3px);
            background-repeat: no-repeat;
        }
        .row {
            width: 988px;   height: 52px;
            display : flex;
        }
        .col {
            /* border: 1px solid transparent; */
            border: 1px none black;
            width: 50px;
            height: 50px;
        };
        
        /* 모달 */
        #modal { 
            display: none;
        }
        #modal.active{
            display: block;
            background: rgba(0, 0, 0, 0.8);
            width: 100%; height: 1100px;
            position: absolute; top: 0; left: 0; bottom:0;
        }

        #modal_up.active{
            display: block;
        }
        #modal_up {
        	display: none;
        	background: rgba(190, 190, 190, 0.7);
            width: 800px; height: 500px;
            border-radius: 5px;
            position: fixed; left: 28%; top: 30%;
           
        } 
        #win{            
            font-family: 'Gamja Flower', cursive;
        	font-size: 70px;
        	font-weight: bold;
        	background: linear-gradient(to right top, #861657, #ffa69e);
		    color: transparent;
		    -webkit-background-clip: text;
		    text-shadow: 4px 3px 5px rgba(87, 89, 91, 0.5);
           	position: absolute; left:23%; top: 40%; 
        }
        .btn_close{
	        width: 100px; height: 30px; line-height: 30px;
	        font-family: 'Gamja Flower', cursive;
	        color: #d3c2c2;
	        text-align: center; font-size: 15px; font-weight: bold;
	        background: #746aaa; border-radius: 3px;
	        cursor: pointer;
	        position: absolute;right: 30px; bottom: 20px;
   		 }
    </style>
    <script>
    $( function() {
        // 흑백 구분을 위한 변수 선언
        var stoneNum = 0;
    	
    	// 이중 for문 : 바둑판 태그 생성 
    	for(var i=0; i<19; i++){
            var rowdiv = document.createElement('div');
            $(".board").append(rowdiv);
            rowdiv.id = 'row'+i;
            rowdiv.className = 'row';
            for(var j=0; j<19; j++){
                var coldiv = document.createElement('div');
                $('#row'+i).append(coldiv);
                coldiv.id = 'col'+j;
                coldiv.className = 'col';};
        };
        
    	// 시작 버튼 클릭 이벤트 
    	// - 사진 교체 (대기화면 -> 바둑판)
    	// - 버튼 텍스트 교체 (시작하기->재시작)
    	$('.btn_start').click(function(){
            $('.board').css('background-image','url("../resources/image/game_Board.png")');
            $(this).html("재시작");
        });
        
        
        // 시작버튼 클릭 및 재시작시 클릭이벤트 시작  
    	if (${not empty game}) {
    		$('.board').css('background-image','url("../resources/image/game_Board.png")');
            $('.btn_start').html("재시작");
    		$('.col').on('click', function(){
    			stoneNum++;
                if(stoneNum % 2 == 0){
                    var img=document.createElement("img");
                    img.src="../resources/image/whiteStone.png";
                    img.style.width="40px";
                    img.style.marginTop="5px";
                    img.style.marginLeft="5px";
                    $(this).prepend(img);
                }else{
                    var img=document.createElement("img");
                    img.src="../resources/image/blackStone.png";
                    img.style.width="40px";
                    img.style.marginTop="5px";
                    img.style.marginLeft="5px";
                    $(this).prepend(img);
                };
                $(this).off("click").on('click', function() {})
           	
                $.ajax({
					url : '/game/board/omok/stone.do',
					type : 'post',
					data : {
						col : $(this).attr('id'),
						row : $(this).parent().attr('id'),
						stoneNum : stoneNum
					},
					datatype : "text",
					success : function(data) {
						$('#win').html(data);                       
						if(data != null && data != ""){
							$(".col").off("click"); 
							// 모달창 팝업								
							$('#modal_up').addClass('active');
							$('#modal').addClass('active');
							
							// 모달창 닫기버튼 이벤트
                            $('.btn_close').click(function(){
                                $('#modal_up').removeClass('active');
                                $('#modal').removeClass('active');
                            });
						}
					},
					error : function (data) {
					}
				});
           })
    	}
        
    	// 종료 버튼 클릭 이벤트
        // - 대기화면
        // - 바둑돌 삭제
        // - 클릭이벤트 off
        $('.btn_end').click(function(){
            $('.board').css('background-image','url("../resources/image/startGame.jpg")');
            $('img').remove();
            $('.col').off('click');
        });
    	
    } );

    </script>
</head>
<body>
    <div class="btn">
        <button class="btn_start" onclick="location.href='./omok.do?game=start';">시작하기</button>
        <button class="btn_end">종료</button>
    </div>
    <div class="board">
    	<div id="modal"> <!-- 모달창 -->
      		<div id=modal_up>
		    	<div id="win"></div>
		    	<div class="btn_close">닫기</div>
	    	</div>
	  	</div>  	
    </div> 
    
</body>
</html>