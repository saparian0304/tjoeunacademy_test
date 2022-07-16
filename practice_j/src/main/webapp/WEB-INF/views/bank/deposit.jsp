<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		var formObj = $('form');
		
		$('.deposit_btn').click(function(e) {
			e.preventDefault();
			$('input[name=accountNum]').removeAttr('disabled');
			$('input[name=holder]').removeAttr('disabled');
			formObj.submit();
		});
				
	});
</script>
</head>
<body>
	<h2>계좌 생성</h2>
	<form action="/ajp/bank/deposit.do" method="post" accept-charset="utf-8">
		계좌번호 : <input type="text" name="accountNum" value="${vo.accountNum }" disabled> <br>
		예금주 : <input type="text" name="holder" value="${vo.holder }" disabled> <br>
		입금액 : <input type="text" name="deposit">
		<button class="deposit_btn" type="submit" >입금</button>
	</form>
	<br>
	<button onclick="location.href='/ajp/bank/list.do'">계좌목록</button>
</body>
</html>