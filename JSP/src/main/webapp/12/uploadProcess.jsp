<%@ page import="fileupload.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	String[] cateArray = mr.getParameterValues("cate");	// 카테고리
	StringBuffer cateBuf = new StringBuffer();
	if (cateArray == null) {
		cateBuf.append("선택 없음");
	}
	else {
		for (String s : cateArray) {
			cateBuf.append(s + ",");
		}
	}
	
	// 5. DTO 생성
	MyfileDTO dto = new MyfileDTO();
	dto.setName(name);
	dto.setTitle(title);
	dto.setCate(cateBuf.toString()); 	// Cate가 String 타입이기때문에 cateBuf를 형변환해줌
	dto.setOfile(fileName);
	dto.setSfile(newFileName);
	
	// 6. DAO를 통해 데이터베이스에 반영
	MyfileDAO dao = new MyfileDAO();
	dao.insertFile(dto);
	dao.close();
	
	// 7. 파일 목록 JSP로 리다이렉션
	response.sendRedirect("fileList.jsp");
}
catch (Exception e) {
	e.printStackTrace();
	request.setAttribute("errorMessage", "파일 업로드 오류");
	request.getRequestDispatcher("fileUploadMain.jsp").forward(request, response);
}

%>