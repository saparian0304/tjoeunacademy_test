package org.practice.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.practice.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private AccountMapper mapper;
	
	public boolean createAccount(AccountVO vo) {
		int result = 0;
		result += mapper.open(vo);
		result += mapper.insertBal(vo);
		
		return result == 2 ? true : false;
	}
	
	public int deposit(AccountVO vo) {
		int result = 0;
		
		vo.setBalance(mapper.getBalance(vo)+vo.getDeposit());
		result = mapper.deposit(vo);
		if (result == 1) {
			vo.setMsg("입금 성공");
		} else {
			vo.setMsg("입금 실패");
		}
		
		return result;
	}
	public boolean withdraw(AccountVO vo) {
		boolean result = true;
		int price = mapper.getBalance(vo)-vo.getWithdraw();

		// 인출할 돈이 부족하면 false 리턴
		if (price < 0 ) {
			result = false;
			vo.setMsg("인출할 금액이 부족합니다.");
			return result;
		}
		
		// DB에 저장
		vo.setBalance(price);
		if (mapper.withdraw(vo) == 1) {
			vo.setMsg("인출 성공");
		} else {
			vo.setMsg("인출 실패");
		}
		return result;
	}
	
	public Map<String, Object> getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountVO> list = mapper.getList();
		map.put("list", list);
		return map;
	}
	
	
	public List<AccountVO> getHistory(int accountNum) {
		return mapper.getHistory(accountNum);
	}
	
	public boolean removeAccount(int accountNum) {
		int balance = mapper.getBalance(accountNum);
		int result = 0;
		AccountVO vo = new AccountVO();
		vo.setAccountNum(accountNum);
		vo.setWithdraw(balance);
		vo.setBalance(0);
		result += mapper.withdraw(vo);
		result += mapper.deleteAccount(accountNum);
		return result == 2 ? true : false ;
	}
}
