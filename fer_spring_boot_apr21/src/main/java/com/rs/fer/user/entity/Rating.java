package com.rs.fer.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String comments;
	
	private int rating;
	
	private int reviewedBy;
	
	private int reviewId;
	
	public Rating() {

	}

	public Rating(int id, String comments, int rating, int reviewedBy, int reviewId) {

		
		this.id = id;
		this.comments = comments;
		this.rating = rating;
		this.reviewedBy = reviewedBy;
		this.reviewId = reviewId;
	}
	
	
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
	public int getReviewIdId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
}
