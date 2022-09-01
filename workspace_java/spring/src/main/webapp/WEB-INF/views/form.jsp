<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>등록 폼</h2>
<form action="submit.do" method="get">
	회원번호 : <input type="text" name="num"><br>
	아이디 : <input type="text" name="id"><br>
	이름 : <input type="text" name="name"><br>
	전화번호: <input type="text" name="tel" ><br>
	취미 : <input type="checkbox" name="hobby" value="game"> 게임
	<input type="checkbox" name="hobby" value="movie"> 영화
	<input type="checkbox" name="hobby" value="book"> 독서
	<input type="checkbox" name="hobby" value="fish"> 낚시<br>
	<input type="submit" value="등록">
</form>
</body>
</html>