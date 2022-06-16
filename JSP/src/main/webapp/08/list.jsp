<%@ page import="java.util.*" %>
<%@ page import="model1.board.*" %>
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

int totalCount = dao.selectCount(param);
List<BoardDTO> boardLists = dao.selectList(param);
dao.close();

String pageSize = application.getInitParameter("POSTS_PER_PAGE");
String blockSize = application.getInitParameter("PAGES_PER_BLOCK");

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

<c:if test="${ empty boardLists }">
		<tr>
			<td colspan="5" align="center">
				등록된 게시물이 없다.
			</td>
		</tr>
</c:if>
<c:if test="${!empty boardLists }">
	<c:forEach var="board" items="${ boardLists}" varStatus="status">
		<tr align="center">
			<td>${totalCount - status.index}</td>
			<td align="left">
				<a href="view.jsp?num=${board.num }">${board.title }</a>
			</td>
			<td align="center">${board.name }</td>
			<td align="center">${board.visitcount }</td>
			<td align="center"><fmt:formatDate value="${board.postdate }" pattern="yyyy년 MM월 dd일"/></td>
		</tr>
	</c:forEach>
</c:if>
	</table>
	<!-- 목록 하단의 [글쓰기] 버튼 -->
	<table border="1" width="90%">
		<tr align="right">
			<td>
				<button type="button" onclick="location.href='write.jsp';">글쓰기
				</button>
			</td>
		</tr>
	</table>
</body>
</html>