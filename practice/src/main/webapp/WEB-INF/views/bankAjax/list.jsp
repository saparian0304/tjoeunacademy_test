<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JP 은행</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	$('.main_Btn').click(function() {
		var str = ''
		
		var data = $(this).val();
		console.log(data);
		$.ajax({
			url : '/ajp/bank/html',
			data : JSON.stringify({data : data}),
			method : 'post',
			contentType: "application/json; charset=utf-8",
			success: function(data) {
				$('.addHtml').html(data);
			},
			error: function() {
				alert('실패')
			}
			
		})
	});
})
</script>
</head>
<body>
<h2>JP 은행</h2>
<button class="main_Btn" type="button" value="create" >계좌 생성</button>
<button class="main_Btn" type="button" value="deposit">입금</button>
<button class="main_Btn" type="button" value="withdraw">출금</button>
<button class="main_Btn" type="button" value="remove">계좌 삭제</button>
<div class='addHtml'></div>
</body>
</html>