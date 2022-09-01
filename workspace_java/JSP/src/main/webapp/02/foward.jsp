<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//request에 저장
request.setAttribute("name", "홍길동");

System.out.println("포워드 : senRedirect1");
%>
<jsp:forward page="target.jsp"></jsp:forward>
<%
System.out.println("포워드 : senRedirect2");

%>
포워드