package com.example.sns.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

@AutoConfigureWebMvc
@SpringBootTest
public class RedisTest {

	@Autowired
	RedisTemplate<String, String> template;
	
	@Test
	public void test() {
		// string
		ValueOperations<String, String> oper = template.opsForValue();
		oper.set("email", "hong@gmail.com");
		System.out.println(oper.get("email"));
		System.out.println(oper.get("id"));
		
		// list
		ListOperations<String, String> oper2 = template.opsForList();
		oper2.leftPush("mylist", "apple");
		oper2.leftPush("mylist", "banana");
		oper2.leftPush("mylist", "grape");
		System.out.println(oper2.index("mylist", 0));
		
		// set
		SetOperations<String, String> oper3 = template.opsForSet();
		oper3.add("myset", "a", "b", "c", "d");
		System.out.println(oper3.members("myset"));
	}
}
