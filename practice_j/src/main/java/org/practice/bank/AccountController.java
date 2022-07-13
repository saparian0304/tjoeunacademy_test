package org.practice.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class AccountController {

	@Autowired
	private AccountDAO dao;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("map", dao.getList());
	return "bank/list";
	}
	
	@GetMapping("/open.do")
	public String open() {
		return "bank/open";
	}
	
	@PostMapping("/open.do")
	public String openAccount(AccountVO vo) {
//		dao.createAccount(vo);
		System.out.println(vo.getHolder());
		return "redirect:/bank/list.do";
	}
}
