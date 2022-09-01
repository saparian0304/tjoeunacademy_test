package org.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.practice.bank.AccountVO;

@Mapper
public interface AccountMapper {
	
	int open(AccountVO vo);
	int insertBal(AccountVO vo);
	
	int deposit(AccountVO vo);
	int withdraw(AccountVO vo);
	
	int getBalance(AccountVO vo);
	int getBalance(int accountNum);
	
	int deleteAccount(int accountNum);	// 아직 구현 안함
	List<AccountVO> getList();
	List<AccountVO> getHistory(int accountNum);
}
