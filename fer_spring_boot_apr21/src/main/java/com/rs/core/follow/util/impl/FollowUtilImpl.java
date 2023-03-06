package com.rs.core.follow.util.impl;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.util.FollowerUtil;

public class FollowUtilImpl implements FollowerUtil {

	@Override
	public Follow loadSaveFollowerRequest(SaveFollowerRequest request, int followerId, int userId) {
		
		Follow follow = new Follow();
		
		
		follow.setFollowerId(request.getFollowerId());
		follow.setUserId(request.getUserId());
		
		return follow;
	}
	

	
}
