package com.rs.fer.unfollow.request;

public class SaveUnfollowerRequest {
	private int userId;
	private int unfollowerId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUnfollowerId() {
		return unfollowerId;
	}

	public void setUnfollowerId(int unfollowerId) {
		this.unfollowerId = unfollowerId;
	}

}
