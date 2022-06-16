<%@ page import="el.MyELClass" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MyELClass myClass = new MyELClass();
pageContext.setAttribute("myClass", myClass);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어(EL) - 메서드 호출</title>
</head>
<body>
	<h3>영역에 저장 후 메서드 호출하기</h3>
	<!-- 영역에 저장된 객체의 메서드를 호출 (객체를 생성 후 영역에 저장) -->
	001225-1000000 => ${ myClass.getGender("001225-1000000") }<br>
	001225-4000000 => ${ myClass.getGender("001225-4000000") }
	
	<h3>클래스명을 통해 정적 메서드 호출하기</h3>
	<!--  static 메서드이기때문에 객체생성 및 저장 없이 바로 사용 -->
	${ MyELClass.showGugudan(7) }
</body>
</html>