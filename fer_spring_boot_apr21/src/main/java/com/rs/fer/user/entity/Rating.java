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
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column
	private int id;
	@Column
	private String comments;
	@Column
	private int rating;
	@Column
	private int reviewedBy;
	
	public Rating() {

	}

	public Rating(int userId, int id, String comments, int rating, int reviewedBy) {

		this.userId = userId;
		this.id = id;
		this.comments = comments;
		this.rating = rating;
		this.reviewedBy = reviewedBy;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
