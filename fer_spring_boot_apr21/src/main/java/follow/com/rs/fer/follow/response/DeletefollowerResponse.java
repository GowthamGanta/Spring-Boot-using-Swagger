package com.rs.fer.follow.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeletefollowerResponse extends AbstractResponse{

	public DeletefollowerResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
		
	}

	private Follow follower;
}
