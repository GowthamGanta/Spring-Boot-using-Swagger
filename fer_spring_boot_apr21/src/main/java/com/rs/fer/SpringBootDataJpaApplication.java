package com.rs.fer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.rs.fer.follow.entity"})
//@PropertySource("classpath:${CONFIG_MODE}/application.properties")
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
		
		System.out.println("Hi");
		System.out.println("Bye");
	}    

}
 