package com.rs.fer.ipl.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.response.AbstractResponse;

public class DeleteTeamResponse extends AbstractResponse {

	public DeleteTeamResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		
		this.status = status;
		this.statusCode = statusCode;
		this.message = message; 
		this.errorMessages = errorMessages;
	}
	
	

}
