<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>

<%
String name = "홍길동";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%for (int i=0; i<10; i++) { %>
제 이름은 <%out.print(name);%>입니다.
<% } %><br>
<%=new Date() %><br>
age 파라미터의 값은 : <%=request.getParameter("age") %>

</body>
</html>