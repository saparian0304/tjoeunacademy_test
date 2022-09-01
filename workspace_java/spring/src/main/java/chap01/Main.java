package chap01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// @Component-scan을 사용하지 않는 방법
		// 수작업으로 설정파일을 넣어서 객체를 관리하도록 실행 
		// ApplicationContext : 스프링 컨테이너를 의미함
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(AppContext.class); 
		// AppContext.class에 @Configuration 어노테이션을 확인하고, 그 안에 @Bean 표시된 객체를 관리함 
		// @Bean이 아니라 @Component를 사용할 경우 type명으로 및 첫글자를 소문자로 변환해서 등록됨
		
		// getBean() - ctx가 관리하는 객체를 꺼내는 메서드
		Greet g = (Greet)ctx.getBean("hi2");
		System.out.println(g.greet("홍길동"));
		System.out.println(ctx.getBean("hello"));
		Greet g2 = ctx.getBean("hi2", Greet.class);	// 오브젝트가 아닌 Greet 타입으로 리턴해줌
		System.out.println(g == g2);	// 빈은 기본적으로 싱글톤으로 객체 생성
		System.out.println("hi2 와 hello는 같은 bean?");
		Greet g3 = ctx.getBean("hello2", Greet.class);
		System.out.println(g == g3);	// Greet 객체를 새로 생성하는게 아니라 동일한 객체를 비교하기 때문에 true가 됨
		
		
		// Scope를 prototype으로 지정할 경우 싱글톤 객체로 관리되지 않음
		Greet g4 = ctx.getBean("hi", Greet.class);
		Greet g5 = ctx.getBean("hi", Greet.class);
		System.out.println(g4 == g5);
		
		// getBean()은 싱글톤 객체를 리턴함
		// getBean()이 아니라 그냥 자바코드로 비교하면 서로 다른 객체임
//		AppContext ctx2 = new AppContext();
//		System.out.println(ctx2.hi() == ctx2.hello2());
	}

}
