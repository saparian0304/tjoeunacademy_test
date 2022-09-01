<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>empList</h2>
<table border="1">
	<tr>
		<th>empno</th>
		<th>ename</th>
		<th>job</th>
		<th>mgr</th>
		<th>hiredate</th>
		<th>sal</th>
		<th>comm</th>
		<th>deptno</th>
	</tr>
<c:forEach items="${map.empList }" var="vo">
	<tr>
		<td>${vo.empno }</td>
		<td>${vo.ename }</td>
		<td>${vo.job }</td>
		<td>${vo.mgr }</td>
		<td>${vo.hiredate }</td>
		<td>${vo.sal }</td>
		<td>${vo.comm }</td>
		<td>${vo.deptno }</td>
	</tr>
</c:forEach>
</table>

</body>
</html>