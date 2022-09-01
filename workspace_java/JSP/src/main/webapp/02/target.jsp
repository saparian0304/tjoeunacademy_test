<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("target");
out.println("dkdkdkdkdk");
// request에 있는 name 출력
out.print(request.getAttribute("name"));
//session에 저장
out.print(session.getAttribute("id"));
%>

</body>
</html>