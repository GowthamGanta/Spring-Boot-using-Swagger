package com.rs.fer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:${CONFIG_MODE}/application.properties")
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
		
		System.out.println("sir changes");
		System.out.println("susmitha changes");
		System.out.println("ROJA changes");
		System.out.println("Vijaya changes");
		System.out.println("mohan changes");
		
	}    

}
