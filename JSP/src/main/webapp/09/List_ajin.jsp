<%@page import="utils.BoardPage"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model1.board.BoardDAO_ajin"%>
<%@page import="model1.board.BoardDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
//서블릿에서 처리되는 코드
BoardDAO_ajin dao = new BoardDAO_ajin(application);

Map<String, Object> param = new HashMap<String, Object>();
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if (searchWord != null) { //검색을 한 경우.
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}
int totalCount = dao.selectCount(param);
//페이징 처리

//페이지당 로우 개수
int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
//블럭 당 페이지 개수
int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
//int totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수 
int totalPage = totalCount/pageSize; //총 페이지수 위와 같은 영향. but, 이게 더 직관적임. 쉽다.
if (totalCount % pageSize >0) totalPage++;


int pageNum = 1; //사용자가 페이지번호 요청하지 않은 경우 기본값
String pageTemp = request.getParameter("pageNum"); //요청페이지 번호.
if (pageTemp != null && !pageTemp.equals("")) { //사용자가 페이지 번호를 클릭 한 경우
	pageNum = Integer.parseInt(pageTemp);
}
//rownum between start and end
int start = (pageNum - 1) * pageSize + 1;  // rownum의 시작값
int end = pageNum * pageSize; // rownum의 끝값
//if (end > totalCount) end = totalCount; 
param.put("start", start);
param.put("end", end);
List<BoardDTO> boardLists = dao.selectListPage(param);
dao.close();

request.setAttribute("totalCount",totalCount);
request.setAttribute("searchField",searchField);
request.setAttribute("searchWord",searchWord);
request.setAttribute("boardLists",boardLists);
request.setAttribute("pageNum",pageNum);
System.out.println(start);
System.out.println(end);
//서블릿에서 처리되는 코드
%>
<title>회원제 게시판</title>
</head>
<body>
	
	<h2>목록 보기(List) - 현재 페이지 : <%= pageNum %> (전체 : <%= totalPage %>)</h2>
	<!-- 검색 폼 -->
	<form method="get">
		<table border="1" width="90%">
			<tr>
				<td align="center">
				<select name="searchField">
	
						<option value="title"<c:if test="${searchField =='title'}">selected</c:if>>제목</option>
						<option value="content"<c:if test="${searchField =='content'}">selected</c:if>>내용</option>
						<option value="all"<c:if test="${param.searchField =='all'}">selected</c:if>>제목+내용</option>
				</select> 
				<input type="text" name="searchWord" /> 
				<input type="submit" value="검색하기" /></td>
			</tr>
		</table>
	</form>

	<!-- 게시물 목록 테이블(표) -->
	<table border="1" width="90%">
		<!-- 각 컬럼의 이름 -->
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
			<c:if test="${empty boardLists }">
		<tr>
		    
			<td colspan="5" align="center">등록된 게시물이 없습니다 ;)</td>
		</tr>
			</c:if>
	        <c:if test="${!empty boardLists }">
	
	        <c:forEach var = "board" items="${boardLists}" varStatus="status">
		<tr align="center">
			<td>${totalCount-status.index -(pageNum-1)*10}</td>
			<!-- 게시물 번호 -->
			<td align="left">
                 <a href="View.jsp?num=${board.num }">${board.title}</a>
			</td>
			<td align="center">${board.name }<c:out value="${board.name }"/></td>
			<td align="center">${board.visitcount }</td>
			<td align="center"><fmt:formatDate value="${board.postdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
   </c:forEach>
   </c:if>		    
	</table>
	<!-- 목록 하단의 [글쓰기] 버튼-->
	<table border="1" width="90%">
		<tr align="center">
		<td>
		    <%= BoardPage.pagingStr(totalCount, pageSize, blockPage,
		    		pageNum, request.getRequestURI()) %>
		</td>
			<td><button type="button" onclick="location.href='Write.jsp';">글쓰기
				</button></td>
		</tr>
		</table>
</body>
</html>