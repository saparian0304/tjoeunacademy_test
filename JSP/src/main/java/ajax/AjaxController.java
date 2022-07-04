package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/ajax/Ajax_parctice.do")
public class AjaxController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		                       
//		res.setContentType("application/json;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		JSONObject json = new JSONObject();
//		json.put("code", "200");
//		System.out.println(json);
//		json.put("msg", "success");
//		out.print(json);
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		String result = "";
		if ("green".equals(req.getParameter("color"))) {
			result = "성공";
		} else {
			result = "실패";
		}
		out.print(result);
		
		System.out.println(req.getParameter("color"));
		
	}
	
	
}
