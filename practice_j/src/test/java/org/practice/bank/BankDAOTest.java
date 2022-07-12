package org.practice.bank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.practice.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BankDAOTest {

	@Autowired
	AccountDAO dao;
	
//	@Test
	public void testCreat() {
		AccountVO vo = new AccountVO();
		vo.setDeposit(500);
		vo.setHolder("성준우");
		log.info("true면 성공 : " +dao.createAccount(vo));
	}
	
//	@Test
	public void testDeposit() {
		AccountVO vo = new AccountVO();
		vo.setAccountNum(2);
		vo.setDeposit(30000);
		log.info("입금 성공하면 1이 나옴 ->"+dao.deposit(vo));
		
	}
//	@Test
	public void testWithdraw() {
		AccountVO vo = new AccountVO();
		vo.setAccountNum(2);
		vo.setWithdraw(50000);
		log.info("인출금액 초과로 false가 나와야함 ->"+dao.withdraw(vo));
		
	}
	@Test
	public void testWithdraw2() {
		AccountVO vo = new AccountVO();
		vo.setAccountNum(2);
		vo.setWithdraw(3000);
		log.info("true가 나와야함 ->"+dao.withdraw(vo));
		
	}
}
