<%@page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 실제 파일이 저장된 경로와 파라미터로 받은 파일명(원본, 저장) 변수에 저장
String saveDirectory = application.getRealPath("/uploads");
String saveFilename = request.getParameter("sName");
String originalFilename = request.getParameter("oName");

try {
	// 경로와 서버의 파일명으로 File 객체 생성
	// 입력 스트림 객체를 생성
	
	// 한글 파일명 깨짐 방지
	// 헤더로부터 브라우저 정보를 받아서 변수에 저장
	// 헤더에 브라우저별 포맷형식에 따라 인코딩방식 수정
	
	// 파일 다운로드용 응답헤더 설정 (브라우저 헤더 정보 저장)
} catch (Exception e) {
	JSFunction.alertBack("예외가 발생하였습니다.",	out);
}
%>