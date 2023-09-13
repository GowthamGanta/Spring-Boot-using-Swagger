package com.rs.fer.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SaveExperienceResponse extends AbstractResponse {
	private Experience_Details experienceDetails;

	public SaveExperienceResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	

}
