package com.rs.fer.main;

import com.rs.fer.bean.Address;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {

		// 1.To load the input
		int userId = 2;

		// 2. To call the service for the business logic execution
		FERService ferService = new FERServiceImpl();
		User user = ferService.getUser(userId);

		// 3.To display the output
		if (user == null) {
			System.out.println("User not found");
		} else {
			//Name Info
			System.out.println("FirstName: " + user.getFirstName());
			System.out.println("MiddleName: " + user.getMiddleName());
			System.out.println("LastName: " + user.getLastName());
			
			//contact Info
			System.out.println("Email: " + user.getEmail());
			System.out.println("Mobile: " + user.getMobile());
		
			//Address Info
			Address address = user.getAddress();
			System.out.println("Line1: " + address.getLineOne());
			System.out.println("Line2: " + address.getLineTwo());
			System.out.println("City: " + address.getCity());
			System.out.println("State: " + address.getState());
			System.out.println("Pin Code: " + address.getPinCode());
			System.out.println("country: " + address.getCountry());
		}
	}

}
