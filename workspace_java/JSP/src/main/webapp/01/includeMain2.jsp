<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includeFile.jsp">
	<jsp:param value="1" name="type"></jsp:param>
</jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <br>액션태그 이용하기 jsp:include page="includeFile.jsp"
<br><br><br>
<%
/*
out.println("오늘 날짜: " + today);
out.println("<br>");
out.println("내일 날짜: " + tomorrow);
*/
%>
<%-- 
<script>
	 alert('<%=tomorrow%> '); 
</script>
--%>
</body>
</html>