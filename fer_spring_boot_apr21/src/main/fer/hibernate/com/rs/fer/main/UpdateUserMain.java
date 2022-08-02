package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {

		// 1.Get the input

		int userId = 2;
		FERService ferService = new FERServiceImpl();

		// To get the original object form DB

		User user = ferService.getUser(userId);
		// Update the name data
		user.setFirstname("seeta ramulu");
		user.setMiddlename("nayan");
		user.setLastname("jupudi");

		// update the contact
		user.setEmail("ravi.1@gmail.com");
		user.setMobile("876876765");

		// update the address data

		Address address = user.getAddress();
		address.setLineone("pbkvpalem");
		address.setLinetwo("ndg");
		address.setCity("vijayawada");
		address.setState("ap");
		address.setPincode("521183");
		address.setCountry("india");

		// 2. call the service
		boolean isuserUpdate = ferService.updateUser(user);
		// 3.Display the output

		if (isuserUpdate) {
			System.out.println("User profile is updated successfully..........");
		} else {
			System.out.println("User profile update failed......................");
		}

	}
}
