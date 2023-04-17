package com.rs.fer.user.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.response.AbstractResponse;
import com.rs.fer.user.entity.Rating;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRatingResponse extends AbstractResponse {

	public GetRatingResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}
	
	private Rating rating;
	
	private List<Rating> ratings;

}
