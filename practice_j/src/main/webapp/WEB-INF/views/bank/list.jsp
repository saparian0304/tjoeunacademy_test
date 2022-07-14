<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>사파리 은행 계좌리스트</h1>
<body>
	<table border="1">
		<tr>
			<th>계좌번호</th>
			<th>예금주</th>
			<th>잔고</th>
		</tr>
	<c:forEach items="${map.list}" var="account">
		<tr>
			<td>${account.accountNum}</td>
			<td><a href="/ajp/bank/get.do?accountNum=${account.accountNum}&holder=${account.holder}">${account.holder }</td>
			<td>${account.balance}</td>
		</tr>
	</c:forEach>
		</tr>
	</table>
	
	<button type="button" name="open" onclick="location.href='/ajp/bank/open.do'">생성</button>
	<button type="button" name="deposit">입금</button>
	<button type="button" name="withdraw">출금</button>
</body>
</html>