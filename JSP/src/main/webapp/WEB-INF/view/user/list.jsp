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
<h2>회원 목록</h2>
<table border="1">
	<tr>
		<th>회원번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>연락처</th>
		<th>가입일</th>
		<th>취미</th>
	</tr>
<c:forEach var="obj" items="${list }" >
	<tr onclick="location.href='view.do?userno=${obj.userno}';" style="cursor:pointer;">
		<td>${obj.userno }</td>
		<td>${obj.name }</td>
		<td>${obj.email }</td>
		<td>${obj.tel }</td>
		<td>${obj.regidate }</td>
	</tr>
</c:forEach>
	
</table>
</body>
</html>