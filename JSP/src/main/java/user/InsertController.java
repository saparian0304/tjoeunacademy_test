package user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/insert.do")
public class InsertController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String[] hobby = req.getParameterValues("hobby");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(tel);
		//System.out.println(hobby);
		
		UserDAO dao = new UserDAO();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("email", email);
		map.put("tel", tel);
		int userno = 0;
		try {
			userno = dao.insert(map);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("userno = " + userno);
		
		
		if (hobby != null && userno > 0) {
			for (int i=0; i<hobby.length; i++) {
//				System.out.println(hobby[i]);
				dao.insertHobby(userno, hobby[i]);
			}
		}
	}
}
