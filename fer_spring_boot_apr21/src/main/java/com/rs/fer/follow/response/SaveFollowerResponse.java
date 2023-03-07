package com.rs.fer.follow.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.message.entity.Message;
import com.rs.fer.response.AbstractResponse;

public class SaveFollowerResponse extends AbstractResponse{

	public SaveFollowerResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
		
	}
	
	private Follow follower;

	public Follow getFollower() {
		return follower;
	}

	public void setFollower(Follow follower) {
		this.follower = follower;
	} 
	
	
}