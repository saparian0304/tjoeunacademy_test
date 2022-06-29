package chap02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAO();
	}
	
	@Bean
	public MemberDAO memberDAO2() {
		return new MemberDAO();
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDAO());	// memberDAO 객체를 생성자로 주입해주는 방식
	}
	
	@Bean
	public MemberService memberService2() {
		MemberService service = new MemberService();
		service.setDao(memberDAO());	// memberDAO 객체를 세터 메서드로 주입
		return service;
	}
	
	@Bean
	public MemberService memberService3() {
		return new MemberService();				
		// memberDAO 객체가 아직 미주입된 상태 (@Autowired 설정을 안해서 주입되지 않음)
	}
}
