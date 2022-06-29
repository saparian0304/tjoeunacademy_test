<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
$(function() {
	$('div').click(function () {
		$.ajax({
			url : "/web/ajax/Ajax_parctice.do", //이동할 jsp파일 주소
			type: "post",
			data : {color: $(this).attr("class")},
			success : function () {
				alert("성공");
			},
			error:function(){ 
				alert("실패");
			}
		})
	})	
})

	

</script>

<style>
div {
	width: 100px;
	height: 100px;
}

.red {
	background-color: red
}

.blue {
	background-color: blue
}

.green {
	background-color: green
}
</style>
</head>
<body>
	<div class="red"></div>
	<div class="blue"></div>
	<div class="green"></div>
</body>
</html>