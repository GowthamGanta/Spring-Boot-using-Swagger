package com.rs.fer.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequest {

	
	private int userId;
	
	private String currentPassword;

	private String newPassword;

	/**
	 * @return the userId
	 */
	
}
