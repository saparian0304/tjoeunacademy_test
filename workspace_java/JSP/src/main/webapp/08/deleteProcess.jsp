<%@ page import="model1.board.*" %>
<%@ page import="membership.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/08/isLoggedIn.jsp" %>
<%
String num = request.getParameter("num");	// 일련번호 얻기

BoardDTO dto = new BoardDTO();
BoardDAO dao = new BoardDAO(application);
// 주어진 일련번호에 해당하는 기존 게시물 얻기
dto = dao.selectView(num);

// 로그인된 사용자 ID 얻기
String sessionId = ((MemberDTO)session.getAttribute("UserSess")).getId();

int delResult = 0;

// 작성자가 본인인지 확인
if (sessionId.equals(dto.getId())) {
	dto.setNum(num);
	delResult = dao.deletePost(dto);
	dao.close();
	
	if (delResult == 1) {
		out.print(JSFunction.alertLocation("삭제되었습니다.", "list.jsp"));
	} else {
		JSFunction.alertBack("삭제에 실패하였습니다.", out);
	}
}
else {
	JSFunction.alertBack("본인만 삭제할 수 있습니다.", out);
}
%>