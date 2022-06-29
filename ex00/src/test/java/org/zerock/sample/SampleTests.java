package org.zerock.sample;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;		// SampleTests 객체에 Restaurant 객체를 주입함
	
	@Autowired
	private Chef chef;
	
	@Test
	public void testExist() {
		restaurant.setName("김길동");
		
		assertNotNull(restaurant);		// restaurant가 null이 아니면 통과되고, null일 경우 중지됨
		log.info(restaurant);				// restaurant 객체에 대한 로그 확인
		log.info(restaurant.toString());	// 위와 동일한 결과
		log.info("--------------------");
		log.info(restaurant.getChef());		// restaurant 객체 안에 있는 Chef에 대한 로그 확인
		log.info(restaurant.getChef().toString());	// 위와 동일한 결과
		
		log.info(chef == restaurant.getChef());		
		// true가 나온 이유 : 
		// 두 참조변수 모두 자바빈즈가 가지고 있는 (@Autowired로 연결시켜뒀기 때문) 
		// 싱글톤 객체를 가리키기 때문에 동일한 객체임을 알 수 있음
		
	}

}
