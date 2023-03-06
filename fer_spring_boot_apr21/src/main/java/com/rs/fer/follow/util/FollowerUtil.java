package com.rs.fer.follow.util;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.follow.request.SaveFollowerRequest;

public interface FollowerUtil {
	
	Follow loadSaveFollowerRequest(SaveFollowerRequest request, int followerId);

}
