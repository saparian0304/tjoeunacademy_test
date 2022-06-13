<%@ page import="membership.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/link.jsp"></jsp:include>
	<h2>로그인 페이지</h2>
	<span style="color: red; font-size: 1.2em;">
		<%= request.getAttribute("LoginErrMsg") == null ? 
				"" : request.getAttribute("LoginErrMsg")
		%>
	</span>
	<%
	
	if (session.getAttribute("UserSess") == null) {
		
	%>
	
	<script>
	function validateForm(form) {
		if (!form.user_id.value) {
			alert("아이디를 입력하세요.");
			return false;
		} 
		if (form.user_pw.value == "") {
			alert("패스워드를 입력하세요") ;
			return false;
		}
	}
	</script>
	<form action="loginProcess.jsp" method="post" name="loginFrm"
		onsubmit="return validateForm(this);">
		아이디 : <input type="text" name="user_id" /><br>
		패스워드 : <input type="password" name="user_pw" > <br>
		<input type="submit" value="로그인 하기">
	</form>
	<%
	} else {
	%>
		<%= ((MemberDTO)(session.getAttribute("UserSess"))).getId() %> 회원님, 로그인하셨습니다. <br>
		<a href="logout.jsp">[로그아웃]</a>
	<%
	}
	%>
</body>
</html>