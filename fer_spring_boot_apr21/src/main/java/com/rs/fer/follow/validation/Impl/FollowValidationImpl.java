package com.rs.fer.follow.validation.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.follow.request.DeletefollowerRequest;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.validation.FollowValidation;
import com.rs.fer.util.FERUtil;
@Component
public class FollowValidationImpl implements FollowValidation{

	@Override
	public Set<String> validateSaveFollowerRequest(SaveFollowerRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter userId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFollowerId(), "Please enter followerId");


		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteFollowerRequest(DeletefollowerRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter userId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFollowerId(), "Please enter followerId");


		return errorMessages;
	}
	}



