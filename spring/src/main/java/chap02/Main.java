package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx
			= new AnnotationConfigApplicationContext(AppContext.class);

		MemberService service = ctx.getBean("memberService", MemberService.class);
		MemberService service2 = ctx.getBean("memberService2", MemberService.class);
		MemberService service3 = ctx.getBean("memberService3", MemberService.class);
		service.insert();
		service2.insert();
		
		// @Autowired 설정 안해줬을 시
//		service3.insert(); 		// memberDAO 객체가 주입이 안되어있어서 에러남
		
		// @Autowired 설정해주면
		// 자동으로 주입해주기 때문에 에러 X
		// @Autowired는 type을 보고 빈을 찾아서 주입을 해주기때문에 동일한 type의 빈이 여러개 있으면 어떤 빈을 주입해줘야할지 모르기 때문에 에러가 발생함 
		// 추가로 @Qualifier 설정을 하면 주입할 Bean을 지정할 수 있음
		service3.insert();
	}

}
