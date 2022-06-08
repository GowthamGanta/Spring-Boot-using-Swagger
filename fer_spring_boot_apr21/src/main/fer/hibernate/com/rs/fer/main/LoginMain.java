package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		//1. To load the input
		String username = "info";
		String password = "rs123";
		
		//2. To call the service for the business logic execution
		FERService ferService = new FERServiceImpl();
		boolean isValidUser = ferService.login(username, password);
		
		//3. To display the output
		if (isValidUser) {
			System.out.println("user is valid");
		} else {
			System.out.println("user is not valid");
		}
		
	}

}
