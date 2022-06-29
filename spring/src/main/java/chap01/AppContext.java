package chap01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration		// 설정파일임을 알려주는 어노테이션
public class AppContext {
	
	@Bean	// 컨테이너에서 관리할 객체라는 어노테이션
	@Scope("prototype")		// 프로토타입 (새로운 객체), 싱글톤으로 관리되지 않음
	public Greet hi() {		// hi라는 이름으로 빈(객체)가 등록됨
		Greet g = new Greet();
		g.setFormat("%s님, 안녕하세요");
		return g;
	}
	
	@Bean
	public Greet hi2() {		
		Greet g = new Greet();
		g.setFormat("%s님, 안녕하세요");
		return g;
	}
	
	@Bean
	public String hello() {	
		return hi2().greet("김길동");
	}
	
	// 등록된 객체 결과  { "hi2" : Greet객체, "hello" : String객체 }
	
	@Bean 
	public Greet hello2() {
		return hi2();			
		// hi2() 메서드를 실행하는 것이 아니고, 빈 컨테이너에 hi2라는 이름의 객체를 그냥 반환하는 것
	}
}
