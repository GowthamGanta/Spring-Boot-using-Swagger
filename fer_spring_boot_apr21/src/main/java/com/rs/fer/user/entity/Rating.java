package com.rs.fer.user.entity;

public class Rating {
	
	private int id;
	private String comments;
	private int rating;
	private int reviewedBy;
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(int reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
