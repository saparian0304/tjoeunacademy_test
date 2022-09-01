<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
	</tr>
	<c:forEach var="data" items="${list }">
	<tr>
		<td >${data.no }</td>
		<td >${data.title }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>