<%@ page import="java.util.*" %>
<%@ page import="model1.board.*" %>
<%@ page import="utils.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
/***********************서블릿에서 보내주는 코드***************************/
// DAO를 생성해서 DB에 연결
BoardDAO dao = new BoardDAO(application);

// 사용자가 입력한 검색 조건을 Map에 저장
Map<String, Object> param = new HashMap<String, Object>();
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if (searchWord != null) {
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}

int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
int blockSize = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));

int pageNum = 1;
String pageTemp = request.getParameter("pageNum");	// 요청 페이지 번호
if (pageTemp != null && !pageTemp.equals(""))
	pageNum = Integer.parseInt(pageTemp);

int totalCount = dao.selectCount(param);

int start = (pageNum - 1) * pageSize +1;	// rownum의 시작값
int end = pageNum * pageSize;				// rownum의 끝값

param.put("start", start);
param.put("end", end);

List<BoardDTO> boardLists = dao.selectListPage(param);
dao.close();





/***********************서블릿에서 보내주는 코드***************************/
request.setAttribute("totalCount", totalCount);
request.setAttribute("boardLists", boardLists);

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/link.jsp"></jsp:include>
	<h2>목록 보기(List)</h2>
	<!--  검색 폼 -->
	<form method="get">
	<table border="1" width="90%">
		<tr>
			<td align="center">
				<select name="searchField">
					<option value="titlecontent" <c:if test="${param.searchField =='titlecontent' }">selected</c:if>>제목+내용</option>
					<option value="title" <c:if test="${param.searchField == 'title'}">selected</c:if>>제목</option>
					<option value="content" <c:if test="${ param.searchField == 'content' }">selected</c:if>>내용</option>
				</select>
				<input type="text" name="searchWord" value="${param.searchWord }">
				<input type="submit" value="검색하기">
			</td>
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
		<!-- 목록의 내용 -->

<c:if test="${empty boardLists }">
		<tr>
			<td colspan="5" align="center">
				등록된 게시물이 없다.
			</td>
		</tr>
</c:if>
<c:if test="${!empty boardLists }"> 
<c:forEach var="board" items="${boardLists }" varStatus="status">
<c:set var="sumVisit" value="${sumVisit + board.visitcount }"/>
		<tr align="center">
			<td>${totalCount - status.index -(pageNum-1)*10}</td>
			<td align="left">
				<a href="view.jsp?num=${board.num }">${board.title }</a>
			</td>
			<td align="center">${board.id }</td>
			<td align="center">${board.visitcount }</td>
			<td align="center">
				<fmt:formatDate value="${board.postdate }" pattern="yyyy년 MM월 dd일"/>
			</td>
		</tr>
</c:forEach>
</c:if>
	</table>
	<!-- 목록 하단의 [글쓰기] 버튼 -->
<%
String uri = request.getRequestURI() +"?";
if (request.getParameter("searchWord") !=null)
	uri += "searchField="  + request.getParameter("searchField") 
			+ "&searchWord=" + request.getParameter("searchWord");
%>
	<table border="1" width="90%">
		<tr align="center">
			<!-- 페이징 처리 -->
			<td>
				<%=BoardPage.pagingStr(totalCount, pageSize, blockSize,
					pageNum, uri) %>
			</td>
			<!-- 글쓰기 버튼 -->
			<td>
				방문자 수 총합 : ${sumVisit }
				<button type="button" onclick="location.href='write.jsp';">글쓰기
				</button>
			</td>
		</tr>
	</table>
</body>
</html>