package com.rs.fer.admin.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.response.AbstractResponse;
import com.rs.fer.user.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBlockUserResponse extends AbstractResponse {
	private List<User> users;
	
	public GetBlockUserResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);

		this.status = status;

		this.statusCode = statusCode;

		this.errorMessages = errorMessages;

		this.message = message;

	}

}
