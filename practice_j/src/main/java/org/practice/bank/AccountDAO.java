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
		
		return result;
	}
	public boolean withdraw(AccountVO vo) {
		boolean result = true;
		int price = mapper.getBalance(vo)-vo.getWithdraw();

		// 인출할 돈이 부족하면 false 리턴
		if (price < 0 ) {
			result = false;
			return result;
		}
		
		// DB에 저장
		vo.setBalance(price);
		mapper.withdraw(vo);
		return result;
	}
	
	public boolean removeAccount(AccountVO vo) {
		return mapper.deleteAccount(vo) == 1 ? true : false;
	}
	
	public Map<String, Object> getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountVO> list = mapper.getList();
		map.put("list", list);
		return map;
	}
}
