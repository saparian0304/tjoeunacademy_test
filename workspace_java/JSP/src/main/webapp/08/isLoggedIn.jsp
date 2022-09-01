<%@ page import="utils.JSFunction" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if (session.getAttribute("UserSess")==null) {
	//JSFunction.alertLocation("로그인 후 이용해주십시오.", "/web/06/loginForm.jsp");
	out.print(JSFunction.alertLocation("로그인 후 이용해주십시오.", "/web/06/loginForm.jsp"));
	return;
	// 리턴하면 아래에 있는 코드들이 실행되지 않음
	// 실제로 JSP서비스 코드들이 들어있음.
	// 이 코드들을 실행하지 않음.
}
%>