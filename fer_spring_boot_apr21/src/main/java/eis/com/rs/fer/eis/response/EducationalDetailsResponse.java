package com.rs.fer.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.eis.entity.EducationalDetails;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationalDetailsResponse extends AbstractResponse {
	private EducationalDetails educationalDetails;

	public EducationalDetailsResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

}
