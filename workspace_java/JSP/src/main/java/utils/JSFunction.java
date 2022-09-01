package utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class JSFunction {
	
	// 메시지 알림창을 띄운 후 명시한 URL로 이동
	public static String alertLocation(String msg, String url) {
		String script = "";
			   script	+= "<script>"
						+ "		alert('" 
						+ msg 
						+ "');"
						+ "		location.href='" 
						+ url 
						+ "';"	
						+ "</script>";
			return script;
	} 
	
//	public static String alertLocation(String msg, String url, JspWriter out) {
//		String script = "";
//			   script	+= "<script>"
//						+ "		alert('" 
//						+ msg 
//						+ "');"
//						+ "		location.href='" 
//						+ url 
//						+ "';"	
//						+ "</script>";
//			   try {
//				   out.println(script);
//			   } catch (Exception e) {}
//			return script;
//	} 
	
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = " "
							+ "<script>"
							+ 		"alert('"+ msg+ "');"
							+ 		"location.href='"+ url + "';"
							+ "</script>";
			writer.print(script);
		} 
		catch (Exception e) {	}
	}
	
	// 메시지 알림창을 띄운 후 이전 페이지로 돌아감
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = ""
					+ "<script>"
					+ "		alert('" + msg + "');"
					+ "		history.back();"	// 뒤로가기 : 이전 값이 그대로 유지됨
					+ "</script>";
			out.println(script);
		} catch (Exception e) {}
	}
	
	public static void alertBack(HttpServletResponse resp, String msg) {
		try {
			System.out.println("try문 처음");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			System.out.println("스크립트 작성 전");
			String script = ""
							+ "<script>"
							+ 		"alert('"+ msg + "');"
							+ 		"history.back();"
							+ "</script>";
			System.out.println(script);
			writer.print(script);
			System.out.println("alertBack 끝");
		}
		catch (Exception e) { }
	}
}
