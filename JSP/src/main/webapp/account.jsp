<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jsp.Account" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Account acc = new Account();
out.print(acc.name);
%><br>
context path : <%=request.getContextPath() %><br>
<img src="<%=request.getContextPath() %>/img/logo.png">

</body>
</html>