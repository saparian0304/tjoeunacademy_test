package com.example.sns.post;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

@AutoConfigureMockMvc
@SpringBootTest
public class PostTest {

	@Autowired
	PostMapper mapper;
	
//	@Test
	public void insert() {
		PostVO vo = new PostVO();
		vo.setMember_no(1);
		vo.setContents("포스트글");
		
		int r = mapper.insert(vo);
		
		assertEquals(1, r);
	}
	
	@Test
	public void bulkInsert() {
		List<PostVO> list = new ArrayList<PostVO>();
		
		var sw = new StopWatch();
		
		for (int i=0; i<3000000; i++) {
			PostVO vo = new PostVO();
			int mno = i<1000000 ? 1: 2;
			vo.setMember_no(mno);
			vo.setContents("포스트 글" + i);
			vo.setReg_date(LocalDateTime.of(2022, 12, i%31+1, 12, 12));
			
//			mapper.insert(vo);
			list.add(vo);
		}
		sw.start();
		
//		System.out.println(list.size());
		
		int skip = 0;
		int limit = 3000;
		while(skip < list.size()) {
			List<PostVO> list2 = list.stream().skip(skip).limit(limit).toList();
			skip += limit;
//			System.out.println(list2.size());
			mapper.bulkInsert(list2);
		}
		sw.stop();
		System.out.println("시간: "+sw.getTotalTimeSeconds());
	}
	
}
