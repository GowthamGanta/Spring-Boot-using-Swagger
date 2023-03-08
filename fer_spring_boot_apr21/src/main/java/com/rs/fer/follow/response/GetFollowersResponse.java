package com.rs.fer.follow.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.response.AbstractResponse;

public class GetFollowersResponse extends AbstractResponse {

	public GetFollowersResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);

		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

	private Follow follwer;

	public Follow getFollwer() {
		return follwer;
	}

	public void setFollwer(Follow follwer) {
		this.follwer = follwer;
	}

}
