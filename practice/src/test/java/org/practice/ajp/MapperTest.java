package org.practice.ajp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.practice.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void info() {
		log.info("테스트 중입니다");
	}
	
	@Test
	public void info2() {
		log.info(empMapper.selectName());
	}
}
