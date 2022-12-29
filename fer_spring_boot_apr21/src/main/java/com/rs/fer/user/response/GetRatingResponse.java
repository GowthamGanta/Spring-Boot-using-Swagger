package com.rs.fer.user.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.response.AbstractResponse;
import com.rs.fer.user.entity.Rating;

public class GetRatingResponse extends AbstractResponse {

	public GetRatingResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	} 
	private Rating rating;

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}
