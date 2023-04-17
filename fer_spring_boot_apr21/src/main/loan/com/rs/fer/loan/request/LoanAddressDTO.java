package com.rs.fer.loan.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanAddressDTO {
	
	private String lineOne;

	private String lineTwo;
	
	private String city;

	private String state;

	private String pincode;

	private String country;
	
	private String addressType;
}
