<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	$("#btn").click(function() {
		var data = $('#frm').serialize(); 	// data에 담긴값 : pageNum=1&amount=10 
		console.log(data);
		$.ajax({
			url : "http://localhost:8080/spring/api/board/list",
			/* 파라미터 개별 처리
			data : {
				pageNum : $("#pageNum").val(),
				amount : $('#amount').val()
			},
			*/
			data : data,
			dataType : 'json',
			method : "post",
			success : function(res) {
				//console.log(res);
				var html = "<table border='1'>"
				$.each(res, function(key, val){
					html += "<tr>";
					html += 	"<td>" + val.bno + "</td>";
					html += 	"<td>" + val.title + "</td>";
					html += 	"<td>" + val.writer + "</td>";
					html += "</tr>";
					//console.log(val.title + "  " + val.writer)
				});
				html += "</tabla>";
				$("#boardArea").html(html);
			}, 
			error : function(res) {
				console.log(res);
			}
		})
	});
})
</script>
</head>
<body>
<form id="frm">
	페이지 번호 : <input type="number" id="pageNum" name="pageNum" value="1">
	페이지당 개수 : <input type="number" id="amount" name="amount" value="10">
	<input type="button" id="btn" value="API">
</form>

	<div id="boardArea"></div>
</body>
</html>