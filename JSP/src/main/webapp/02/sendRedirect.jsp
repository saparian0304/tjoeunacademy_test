<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// request에 저장
request.setAttribute("name", "홍길동");

// session에 저장
session.setAttribute("id", "hong");

System.out.println("샌드 리다이렉트 : senRedirect1");
response.sendRedirect("target.jsp");

for(int i=0; i<900000; i++) {
	out.println(i);
	System.out.println(i);
}

System.out.println("샌드 리다이렉트 : senRedirect2");

%>
샌드리다이렉트