package com.rs.fer.main;

import com.rs.fer.entity.Address;
import com.rs.fer.entity.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {

		// 1.To load the input
		// Get the original object
		FERService ferService = new FERServiceImpl();
		User user = ferService.getUser(2);

		// Name Info
		user.setFirstName("info2");
		user.setMiddleName("k");
		user.setLastName("rs2");

		// Contact Info
		user.setEmail("info2@rs.com");
		user.setMobile("543423432");

		// Address Info
		Address address = user.getAddress();
		address.setLineOne("Madhapur");
		address.setLineTwo("Hitech City");
		address.setCity("Hyderabad");
		address.setState("TS");
		address.setPinCode("500081");
		address.setCountry("IND");
		address.setUserId(2);

		// 2. To call the service for the business logic execution
		boolean isUpdateUser = ferService.updateUser(user);

		// 3.To display the output
		if (isUpdateUser) {
			System.out.println("User profile updated succesfully");
		} else {
			System.out.println("User profile update is failed");
		}
	}

}
