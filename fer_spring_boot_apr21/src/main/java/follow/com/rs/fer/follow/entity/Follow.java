package com.rs.fer.follow.entity;

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
@Table(name = "follow")
public class Follow {
	@Id
	@Column(name = "follow_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@Column(name="user_id")
	private int userId;
	
	@Column
	private int followerId;
	
	@Column
	private String created;
	
	@Column
	private String updated;

	public Follow() {

	}

	public Follow(int userId, int followerId) {
		this.followerId = followerId;
		this.userId = userId;

	}
}