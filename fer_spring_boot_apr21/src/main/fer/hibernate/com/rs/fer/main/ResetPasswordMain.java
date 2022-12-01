package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		// 1. Get the input from UI
		int Id = 2;
		String currentPassword = "YYY";
		String newPassword = "SSS";

		// 2. call the service the business logic ececution
		FERService ferService = new FERServiceImpl();
		boolean isResetPassword = ferService.resetPassword(Id, currentPassword, newPassword);
   
		// 3.     Display the option
		if (isResetPassword) {
			System.out.println("password changed successfully.............");
		} else {
			System.out.println("password reset is failed");
		}

	}

}