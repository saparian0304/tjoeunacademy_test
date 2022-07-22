package kr.co.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/member/join.do")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("member/join.do")
	public String join(MemberVO vo, Model model) {
		if(service.insert(vo)>0) {
			model.addAttribute("msg", "정상적으로 회원가입되었습니다.");
			model.addAttribute("url", "login.do");
		} else {
			model.addAttribute("msg", "회원 가입 오류");
		}
		return "common/alert";
	}
	
	@GetMapping("/member/login.do")
	public String login() {
		return "member/login";
	}
	
}
