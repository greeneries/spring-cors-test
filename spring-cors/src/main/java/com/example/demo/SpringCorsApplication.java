package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan(basePackages= {"com.example.demo"})
@SpringBootApplication
public class SpringCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCorsApplication.class, args);
	}
	
 @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						// 이 서버가 제공할 리소스에 접근하는 URI를 등록한다. 
						// emps로 시작하는 것만 아래 정책을 제공하겠다는 의미 
						.addMapping("/emps/**")
						// 이 서버에 데이터를 요구하는 도메인
						.allowedOrigins("*") // 특정 도메인만 cors를 허용할 때 도메인을 써준다. 
						.allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS"); // 나열된 요청방식만 허용하겠다는 의미 
			}
		};
	}
}
