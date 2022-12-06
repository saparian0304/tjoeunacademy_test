package com.example.sns.member;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
//@WebMvcTest
@SpringBootTest
public class MemberTest {

	@Autowired
	MemberMapper mmapper;
	
	@Test
	public void insert() {
		MemberVO vo = new MemberVO();
		vo.setId("kim");
		vo.setName("김길동");
		vo.setPwd("1234");
		int r = mmapper.insert(vo);
		System.out.println(r);
		assertEquals(1, r);
	}
	
	// 컨트롤러 테스트
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void registTest() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setId("lee");
		vo.setName("이길동");
		vo.setPwd("1234");
		
		String json = new ObjectMapper().writeValueAsString(vo);
		
		mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/member/regist")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
		).andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void updateTest() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setNo(1);
		vo.setName("홍길동2");
		vo.setPwd("1234");
		
		String json = new ObjectMapper().writeValueAsString(vo);
		
		mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/member/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
		).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void loginTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/member/login")
				.queryParam("id", "hong")
				.queryParam("pwd", "1234")
		).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void getMemberTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/member/get")
				.queryParam("no", "1")
		).andDo(MockMvcResultHandlers.print());
	}
}
