package com.origin.learn.spring.sdms.controllrconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.origin.learn.spring.sdms.Dao.*;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.origin.learn.spring.sdms", "com.origin.learn.spring.sdms.Dao" })
public class WebMvcConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");

		return vr;
	}

	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/dbname");
		ds.setUsername("root");
		ds.setPassword("12345");

		return ds;
	}

	@Bean
	public StudentDao getStudentDao() {
		return new StudentDaoImpl(getDataSource());
	}

}