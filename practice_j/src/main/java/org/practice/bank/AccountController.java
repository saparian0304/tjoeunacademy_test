package org.practice.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/bank")
@Slf4j
public class AccountController {

	@Autowired
	private AccountDAO dao;
	
	@RequestMapping("/list.do")
	public String list(AccountVO vo, Model model) {
		model.addAttribute("map", dao.getList());
	return "bank/list";
	}
	
	@GetMapping("/open.do")
	public String open() {
		return "bank/open";
	}
	
	@PostMapping("/open.do")
	public String openAccount(AccountVO vo) {
		dao.createAccount(vo);
		System.out.println(vo.getHolder());
		return "redirect:/bank/list.do";
	}
	
	@GetMapping("/get.do")
	public String get(int accountNum, Model model) {
		model.addAttribute("list", dao.getHistory(accountNum));
		model.addAttribute("accountNum", accountNum);
		return "bank/get";
	}
	
	@GetMapping("/remove.do")
	public String remove(@RequestParam int accountNum) {
		dao.removeAccount(accountNum);
		return "redirect:/bank/list.do";
	}
}
