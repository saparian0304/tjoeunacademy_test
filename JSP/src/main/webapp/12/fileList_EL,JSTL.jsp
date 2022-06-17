<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.List" %>
<%@ page import="fileupload.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/common/link.jsp"/>
<html>
<head>
<meta charset="UTF-8">
<title>FileUPload</title>
</head>
<body>
	<h2>DB에 등록된 파일 목록 보기</h2>
	<a href="fileUploadMain.jsp">파일 등록하기</a>
	<%
	MyfileDAO dao = new MyfileDAO();
	List<MyfileDTO> fileLists = dao.myFileList();
	request.setAttribute("fileLists", fileLists);
	dao.close();
	
	%>
	<table border="1">
		<tr>
			<th>No</th>
			<th>작성자</th>
			<th>제목</th>
			<th>카테고리</th>
			<th>원본 파일명</th>
			<th>저장된 파일명</th>
			<th>작성일</th>
		</tr>
	
	<c:forEach var="f" items="${fileLists }">
		<tr>
			<td>${f.idx}</td>
			<td>${f.name }</td>
			<td>${f.title }</td>
			<td>${f.cate }</td>
			<td>${f.ofile }</td>
			<td>${f.sfile }</td>
			<td>${f.postdate }</td>
			<td>
				<img src="<c:url value="/uploads/${f.sfile }"/>" width="100px">
			</td>
			<td>
				<a href="download.jsp?oName=${URLEncoder.encode(f.ofile, "UTF-8")}&sName=${URLEncoder.encode(f.sfile, "UTF-8")}">[다운로드]</a>
			</td>
			
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>