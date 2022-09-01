<%@ page import="model1.board.*" %>
<%@ page import="membership.MemberDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="fileupload.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./isLoggedIn.jsp" %>

<%

String saveDirectory = application.getRealPath("/uploads");  // 서버에 저장될 경로
System.out.println("saveDirectory: " + saveDirectory);
int maxPostSize = 1024 * 1000; // 파일 최대크기 1024byte(1kb) * 1024 = 1mb
String encoding = "UTF-8";

try {
	// 1. MultipartRequest 객체 생성 -> 생성한 순간 서버에 저장됨
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
	
	// 2. 새로운 파일명 생성
	String fileName = mr.getFilesystemName("attachedFile");			// 첨부파일명
	String ext = fileName.substring(fileName.lastIndexOf("."));
	String now = new SimpleDateFormat("yyyyMMDD_HmsS").format(new Date());
	String newFileName = now + ext;
	
	System.out.println("fileName: " + fileName);
	System.out.println("newFileName: " + newFileName);
	// 3. 파일명 변경
	File oldFile = new File(saveDirectory + File.separator + fileName);		// separater : 윈도우 - "/" 리눅스 = "\"
	File newFile = new File(saveDirectory + File.separator + newFileName);
	oldFile.renameTo(newFile);	// 서버에 저장된 파일 이름 변경

	// 4. 다른 폼값 받기
		String name = mr.getParameter("name");				// 작성자
		String title = mr.getParameter("title");			// 제목	
		String content = mr.getParameter("content");
	
		// 폼값 받기

		// 폼값을 DTO 객체에 저장
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setOfile(fileName);
		dto.setSfile(newFileName);
		
		System.out.print(((MemberDTO)(session.getAttribute("UserSess"))).getId());
		dto.setId(((MemberDTO)(session.getAttribute("UserSess"))).getId());


		// DAO 객체를 통해 DB에 DTO 저장
		BoardDAO dao = new BoardDAO(application);
		int iResult = dao.insertWriter(dto);


		dao.close();

		// 성공 or 실패?
		if (iResult == 1) {
			response.sendRedirect("/web/09/list.jsp");
		} else {
			JSFunction.alertBack("글쓰기에 실패하셨습니다.", out);
		}
	
}
catch (Exception e) {
	e.printStackTrace();
	request.setAttribute("errorMessage", "파일 업로드 오류");

	JSFunction.alertBack("글쓰기에 실패하셨습니다.", out);
}
	
	
%>