package org.practice.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	// 계좌 개설
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
	
	// 거래내역 페이지
	@GetMapping("/get.do")
	public String get(AccountVO vo, Model model) {
		int accountNum = vo.getAccountNum();
		model.addAttribute("list", dao.getHistory(accountNum));
		model.addAttribute("vo", vo);
		return "bank/get";
	}
	
	// 계좌 삭제
	@GetMapping("/remove.do")
	public String remove(AccountVO vo, Model model) {
		int accountNum = vo.getAccountNum();
		if(dao.removeAccount(accountNum))
			vo.setMsg("계좌가 삭제되었습니다.");
		else vo.setMsg("계좌 삭제 중 오류가 발생하였습니다.");
		vo.setGo("list");
		model.addAttribute("vo", vo);
		
		return "bank/alert";
	}
	
	// 출금
	@GetMapping("/withdraw.do")
	public String getWithdraw(AccountVO vo, Model model) {
		model.addAttribute("vo", vo);
		return "bank/withdraw";
	}
	@PostMapping("/withdraw.do")
	public String withdrawProcess(AccountVO vo, Model model) {
		dao.withdraw(vo);
		
		vo.setGo("get");
		model.addAttribute("vo", vo);
		return "bank/alert";
	}
	
	// 입금
	@GetMapping("/deposit.do")
	public String getDeposit(AccountVO vo, Model model) {
		model.addAttribute("vo", vo);
		return "bank/deposit";
	}
	@PostMapping("/deposit.do")
	public String depositProcess(AccountVO vo, Model model) {
		log.info("계좌번호"+vo.getAccountNum());
		dao.deposit(vo);
		
		vo.setGo("get");
		model.addAttribute("vo", vo);
		return "bank/alert";
	}
	
}
