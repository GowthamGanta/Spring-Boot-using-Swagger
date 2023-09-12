package com.rs.fer.eis.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddEmployeeAddressRequest {

	private String lineOne;
	private String lineTwo;
	private String city;

	private String state;
	private String pinCode;
	private String country;

	private String addressType;
	private int employeeId;

}
