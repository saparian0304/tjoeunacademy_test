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
<h2>거래 내역</h2>
<table border="1">
	<tr>
		<th>계좌번호</th>
		<th>예금주</th>
		<th>입금</th>
		<th>출금</th>
		<th>잔고</th>
		<th>거래일자</th>
	</tr>
<c:forEach items="${list}" var="vo">
	<tr>
		<td>${vo.accountNum }</td>
		<td>${vo.holder }</td>
		<td>${vo.deposit }</td>
		<td>${vo.withdraw }</td>
		<td>${vo.balance }</td>
		<td>${vo.updatedate }</td>
	</tr>
</c:forEach>
</table>
<button type="button" name="deposit" onclick="location.href='/ajp/bank/deposit.do?accountNum=${vo.accountNum}&holder=${vo.holder }'">입금</button>
<button type="button" name="withdraw" onclick="location.href='/ajp/bank/withdraw.do?accountNum=${vo.accountNum}&holder=${vo.holder }'">출금</button>
<button type="submit" onclick="location.href='/ajp/bank/remove.do?accountNum=${vo.accountNum}'">계좌 삭제</button>
<button onclick="location.href='/ajp/bank/list.do'">계좌 리스트</button>

</body>
</html>