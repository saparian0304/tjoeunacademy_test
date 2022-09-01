package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int userno = Integer.parseInt(request.getParameter("userno"));
		
		UserDAO dao = new UserDAO();
		request.setAttribute("user", dao.view(userno));
		request.setAttribute("hobbyList", dao.hobbyList(userno));
		request.getRequestDispatcher("/WEB-INF/view/user/view.jsp").forward(request, response);
	}
}
