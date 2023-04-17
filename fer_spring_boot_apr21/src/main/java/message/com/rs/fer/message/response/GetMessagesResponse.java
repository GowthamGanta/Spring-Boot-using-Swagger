package com.rs.fer.message.response;


import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.message.entity.Message;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMessagesResponse extends AbstractResponse {

	public GetMessagesResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {

		super(status, statusCode, message, errorMessages);

		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}
	
	private Message messages;

}
