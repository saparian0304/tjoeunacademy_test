package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/index.do")
public class listController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UserDAO dao = new UserDAO();
		request.setAttribute("list", dao.list());
		
		request.getRequestDispatcher("/WEB-INF/view/user/list.jsp").forward(request, response);
	}
}
