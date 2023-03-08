package com.rs.fer.follow.validation;

import java.util.Set;

import com.rs.fer.follow.request.DeletefollowerRequest;
import com.rs.fer.follow.request.GetFollowersRequest;
import com.rs.fer.follow.request.SaveFollowerRequest;

public interface FollowValidation {

	Set<String> validateSaveFollowerRequest(SaveFollowerRequest request);

	Set<String> validateDeleteFollowerRequest(DeletefollowerRequest request);
	
	Set<String> validateGetFollowersRequest(GetFollowersRequest request);
}
