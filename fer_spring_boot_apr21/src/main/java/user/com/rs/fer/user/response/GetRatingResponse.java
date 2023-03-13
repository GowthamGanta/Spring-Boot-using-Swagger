package com.rs.fer.user.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.response.AbstractResponse;
import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.entity.User;

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

	public Rating getRating() {
		return rating;
	}

	public void setRating(List<Rating> ratings2) {
		this.rating = rating;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public void setRating(User reviewer) {
		// TODO Auto-generated method stub

	}

}
