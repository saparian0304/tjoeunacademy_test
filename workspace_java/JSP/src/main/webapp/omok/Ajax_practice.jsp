<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		var btn_cnt = 0;
		$('button').click(function() {
			btn_cnt++;
			if (btn_cnt == 1) {
				var board = "";
				board += '<table>';
				for (var i=0; i<19; i++) {
					board += '<tr>';
					for (var j=0; j<19; j++) {
						var str = "row"+i+" col"+j;
						board += '<td class=';
						board += '"' + str + '"'
						board += '></td>';
					}
					board += '</td>';
				}
				board += '</table>';
				$(this).after(board);				
			} else {
				$('td').css('background', "none");
			}
		});
	})
    
	var cnt = 0;
	$(document).on("click", "td", function() {
    	cnt++;
    	if ($(this).css('background-color')=='rgb(255, 0, 0)' 
    			|| $(this).css('background-color')=='rgb(0, 0, 255)') {
    		alert('그곳엔 둘 수 없습니다.');
    		cnt--;
    		return;
    	}
    	if (cnt%2 == 0) {
    		$(this).css('background', 'red')
    	} else {
    		$(this).css('background', 'blue')
    	}
		console.log($(this).attr('class'))
	});
</script>
<style>
	div { width : 100px; height : 100px;}
	.red { background-color : red}
	.blue { background-color : blue}
	.green { background-color : green}
	
	td {
    	border: 1px solid #444444;
    	width : 30px;
    	height : 30px;
  	}
</style>
</head>
<body>
	<button type="button" >시작하기</button>

	
</body>
</html>