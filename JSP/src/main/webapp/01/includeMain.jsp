<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includeFile.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
include file="includeFile.jsp" 를 이용해서 today, tomorrow 출력하기 
<br><br><br>
<%
out.println("오늘 날짜: " + today);
out.println("<br>");
out.println("내일 날짜: " + tomorrow);
out.println("<script>alert('1')</script>");
%>
<script>
	alert("<%=tomorrow%> ");
</script>
</body>
</html>