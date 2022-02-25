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
<<<<<<< HEAD
		System.out.println("Pravalika changes");
=======
		System.out.println("Abdul Qadari changes");
		
>>>>>>> branch 'master' of https://github.com/GowthamGanta/Spring-Boot-using-Swagger.git
	}    

}

