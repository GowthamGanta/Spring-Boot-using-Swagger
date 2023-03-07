package com.rs.fer.unfollow.validation;

import java.util.Set;

import com.rs.fer.unfollow.request.SaveUnfollowerRequest;

public interface UnfollowValidation {

	Set<String> validateSaveUnfollowerRequest(SaveUnfollowerRequest request);
}
