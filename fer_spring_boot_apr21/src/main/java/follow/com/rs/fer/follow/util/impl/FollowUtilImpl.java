package com.rs.fer.follow.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.util.FollowerUtil;
@Component
public class FollowUtilImpl implements FollowerUtil {

	@Override
	public Follow loadSaveFollowerRequest(SaveFollowerRequest request, int followerId, int userId) {
		
		Follow follow = new Follow();
		
		
		follow.setFollowerId(request.getFollowerId());
		follow.setUserId(request.getUserId());
		
		return follow;
	}
	

	
}
