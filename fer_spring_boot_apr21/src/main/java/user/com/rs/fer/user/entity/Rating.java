package com.rs.fer.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Rating {

	@Id
	@Column(name = "rating_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;
	
	private String comments;
	
	private int rating;
	
	private int reviewedBy;
	
	private int userId;
	
	private String created;
	
	private String updated;
	
	public Rating() {

	}

	public Rating(int id, String comments, int rating, int reviewedBy, int userId) {

		
		this.ratingId = id;
		this.comments = comments;
		this.rating = rating;
		this.reviewedBy = reviewedBy;
		this.userId = userId;
	}
	
}
