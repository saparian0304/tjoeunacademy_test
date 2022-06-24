package model2.mvcboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcboard/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String idx = req.getParameter("f_idx");
		
		AddfileDAO dao = new AddfileDAO();
		dao.deleteFile(Integer.parseInt(idx));
			
		req.getRequestDispatcher("/14/edit.jsp").forward(req, resp);
		
	}
}
