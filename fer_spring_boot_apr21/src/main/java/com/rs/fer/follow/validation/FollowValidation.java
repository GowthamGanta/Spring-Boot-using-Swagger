package com.rs.fer.follow.validation;

import java.util.Set;

import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.message.request.SaveMessageRequest;

public interface FollowValidation {
	
	Set<String> validateSaveFollowerRequest(SaveFollowerRequest request);

}
