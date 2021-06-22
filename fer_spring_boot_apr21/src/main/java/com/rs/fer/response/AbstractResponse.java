package com.rs.fer.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

public class AbstractResponse {
	public HttpStatus status;
	public String statusCode;
	public String message;
	public Set<String> errorMessages;

	public AbstractResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}
}
