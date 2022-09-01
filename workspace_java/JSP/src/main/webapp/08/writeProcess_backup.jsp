<%@ page import="model1.board.*" %>
<%@ page import="membership.MemberDTO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./isLoggedIn.jsp" %>

<%
// 폼값 받기
String title = request.getParameter("title");
String content = request.getParameter("content");

// 폼값을 DTO 객체에 저장
BoardDTO dto = new BoardDTO();
dto.setTitle(title);
dto.setContent(content);
System.out.print(((MemberDTO)(session.getAttribute("UserSess"))).getId());
dto.setId(((MemberDTO)(session.getAttribute("UserSess"))).getId());

// DAO 객체를 통해 DB에 DTO 저장
BoardDAO dao = new BoardDAO(application);
int iResult = dao.insertWriter(dto);
dao.close();

// 성공 or 실패?
if (iResult == 1) {
	response.sendRedirect("list.jsp");
} else {
	JSFunction.alertBack("글쓰기에 실패하셨습니다.", out);
}
%>