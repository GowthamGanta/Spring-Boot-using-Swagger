package com.rs.fer.follow.service;

import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.response.SaveFollowerResponse;

public interface FollowerService {
	
	SaveFollowerResponse saveFollower(SaveFollowerRequest request);
	
	

}
