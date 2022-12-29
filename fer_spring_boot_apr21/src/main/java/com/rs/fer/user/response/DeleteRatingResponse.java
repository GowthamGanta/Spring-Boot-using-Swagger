package com.rs.fer.user.response;
import java.util.Set;
import org.springframework.http.HttpStatus;

import com.rs.fer.response.AbstractResponse;
import com.rs.fer.user.entity.User;

public class DeleteRatingResponse extends AbstractResponse {

	public DeleteRatingResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	private User user; 

	public User getUser() {
		return user;
	}

	
	public void setRating(User userId) {
		// TODO Auto-generated method stub
		
	}

	
	}

