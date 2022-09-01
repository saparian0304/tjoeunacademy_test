<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 첨부형 게시판</title>
</head>
<body>
	<h2>파일 첨부형 게시판 - 상세보기(view)</h2>
	
	<table border="1" width="90%">
		<colgroup>
			<col width="15%"/> <col width="35%"/>
			<col width="15%"/> <col width="*"/>
		</colgroup>
		
		<tr>
			<td>번호</td> <td>${dto.idx }</td>
			<td>작성자</td><td>${dto.name }</td>
		</tr>
		<tr>
			<td>작성일</td><td>${dto.postdate }</td>
			<td>조회수</td><td>${dto.visitcount }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${dto.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3" height="100">${dto.content }</td>
		</tr>
	<c:if test="${empty fileList }">
		<tr>
			<td>첨부파일</td>
			<td colspan="3">첨부된 파일이 존재하지 않습니다.</td>
		</tr>	
	</c:if>
	<c:forEach var="file" items="${fileList }" varStatus="status">
		<tr>
			<td>첨부파일${status.index }</td>
			<td colspan="3">${file.ofile } <a href="../mvcboard/download.do?ofile=${dto.ofile }&sfile=${dto.sfile}&idx=${dto.idx}">
				[다운로드]
				</a>
			</td>
		</tr>	
	</c:forEach>
		
		<tr>
			<td colspan="4" align="center">
				<button type="button" onclick="location.href='../mvcboard/pass.do?mode=edit&idx=${param.idx}';">
				수정하기
				</button>
				<button type="button" onclick="location.href='../mvcboard/pass.do?mode=delete&idx=${param.idx}';">
				삭제하기
				</button>
				<button type="button" onclick="location.href='../mvcboard/list.do';">
				목록 바로가기
				</button>
			</td>
		</tr>
	</table>
</body>
</html>