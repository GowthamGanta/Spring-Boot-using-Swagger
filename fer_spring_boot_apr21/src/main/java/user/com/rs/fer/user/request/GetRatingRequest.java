package com.rs.fer.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRatingRequest {

	private int ratingId;
	
	private int userId;
}
