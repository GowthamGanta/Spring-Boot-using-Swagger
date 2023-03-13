package com.rs.fer.user.request;

	public class DeleteRatingRequest {
		private String comments;

		private int rating;

		private int reviewerId;

		private int userId;
 
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

		
			
				public int getReviewerId() {
			return reviewerId;
		}

		public void setReviewerId(int reviewerId) {
			this.reviewerId = reviewerId;
		}

				public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		
		}

