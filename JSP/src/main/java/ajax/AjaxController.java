package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/Ajax_parctice.do")
public class AjaxController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
			System.out.println(req.getParameter("color"));
	}
	
	
}
