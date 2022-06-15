<%@page import="utils.JSFunction"%>
<%@ page import="model1.board.*" %>
<%@ page import="membership.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./isLoggedIn.jsp" %>

<%
String num = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");
System.out.print(num);
System.out.print(title);
System.out.print(content);

BoardDTO dto = new BoardDTO();
dto.setNum(num);
dto.setTitle(title);
dto.setContent(content);
BoardDAO dao = new BoardDAO(application);
int affected = dao.updateEdit(dto);
dao.close();

if (affected == 1) {
	response.sendRedirect("view.jsp?num=" + dto.getNum());
} 
else {
	JSFunction.alertBack("수정하기에 실패하였습니다.", out);
}

%>
