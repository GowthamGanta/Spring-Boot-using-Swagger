package com.rs.fer.user.request;

public class GetRatingRequest {

	private int ratingId;
	private int userId;

	public int getRatingId() {
		return ratingId;
	} 

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
