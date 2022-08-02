package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		// 1. Get the input
		User user = new User();

		String userName = "123";

		String password = "9542";

		// 2. Pass the input to service layer for business logic execution
		FERService ferService = new FERServiceImpl();
		int userId = ferService.login(userName, password);

		// 3. Display the output
		if (userId >0) {
			System.out.println("Login successfuly......");
		} else {
			System.out.println("Login  is failed...");
		}

	}

}
