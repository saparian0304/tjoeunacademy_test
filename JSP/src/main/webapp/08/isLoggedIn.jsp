<%@ page import="utils.JSFunction" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if (session.getAttribute("UserSess")==null) {
	//JSFunction.alertLocation("로그인 후 이용해주십시오.", "/web/06/loginForm.jsp");
	out.print(JSFunction.alertLocation("로그인 후 이용해주십시오.", "/web/06/loginForm.jsp"));
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>