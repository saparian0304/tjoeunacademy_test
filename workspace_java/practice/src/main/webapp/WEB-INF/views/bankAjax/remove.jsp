<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>계좌 삭제</h2>
<form>
	계좌번호 : <input type="text" name="accountNum">  <button type="button">예금주 확인</button><br>
	예금주 : <input type="text" name="holder" readonly="readonly"> <br>
	계좌 잔액 : <input type="text" name="balance" readonly="readonly"> <br>
	<button type="button">삭제</button>
</form>