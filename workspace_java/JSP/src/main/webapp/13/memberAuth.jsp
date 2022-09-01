<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberAuth.jsp</title>
</head>
<body>
	<h2>MVC 패턴으로 회원 인증하기</h2>
	<strong>${authMessage }</strong>
	<br>
	<a href="./memberAuth.mvc?id=nakja&pass=1234">회원인증(관리자)</a>
	&nbsp;&nbsp;
	<a href="./memberAuth.mvc?id=test1&pass=1111">회원인증(회원)</a>
	&nbsp;&nbsp;
	<a href="./memberAuth.mvc?id=stranger&pass=1234">회원인증(비회원)</a>
	
	<form action="./memberAuth.mvc">
		id : <input type="text" name="id"><br>
		pass : <input type="password" name="pass">
		<input type="submit" value="로그인">
	</form>
</body>
</html>