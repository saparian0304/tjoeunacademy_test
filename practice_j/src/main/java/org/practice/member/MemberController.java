package org.practice.member;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/list.do")
	public String getList(MemberVO vo, Model model) {

		model.addAttribute("map", service.getList(vo));
		
		return "member/list";
	}
	@PostMapping("/list.do")
	public ResponseEntity<String> react(HttpSession session, Model model, MemberVO vo) {
		int num = vo.getIdx();
		ServletContext application = session.getServletContext();
		
		application.setAttribute("num", num);
		System.out.println(application.getAttribute("num"));
		String msg = "{\"num\" : \""+num+"\"}";
//		String msg = "";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
//		model.addAttribute("map", service.getList(vo));
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	
}
