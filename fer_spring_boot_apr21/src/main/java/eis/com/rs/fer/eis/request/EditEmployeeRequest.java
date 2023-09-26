package com.rs.fer.eis.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditEmployeeRequest {

	private int employeeId;
	
	private String firstName;

	private String middleName;

	private String lastName;

	private String dateOfBirth;

	private String gender;

	private String email;
	
	private String password;

	private String mobile;

	private float salary;
	
}

