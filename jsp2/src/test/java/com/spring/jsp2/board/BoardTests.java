package com.spring.jsp2.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.jsp2.config.MvcConfig;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration
@Slf4j
public class BoardTests {

	@Autowired
	BoardDAO dao;
	
//	@Test
	public void countTest() {
		BoardVO vo = new BoardVO();
		vo.setSearchField("title");
		vo.setSearchWord("자료실");
		int cnt = dao.count(vo);
		log.info(String.valueOf(cnt));
	}
	
	@Test
	public void listTest() {
		BoardVO vo = new BoardVO();
		vo.setStart(1);
		vo.setEnd(130);
		List<BoardVO> list = dao.list(vo);
		
		log.info(list.size()+"");
	}
	
}
