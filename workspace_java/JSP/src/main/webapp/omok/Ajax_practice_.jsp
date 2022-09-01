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
			async : false,
			datatype: "text",
			success : function (obj) {
				// alert("성공");
				console.log(obj);
				if (obj == "성공") {
					alert("성공");
				} else {
					alert("계속 진행");
				}
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
	<h2>초록이면 성공, 다른 색은 실패</h2>
</body>
</html>