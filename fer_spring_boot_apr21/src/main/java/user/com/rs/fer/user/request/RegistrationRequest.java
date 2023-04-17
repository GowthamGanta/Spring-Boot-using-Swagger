/**
 * 
 */
package com.rs.fer.user.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 
 * @author Satish
 *
 */
@Getter
@Setter
public class RegistrationRequest {

	private String firstname;
	
	private String middlename;
	
	private String lastname;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private String mobile;
	
	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setUserId(int i) {
		// TODO Auto-generated method stub
		
	}

}
