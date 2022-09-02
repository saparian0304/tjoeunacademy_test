package org.practice.member;

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
public class MemberDaoTests {

	@Autowired
	MemberDAO dao;
	
	@Test
	public void getList(MemberVO vo) {
		log.info(dao.list(vo));
	}
}