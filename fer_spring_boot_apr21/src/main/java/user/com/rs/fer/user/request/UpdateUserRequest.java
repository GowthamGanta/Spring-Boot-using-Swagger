/**
 * 
 */
package com.rs.fer.user.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Satish
 *
 */
@Getter
@Setter
public class UpdateUserRequest {
	
	private int userId;

	private String firstname;
	
	private String middlename;
	
	private String lastname;
	
	private String email;
	
	private String mobile;
	
	private int addressId;

	private String lineone;
	
	private String linetwo;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	private String country;
	
}
