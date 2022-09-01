<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% response.sendRedirect("c.jsp"); %>
<%-- sendRedirect는 referrer가 a.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	location.href="c.jsp"
	<%-- location은 referrer가 b.jsp --%>
</script>
</head>
<body>

</body>
</html>