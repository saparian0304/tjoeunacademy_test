<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>게시판목록</title>
    <link rel="stylesheet" href="/project/css/reset.css"/>
    <link rel="stylesheet" href="/project/css/contents.css"/>
</head>
<body>
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">게시판</h3>
    
                <div class="bbs">
                    <table class="list">
                    <p><span><strong>총 ${data.totalCount }개</strong>  |  ${data.page }/${data.totalPage }페이지</span></p>
                        <caption>게시판 목록</caption>
                        <colgroup>
                            <col width="80px" />
                            <col width="*" />
                            <col width="100px" />
                            <col width="100px" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:if test="${empty data.list }">
                            <tr>
                                <td class="first" colspan="8">등록된 글이 없습니다.</td>
                            </tr>
                        </c:if>
							
						<c:forEach items="${data.list }" var="vo">
							<tr>
                                <td>${vo.no }</td>
                                <td class="txt_l">
                                    <a href="board_view.html">${vo.title }</a>
                                </td>
                                <td class="writer">
                                    ${vo.member_no}
                                </td>
                                <td class="date">${vo.regdate }</td>
                            </tr>
						</c:forEach>
                                    
                        </tbody>
                    </table>
                    <div class="btnSet"  style="text-align:right;">
                        <a class="btn" href="board_write.html">글작성 </a>
                    </div>
                    <div class="pagenate clear">
                        <ul class='paging'>
                        
                        <c:if test="${data.paging.prev }">
							<li class="paginate_button previous"><a href="/project/board/index.do?page=${data.paging.startPage -1}">Previous</a>
						</c:if>
                        
                        <c:forEach var="idx" begin="${data.paging.startPage }" end="${data.paging.endPage }">
                        	<li><a href="/project/board/index.do?page=${idx }" class="${idx == data.page ? 'current' : '' }">${idx }</a></li>
                        </c:forEach>
                        
                        <c:if test="${data.paging.next }">
							<li class="paginate_button next"><a href="/project/board/index.do?page=${data.paging.endPage +1}">Next</a>
						</c:if>
                        </ul> 
                    </div>
                
                    <!-- 페이지처리 -->
                    <div class="bbsSearch">
                        <form method="get" name="searchForm" id="searchForm" action="">
                            <span class="srchSelect">
                                <select id="stype" name="stype" class="dSelect" title="검색분류 선택">
                                    <option value="all">전체</option>
                                    <option value="title">제목</option>
                                    <option value="contents">내용</option>
                                </select>
                            </span>
                            <span class="searchWord">
                                <input type="text" id="sword" name="sword" value=""  title="검색어 입력">
                                <input type="button" id="" value="검색" title="검색">
                            </span>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
        
</body>
</html>