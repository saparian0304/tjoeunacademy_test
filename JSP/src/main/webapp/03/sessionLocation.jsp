<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>페이지 이동 후 session 영역의 속성 읽기</h2>
	<%
	ArrayList<String> lists = (ArrayList<String>)session.getAttribute("lists");
	for (String str : lists) {
		out.print(str + "<br>");
	}
	%>
	<h2>페이지 이동 후 request 영역에 담긴 속성 읽기</h2>
	<p>새로운 request 객체가 생성되기때문에 이전에 넣은 속성은 존재하지 않음</p>
	<%
	ArrayList<String> lists1 = (ArrayList<String>)request.getAttribute("lists");
	out.print("request 객체의 \"lists\"속성 값: "+lists1);
	%>
</body>
</html>