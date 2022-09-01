<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// requset에 저장
request.setAttribute("name", "홍길동");

System.out.println("인클루드 : senRedirect1");
%>
<%@ include file="target.jsp" %>
<%

System.out.println("인클루드 : senRedirect2");

%>
인클루드