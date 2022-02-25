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
		System.out.println("SUSMITHA changes");
		System.out.println("Roja changes");
		System.out.println("Pravalika changes");
	}    

}

