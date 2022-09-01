package org.practice.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.practice.config.RootConfig;
import org.practice.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
@WebAppConfiguration
public class TestMember {
	
	@Autowired
	MemberMapper mapper;
	
	
	@Test
	public void select() {
		MemberVO vo = new MemberVO();
		mapper.selectAll(vo).forEach(a->log.info(a));
	}
}
