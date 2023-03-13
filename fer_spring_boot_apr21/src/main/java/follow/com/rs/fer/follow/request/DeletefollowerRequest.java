package com.rs.fer.follow.request;

public class DeletefollowerRequest {
	private int userId;
	private int followerId;

	public int getUserId() {
		return userId;
	}

	public int getFollowerId() {
		return followerId;
	}

	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
