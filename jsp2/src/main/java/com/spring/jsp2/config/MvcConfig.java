package com.spring.jsp2.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc	// 어노테이션 기반의 SpringMVC를 구성할때 필요한 Bean 설정들을 자동으로 해주는 어노테이션 (기본 Bean들 이외 필요한 Bean 등록을 손쉽게 할 수 있음)
@ComponentScan(basePackages = {"com.spring.jsp2"})	// chap05 패키지에 있는 @Component를 찾아서 빈에 등록시킴 
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
	
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		// xml방식을 사용해서 빈 객체에 속성값(필드값) 입력해주기 - xml에서는 property 형태로 되어있음
//		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("testuser");
		hikariConfig.setPassword("test1234");
		
		return hikariConfig;
	}
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSouce = new HikariDataSource(hikariConfig());	// hikariConfig()라는 빈을 주입해주는 것
		return dataSouce;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory 
		 	= new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		// xml 경로 설정
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:/com/spring/jsp2/board/board.xml"));
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
	// dao에서 주입받을 객체
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sst = new SqlSessionTemplate(sqlSessionFactory());
		return sst;
	}
	
	
}
