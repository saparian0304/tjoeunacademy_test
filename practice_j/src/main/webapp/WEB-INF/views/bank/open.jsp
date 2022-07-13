<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계좌 생성</h2>
	<form action="/ajp/bank/open.do" method="post" accept-charset="utf-8">
		예금주 : <input type="text" name="holder"> <br>
		입금액 : <input type="text" name="deposit">
		<button type="submit" >생성</button>
	</form>
</body>
</html>