package com.xworkz.xworkzinstitute.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz")
public class InstituteConfiguration {

	public InstituteConfiguration() {
		System.out.println("InstituteConfiguration");
	}
	
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/", ".jsp");
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean ();
		return bean;
	}
}
