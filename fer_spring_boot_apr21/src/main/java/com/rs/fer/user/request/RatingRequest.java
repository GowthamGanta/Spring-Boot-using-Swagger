package com.rs.fer.user.request;

public class RatingRequest {

	private String Comments;

	private int Rating;

	private int Reviewedby;

	private int userId;

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	public int getReviewedby() {
		return Reviewedby;
	}

	public void setReviewedby(int reviewedby) {
		Reviewedby = reviewedby;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
