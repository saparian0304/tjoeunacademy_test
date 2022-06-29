package chap03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx
			= new AnnotationConfigApplicationContext(AppContext.class);

		MemberService service = ctx.getBean("memberService", MemberService.class);
		service.insert();
		MemberDAO dao = ctx.getBean("memberDAO", MemberDAO.class);
		dao.insert();
	}

}
