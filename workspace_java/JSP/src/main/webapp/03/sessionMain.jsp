<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<String> lists = new ArrayList<String>();
	lists.add("리스트");
	lists.add("컬렉션");
	// session 객체에 lists 담기
	session.setAttribute("lists", lists);
	// request 객체에 lists 담기
	request.setAttribute("lists", lists);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>페이지 이동 후 session 영역의 속성 영역 읽기</h2>
	<a href="sessionLocation.jsp">sessionLocation.jsp 바로가기</a>
	<h2>request 영역에 담은 lists 속성 출력</h2>
	<%=request.getAttribute("lists") %>
</body>
</html>