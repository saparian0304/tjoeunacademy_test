package org.practice.member;

import java.util.List;
import java.util.Map;

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
public class MemberServiceImplTests {
	
	@Autowired
//	@Setter(onMethod_ = {@Autowired})
	MemberServiceImpl service;
	
	@Test
	public void getList() {
//		MemberVO vo = new MemberVO();
//		Map<String, Object> map = service.getList(vo);
//		
//		List<MemberVO> list = (List<MemberVO>)map.get("list");
//		list.forEach(a -> log.info(a));
		
	}
}
