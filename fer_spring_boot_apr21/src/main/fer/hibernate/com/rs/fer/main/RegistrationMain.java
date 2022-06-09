package com.rs.fer.main;

import com.rs.fer.entity.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		//1. To load the input
		User user = new User();
		user.setFirstName("Info");
		user.setMiddleName("");
		//user.setLastName("rs");
		user.setEmail("info@rs.com");
		user.setUsername("info");
		user.setPassword("rs");
		user.setMobile("3324324234");
		
		//2. To call the service for the business logic execution
		FERService ferService = new FERServiceImpl();
		boolean isRegister = ferService.registration(user);
		
		//3. To display the output
		if (isRegister) {
			System.out.println("user registered succesfully");
		} else {
			System.out.println("user not registered succesfully");
		}
		
	}

}
