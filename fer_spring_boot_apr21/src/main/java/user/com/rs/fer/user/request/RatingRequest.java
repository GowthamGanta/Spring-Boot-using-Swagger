package com.rs.fer.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingRequest {

	private String Comments;

	private int Rating;

	private int Reviewedby;

	private int userId;

	
}
