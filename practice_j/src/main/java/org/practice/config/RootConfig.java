package org.practice.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"org.practice.mapper"})
@ComponentScan(basePackages = {"org.practice.ajp", "org.practice.member"})
public class RootConfig {

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
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:/org/practice/ajp/emp/emp.xml"));
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
	// dao에서 주입받을 객체
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sst = new SqlSessionTemplate(sqlSessionFactory());
		return sst;
	}
}
