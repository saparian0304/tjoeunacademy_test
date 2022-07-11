package org.zerock.controller;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
			"file:src/main/webapp/WEB-INF/spring//appServlet/servlet-context.xml"})
@Log4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	// @Test를 메서드명 순서대로 실행시킬 수 있음
public class BoardControllerTests {

	@Setter(onMethod_ = {@Autowired})
//	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before		// 모든 테스트 전에 매번 실행됨
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		
		log.info("ModelMap : " + mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
//		log.info("View : "+mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn()
//				.getModelAndView()
//				.getView());
//		log.info("ViewName : "+mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn()
//				.getModelAndView()
//				.getViewName());
//		log.info("Status : "+mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn()
//				.getModelAndView()
//				.getStatus());
//		log.info("ModelAndView : "+mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn()
//				.getModelAndView());
//		log.info("MvcResult : "+mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//		.andReturn());
//		log.info("ResultAction : "+mockMvc.perform(MockMvcRequestBuilders.get("/board/list")));
	}
	@Test
	public void testListPaging() throws Exception {
		
		log.info("ModelMap : " + mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
		.param("pageNum", "2")
		.param("amount", "10"))
		.andReturn()
		.getModelAndView()
		.getModelMap());
	}
	
//	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "(추가)테스트 새글 제목")
				.param("content", "(추가)테스트 새글 내용")
				.param("writer", "user00")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
//	@Test
	public void testGet() throws Exception {
		
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "3"))
				.andReturn()
				.getModelAndView().getModelMap());
		log.info("get.......");
	}
	
//	@Test
	public void testModify() throws Exception {
		
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "4")
				.param("title", "수정된 테스트 새글 제목")
				.param("content", "수정된 테스트 새글 내용")
				.param("writer", "user00"))
				.andReturn().getModelAndView().getViewName());
	}
	
//	@Test
	public void testRemove() throws Exception {
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
						.param("bno", "7")
						).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
}
