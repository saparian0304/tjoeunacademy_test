<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		alert('${vo.msg}');
		if ('${vo.go}' != null && '${vo.go}' != ''){
			location.href='/ajp/bank/${vo.go}.do?accountNum=${vo.accountNum}&holder=${vo.holder}';
		} else {
			location.href='/ajp/bank/${vo.go}.do';
		}
	})
</script>
</head>
<body>
</body>
</html>