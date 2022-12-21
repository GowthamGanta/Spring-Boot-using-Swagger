package com.rs.fer.admin.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.response.AbstractResponse;
import com.rs.fer.user.entity.User;

public class BlockUserResponse extends AbstractResponse {

	private User user;

	public BlockUserResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
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
