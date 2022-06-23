<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 상세</h2>
<table border="1">
	<tr>
		<th>회원번호</th>
		<td>${user.userno }</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${user.name }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${user.email }</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${user.tel }</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>
<c:forEach var="obj" items="${hobbyList }" >
		${obj.name } &nbsp;
</c:forEach>
		</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>${user.regidate }</td>
	</tr>
	
</table>
</body>
</html>