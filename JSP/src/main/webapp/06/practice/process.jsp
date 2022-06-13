<%@ page import="practice.DBConnect" %>
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
	
	String uid = request.getParameter("user_id");
	String upass = request.getParameter("user_pw");
	DBConnect jdbc = new DBConnect();
	// DB 연결하기
	
	
	// 맞으면 로그인에 성공했습니다.
	// 틀리면 로그인에 실패했습니다.

	
	%>
</body>
</html>