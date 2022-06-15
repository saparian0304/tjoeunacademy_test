<%@ page import="model1.board.BoardDAO" %>
<%@ page import="model1.board.BoardDTO" %>
<%@ page import="membership.MemberDTO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String num = request.getParameter("num");

BoardDAO dao = new BoardDAO(application);
dao.updateVisitCount(num);
BoardDTO dto = dao.selectView(num);
dao.close();

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
<script>
	function deletePost() {
		// confirm(String str) : 확인,취소를 선택할 수 있는 경고창 생성
		var confirmed = confirm("정말로 삭제하겠습니까?");	
		if (confirmed) {
			var form = document.writeFrm;	// 이름(name)이 "writeFrm"인 form 선택
			form.method = "post";			// 전송방식
			form.action = "deleteProcess.jsp";	// 전송경로
			form.submit();					// form 값 전송
		}
	}
</script>
</head>
<body>
	<jsp:include page="/common/link.jsp"></jsp:include>
	<h2>회원제 게시판 - 상세보기(View)</h2>
	<form name="writeFrm">
		<input type="hidden" name="num" value="<%=num %>">
		<table border="1" width="90%">
			<tr>
				<td>번호</td>
				<td><%=dto.getNum() %></td>
				<td>작성자</td>
				<td><%=dto.getName() %></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=dto.getPostdate() %></td>
				<td>조회수</td>
				<td><%=dto.getVisitcount() %></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><%=dto.getTitle() %></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3" height="100">
					<%=dto.getContent().replace("\r\n", "<br>") %></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<%
					
					if (session.getAttribute("UserSess")!=null
						&& ((MemberDTO)(session.getAttribute("UserSess"))).getId().equals(dto.getId())) {
					%>
					<button type="button" onclick="location.href='edit.jsp?num=<%=dto.getNum() %>';">
						수정하기</button>
					<button type="button" onclick="deletePost();">삭제하기</button>					
					<%
					}
					%>
					<button type="button" onclick="location.href='list.jsp';">
						목록보기
					</button>
				</td>	
			</tr>
		</table>
	</form>
</body>
</html>