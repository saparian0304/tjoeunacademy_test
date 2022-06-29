package chap03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"chap03"})
public class AppContext {
	
//	@Bean
//	public MemberDAO memberDAO() {
//		return new MemberDAO();
//	}
//	
//	
//	@Bean
//	public MemberDAO memberDAO2() {
//		return new MemberDAO();
//	}
	
	
//	@Bean
//	public MemberService memberService() {
//		return new MemberService();				
//		// memberDAO 객체가 아직 미주입된 상태 (@Autowired 설정을 안해서 주입되지 않음)
//	}
	
	
}
