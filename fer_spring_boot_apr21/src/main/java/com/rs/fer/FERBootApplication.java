package com.rs.fer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@PropertySource("classpath:${CONFIG_MODE}/application.properties")
public class FERBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FERBootApplication.class, args);
		
		System.out.println("To test commit or to push...!");
		
		
	}  
	

}
 
