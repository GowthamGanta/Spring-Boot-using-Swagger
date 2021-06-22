package com.rs.fer.user.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.response.AbstractResponse;

public class UpdateUserResponse extends AbstractResponse{

	private User user;

	
	
	public UpdateUserResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
}

