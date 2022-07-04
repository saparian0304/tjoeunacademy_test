package chap05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/res")
public class ResponseController {
	
	// 리턴이 없는 경우 (매핑URL과 같은 경로의 jsp 파일을 포워딩함)
	@GetMapping("/test.do")
	public void test() {
		System.out.println("test");
	}
	
	// 리다이렉트
	@GetMapping("/redirect.do")
	public String redirect( ) {
		return "redirect:/board/test.do";
		// redirect -> url 자체가 바뀜 (board/test.do로 url이 바뀜, 포워딩의 경우엔 url은 바뀌지 않음)
		/*
		 * redirect: 과 주소 사이 공백 여부 차이
		 * redirect:주소 (공백X) -> 컨텍스트패스와 상관없이 이동   (localhost:8080/spring/board/test.do)
		 * redirect: 주소 (공백O) -> 컨텍스트패스를 포함한 경로로 이동 (localhost:8080/board/test.do)
		 */
	}
	
	// 리턴 없음 (jsp가 필요 없는 경우)
	@GetMapping("/alert")
	public void alert(HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");		// PrintWriter 객체보다 위에 있어야한다.
		PrintWriter out = res.getWriter();
		res.setContentType("text/html;charset=utf-8");
		out.print("<h2>alert한글</h2>");
	
	}
	
	// 값을 저장소(request/session)에 저장하기
	// -> jsp에서 꺼내서 쓰기 위함

	// request에 저장
	// 1. request에 저장
	//    request는 하나의 요청에서만 공유가 가능
	// 2. Model 객체에 저장
	//    spring이 알아서 request에 저장함
	@GetMapping("/save.do")
	public String save(HttpServletRequest req, Model model) {
		req.setAttribute("name", "홍길동");		// request에 저장하기
		model.addAttribute("id", "hong");		// Model에 저장하기
		return "save";
	}
	
	// session에 저장
	// 1. 웹어플리케이션 내 같은 브라우저 내에서 공유가 가능
	//    Request 객체 내 getSession() 메서드 이용
	@GetMapping("/sess.do")
	public void sess(HttpServletRequest req) {
		HttpSession sess = req.getSession();
		sess.setAttribute("hobby", "coding");		
		// 다시 save.do로 접속하면 session 정보가 저장된것 확인이 가능함
	}
	
	// session에 저장
	// 2. Session 객체를 이용
	@GetMapping("/sess2.do")
	public void sess2(HttpSession sess) {
		sess.setAttribute("hobby2", "coumputer");		
	}
	
	// ModelAndView 객체 리턴
	@GetMapping("/mav.do")
	public ModelAndView mav() {
		ModelAndView mav = new ModelAndView();
		// 값 저장
		mav.addObject("login", "로그인");
		// jsp 저장
		mav.setViewName("mav");
		
		return mav;
	}
}
