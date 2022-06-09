<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*" %>

<%
LocalDate today = LocalDate.now();
LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
// type이 1이면 today를 2이면 tomorrow를 출력
if ("1".equals(request.getParameter("type"))){
// if (request.getParameter("type").equals("1")){  
// parameter가 지정이 안될경우 null값이기 때문에 에러가 남
	out.println(today);
} else {
	out.println(tomorrow);
}
%>