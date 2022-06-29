package chap01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainUseXML {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx 
			= new ClassPathXmlApplicationContext("chap01/beans.xml");
		
		Greet g = (Greet)ctx.getBean("hi");
		System.out.println(g.greet("홍길동"));
		
		Greet g2 = ctx.getBean("hi", Greet.class);
		System.out.println(g == g2);
		
		System.out.println(ctx.getBean("hello"));
	}
}
