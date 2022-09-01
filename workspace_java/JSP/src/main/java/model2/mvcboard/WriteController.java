package model2.mvcboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import utils.JSFunction;

public class WriteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.getRequestDispatcher("/14/write.jsp").forward(req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String saveDirectory = req.getServletContext().getRealPath("/uploads");
		
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if (mr == null) {
			JSFunction.alertLocation(resp, "첨부파일이 제한 용량을 초과합니다.", 
					"../mvcboard/write.do");
			return;
		}
		
		MVCBoardDTO dto = new MVCBoardDTO();
		dto.setName(mr.getParameter("name"));
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		dto.setPass(mr.getParameter("pass"));
		
		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.insertWrite(dto);
		dao.close();
		
		if (result == 1) {

			Enumeration list = mr.getFileNames();
			
			while(list.hasMoreElements()) {
				String ofile =(String)list.nextElement();
				File f =mr.getFile(ofile);
				String fileName = f.getName();
				
				String now = new SimpleDateFormat("yyyyMMDD_HmsS").format(new Date());
				String ext = fileName.substring(fileName.lastIndexOf("."));
				String newFileName = now + ext;
				
				File oldFile = new File(saveDirectory + File.separator + fileName);
				File newFile = new File(saveDirectory + File.separator + newFileName);
				oldFile.renameTo(newFile);
				
				
				
				AddfileDAO fileDao = new AddfileDAO();
				AddFileDTO fileDto = new AddFileDTO();
				fileDto.setOfile(fileName);
				fileDto.setSfile(newFileName);
				result = fileDao.insertFile(fileDto);
			}
		}
		
				
		
		if (result == 1) {
			resp.sendRedirect("../mvcboard/list.do");
		}
		else {
			resp.sendRedirect("../mvcboard/write.do");
		}
	}
}
