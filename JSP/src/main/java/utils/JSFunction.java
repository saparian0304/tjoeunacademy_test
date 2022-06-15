package utils;

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
	
	// 메시지 알림창을 띄운 후 이전 페이지로 돌아감
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "<script>"
					+ "		alert('" + msg + "');"
					+ "		history.back();"	// 뒤로가기 : 이전 값이 그대로 유지됨
					+ "</script>";
			out.println(script);
		} catch (Exception e) {}
	}
}
