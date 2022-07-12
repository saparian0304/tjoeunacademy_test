package org.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.practice.bank.AccountVO;

@Mapper
public interface AccountMapper {
	
	int open(AccountVO vo);
	int insertBal(AccountVO vo);
	
	int deposit(AccountVO vo);
	int withdraw(AccountVO vo);
	
	int getBalance(AccountVO vo);
}
