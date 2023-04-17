package com.rs.fer.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditRatingRequest {

	private String comments;

	private int rating;

	private int reviewerId;

	private int userId;
}
