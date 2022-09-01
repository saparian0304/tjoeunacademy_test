package org.practice.bank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.practice.config.RootConfig;
import org.practice.config.ServletConfig;
import org.practice.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BankMapperTest {
	
	@Autowired
	AccountMapper mapper;
	
//	@Test
	public void testOpen() {
		AccountVO vo = new AccountVO();
		vo.setHolder("이현우");
		vo.setDeposit(4000);
		vo.setAccountNum(4);
		vo.setBalance(vo.getDeposit());
		
		//mapper.open(vo);
		mapper.insertBal(vo);
	}
	
//	@Test
	public void testGetBalance() {
		AccountVO vo = new AccountVO();
		vo.setAccountNum(1);
		vo.setDeposit(10000);
		
		log.info("계좌 잔고 : "+mapper.getBalance(vo));
	}
	
//	@Test
	public void testDelete() {
		AccountVO vo = new AccountVO();
		vo.setAccountNum(10);
		
		log.info("삭제 여부 : " + mapper.deleteAccount(10));
	}
	
//	@Test
	public void testGetList() {
		log.info("리스트 : " + mapper.getList());
	}
	
	@Test
	public void testGet() {
		mapper.getHistory(2).forEach(a -> log.info(a));
	}
}
