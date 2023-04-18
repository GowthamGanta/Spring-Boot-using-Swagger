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
	private int id;
	
	private String comments;
	
	private int rating;
	
	private int reviewedBy;
	
	private int userId;
	
	private String created;
	
	private String updated;
	
	public Rating() {

	}

	public Rating(int id, String comments, int rating, int reviewedBy, int userId) {

		
		this.id = id;
		this.comments = comments;
		this.rating = rating;
		this.reviewedBy = reviewedBy;
		this.userId = userId;
	}

	public int getRatingId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getBlockStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmailVerify() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMobileVerify() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
