<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1" width="90%">
	<tr>
		<td align="center">
		<!-- 로그인 여부에 따른 메뉴 변화 -->
		<c:if test="${empty UserSess }">
			<a href="<c:url value="/06/loginForm.jsp"/>">로그인</a>
		</c:if>
		<c:if test="${!empty UserSess }">
			<a href="<c:url value="/06/logout.jsp"/>">로그아웃</a>
		</c:if>
		
			<!-- 8장과 9장의 회원제 게시판 프로젝트에서 사용할 링크 -->
			&nbsp;&nbsp;&nbsp; <!-- 메뉴 사이의 공백 확보용 특수문자 -->
			<a href="<c:url value="/08/list.jsp"/>">게시판(페이징X)</a>
			&nbsp;&nbsp;&nbsp;
			<a href="<c:url value="/09/list.jsp"/>">게시판(페이징O)</a>
			&nbsp;&nbsp;&nbsp;
			<a href="<c:url value="/12/fileList_EL,JSTL.jsp"/>">파일업로드</a>
		</td>
	</tr>
</table>