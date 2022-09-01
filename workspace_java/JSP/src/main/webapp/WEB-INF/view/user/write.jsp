<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 등록</h2>
<form action="insert.do" method="post">
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="tel"></td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				<input type="checkbox" name="hobby" value="영화">영화<br>
				<input type="checkbox" name="hobby" value="게임">게임<br>
				<input type="checkbox" name="hobby" value="독서">독서<br>
				<input type="checkbox" name="hobby" value="낚시">낚시
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="등록"></td>
		</tr>
	</table>
</form>






</body>
</html>