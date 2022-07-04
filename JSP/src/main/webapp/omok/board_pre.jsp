<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
        .board{
            width: 988px; height: 988px;
            margin: 0 auto;
            /* border: 1px solid transparent;  */
            border: 1px none black;
            box-sizing: border-box;
            background-image: url("./image/Blank_Go_board.png");
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
    </style>
    <script>
    $( function() {
        for(var i=0; i<19; i++){
            var a = document.createElement('div');
            $(".board").append(a);
            a.id = 'row'+i;
            a.className = 'row';
            for(var k=0; k<19; k++){
                var b = document.createElement('div');
                $('#row'+i).append(b);
                b.id = 'col'+k;
                b.className = 'col';};
        };
        var rowNumber = 0;
           $('.col').click(function(){
                rowNumber++;
                if(rowNumber % 2 == 0){
                    var img=document.createElement("img");
                   $(this).prepend(img)
                    img.src="./image/white.png";
                    img.style.width=40+"px";
                    img.style.marginTop=5+"px";
                    img.style.marginLeft=5+"px";
                    $(this).prepend(img);
                }else{
                    var img=document.createElement("img");
                    $(this).prepend(img)
                    img.src="./image/black.png";
                    img.style.width=40+"px";
                    img.style.marginTop=5+"px";
                    img.style.marginLeft=5+"px";
                    $(this).prepend(img);
                };
                $(this).off("click").on('click', function() {})
                
            });
    } );
    </script>
</head>
<body>
    <button>시작하기</button>
    <button>재시작</button>
    <div class="board">
    </div>
</body>
</html>