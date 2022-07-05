<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('div').click(function(){
		$.ajax({
			url : '/omokproject/test/Ajax_practice.do',
			type : 'post',
			data : {color: $(this).attr('class')},
			success : function(){
				alert("ajax성공");
			},
			error : function () {
				alert("ajax실패");
			}
		})
	})
})
</script>
<style>
	div { width : 100px; height : 100px;}
	.red { background-color : red}
	.blue { background-color : blue}
	.green { background-color : green}
</style>
</head>
<body>
	<div class="red"></div>
	<div class="blue"></div>
	<div class="green"></div>
</body>
</html>

