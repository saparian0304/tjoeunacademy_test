<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>게시판 - ${data.title }</title>
    <link rel="stylesheet" href="/project/css/reset.css"/>
    <link rel="stylesheet" href="/project/css/contents.css"/>
    <script>
    	function del(no) {
    		if (confirm("삭제하시겠습니까?")) {
    			location.href='delete.do?no='+no;
    		}
    	}
    </script>
</head>
<body>
    
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">게시판</h3>
                <div class="bbs">
                    <div class="view">
                        <div class="title">
                            <dl>
                                <dt>${data.title } </dt>
                                <dd class="date">작성일 : <fmt:formatDate value="${data.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
                            </dl>
                        </div>
                        <div class="cont"><p>${data.content }</p> </div>
                        <dl class="file">
                            <dt>첨부파일 </dt>
                            <dd>
                            <a href="/project/common/download.jsp?oName=${URLEncoder.encode(data.filename_org, "UTF-8")}&sName=${data.filename_real}">${data.filename_org }</a></dd>
                        </dl>
                                    
                        <div class="btnSet clear">
                            <div class="fl_l">
	                            <a href="index.do?no=${data.no }" class="btn">목록으로</a>
	                            <a href="edit.do?no=${data.no }" class="btn">수정</a>
	                            <a href="javascript:del(${data.no })" class="btn">삭제</a>
                            </div>
                        </div>
                
                    </div>
                </div>
            </div>
        </div>
        
</body>
</html>