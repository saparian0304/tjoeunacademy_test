<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./isLoggedIn.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
<script type="text/javascript">
function validateForm(form) {
	if (form.title.value == "" ) {
		alert("제목을 입력하세요.");
		form.title.focus();
		return false;
	}
	if (form.content.value =="") {
		alert("내용을 입력하세요.");
		form.content.focus();
		return false;
	}
}
</script>
</head>
<body>
<jsp:include page="/common/link.jsp"/>
	<h2>회원제 게시판 - 글쓰기</h2>
	<form name="writeFrm" method="post" action="writeProcess.jsp" enctype="multipart/form-data"
		onsubmit="return validateForm(this);">
		<table border="1" width="90%">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" style="width: 90%;">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" style="width: 90%; height: 100px;" placeholder="내용을 입력하세요" ></textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="attachedFile">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성완료</button>
					<button type="reset">다시 입력</button>
					<button type="button" onclick="location.href='list.jsp';">목록보기</button>
			</tr>
		</table>
		
		
	</form>
</body>
</html>