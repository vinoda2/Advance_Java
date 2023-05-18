package com.xworkz.googlesheetconnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GooglesheetconnectionApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GooglesheetconnectionApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		//System.out.println("corsConfigurer created");
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
		        registry.addMapping("/**")
		                .allowedOrigins("http://ombn.in/**","http://localhost:3000")
		                .allowedMethods("GET", "POST", "PUT", "DELETE")
		                .allowedHeaders("*");
		    }
			
		};
	}
}
