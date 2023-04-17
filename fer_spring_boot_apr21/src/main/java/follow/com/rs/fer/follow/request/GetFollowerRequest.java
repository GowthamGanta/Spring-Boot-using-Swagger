package com.rs.fer.follow.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetFollowerRequest {
	
	private int userId;

	private int followerId;

}
