package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		String newPassword ="rs2";
		int id = 2;
		String currentPassword ="rs";

		FERService ferService = new FERServiceImpl();
		boolean isResetPassword = ferService.resetPassword(id, currentPassword, newPassword);

		if (isResetPassword) {
			System.out.println("password reset succesfully");
		} else {
			System.out.println("password is not reset succesfully");
		}

	}

}
