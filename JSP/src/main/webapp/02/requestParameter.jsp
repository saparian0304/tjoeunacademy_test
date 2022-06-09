<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
	<%
	// 한글 깨짐문제를 해결하는 코드
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String sex = request.getParameter("sex");
	String[] favo = request.getParameterValues("favo");
	String favoStr = "";
	if (favo != null) {
		for (int i=0; i<favo.length; i++) {
			favoStr += favo[i] + " ";
		}
	}
	// textarea에서 줄바꿈 된것은 \r\n으로 표현됨
	// 줄바꿈된대로 나오게 하려고 replace를 사용함
	String intro = request.getParameter("intro").replace("\r\n", "<br>");
	%>
	<ul>
		<li>아이디 : <%=id %></li>
		<li>성별 : <%=sex %></li>
		<li>관심사항 : <%=favoStr %></li>
		<li>자기소개 : <%=intro %></li>
	</ul>
</body>
</html>