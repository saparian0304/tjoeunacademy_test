package interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class MemberLoginInterceptor implements HandlerInterceptor {
	/*
	 *  preHandle : 컨트롤러 실행 전
	 *  postHandle : 컨트롤러 실행 후(뷰 리턴 전) 
	 *  afterCompletion : 뷰 실행 후  
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, 
			HttpServletResponse res, Object handler) throws IOException {
		// 세션 객체에서 loginInfo 이름으로 꺼내서 
		//    값이 있으면(로그인 상태) -> return true
		//    값이 없으면(로그아웃) -> return false
		
		HttpSession sess = req.getSession();
		if( sess.getAttribute("loginInfo") == null) {	// 로그아웃 상태
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 사용가능합니다.');");
			out.println("location.href='/project/member/login.do';");
			out.println("</script>");
			out.flush();
			return false;
		}
		return true;
	}
}
