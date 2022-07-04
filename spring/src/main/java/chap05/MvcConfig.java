package chap05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc	// 어노테이션 기반의 SpringMVC를 구성할때 필요한 Bean 설정들을 자동으로 해주는 어노테이션 (기본 Bean들 이외 필요한 Bean 등록을 손쉽게 할 수 있음)
@ComponentScan(basePackages = {"chap05"})	// chap05 패키지에 있는 @Component를 찾아서 빈에 등록시킴 
public class MvcConfig implements WebMvcConfigurer{
	
	// 정적 URL (html, css, jpg, ...) 은 default servlet이 처리하도록 설정
	// dispacherServlet이 기본적으로 처리하는 URL은 ".jsp"을 처리하도록 되어있기때문에 추가설정이 필요하다.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
		conf.enable();
	}
	
	// ViewResolver 설정 (jsp 파일 경로 설정)
	// Controller의 실행결과를 JSP파일과 연결시켜주는 설정 
	@Override
	public void configureViewResolvers(ViewResolverRegistry reg) {
		reg.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 비즈니스 로직이 필요없는 페이지(디자인만 있는 페이지)
	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		reg.addViewController("/param/form.do").setViewName("form");
	}
	
}
