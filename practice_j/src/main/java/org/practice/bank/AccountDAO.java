package org.practice.bank;

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
		
		return result;
	}
	public boolean withdraw(AccountVO vo) {
		boolean result = true;
		int price = mapper.getBalance(vo)-vo.getWithdraw();
		
		if (price < 0 ) {
			result = false;
			return result;
		}
		
		vo.setBalance(price);
		mapper.withdraw(vo);
		
		return result;
	}
}
