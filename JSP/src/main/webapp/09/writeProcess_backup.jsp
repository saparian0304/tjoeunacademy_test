<%@ page import="model1.board.*" %>
<%@ page import="membership.MemberDTO" %>

<%@ page import="fileupload.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./isLoggedIn.jsp" %>

<%

String saveDirectory = application.getRealPath("/uploads");  // 서버에 저장될 경로
System.out.println("saveDirectory: " + saveDirectory);
int maxPostSize = 1024 * 1000; // 파일 최대크기 1024byte(1kb) * 1024 = 1mb
String encoding = "UTF-8";

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
	response.sendRedirect("/web/09/list.jsp");
} else {
	JSFunction.alertBack("글쓰기에 실패하셨습니다.", out);
}
%>