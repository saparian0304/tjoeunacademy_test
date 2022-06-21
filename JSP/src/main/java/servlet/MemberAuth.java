package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;

public class MemberAuth extends HttpServlet{
	MemberDAO dao;
	
	@Override
	public void init() throws ServletException {
		// application 내장 객체 얻기
		ServletContext application = this.getServletContext();
		
		// web.xml에서 DB연결 정보 얻기
		String driver = application.getInitParameter("OracleDriver");
		String connectUrl = application.getInitParameter("OracleURL");
		String oId = application.getInitParameter("OracleId");
		String oPass = application.getInitParameter("OraclePwd");
		
		// DAO 생성
		dao = new MemberDAO(driver, connectUrl, oId, oPass);
		System.out.println("init() 실행");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
		System.out.println("service() 실행");
		
		// 서블릿 초기화 매개변수에서 관리자 ID 받기
		String admin_id = this.getInitParameter("admin_id");
		String admin_pwd = this.getInitParameter("admin_pwd");
		
		// 인증을 요청한 ID/패스워드
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		// 회원 테이블에서 인증 요청한 ID/패스워드에 해당하는 회원 찾기
		MemberDTO memberDTO = dao.getMemberDTO(id, pass);
		
		// 찾은 회원의 이름에 따른 처리
		String memberName = memberDTO.getName();
		if (memberName != null) {
			req.setAttribute("authMessage", memberName + "회원님 안녕하세요~");
		}
		else  {
			if (admin_id.equals(id)&&admin_pwd.equals(pass)) // DB에 없는 관리자 아이디일때 
				req.setAttribute("authMessage", admin_id + "는 관리자입니다.");
			else // 비회원일시
				req.setAttribute("authMessage", "당신은 회원이 아닙니다.");
		}
		req.getRequestDispatcher("/13/memberAuth.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		dao.close();
		System.out.println("서버 종료");
	}
}
