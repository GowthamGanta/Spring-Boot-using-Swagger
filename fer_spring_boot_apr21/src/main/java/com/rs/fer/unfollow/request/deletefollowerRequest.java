package com.rs.fer.unfollow.request;

public class deletefollowerRequest {
	private int userId;
	private int followerId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getfollowerId() {
		return followerId;
	}

	public void setfollowerId(int unfollowerId) {
		this.followerId = unfollowerId;
	}

}
