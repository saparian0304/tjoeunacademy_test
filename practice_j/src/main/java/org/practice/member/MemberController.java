package org.practice.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
public class MemberController {

//	@Autowired
	MemberService service;
	
	@GetMapping("/list.do")
	public String getList(MemberVO vo, Model model) {

		model.addAttribute("map", service.getList(vo));
		
		return "member/list";
	}
	
	
}
