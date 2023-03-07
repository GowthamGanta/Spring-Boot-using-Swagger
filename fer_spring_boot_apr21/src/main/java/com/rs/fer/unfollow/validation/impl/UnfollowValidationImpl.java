package com.rs.fer.unfollow.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.unfollow.request.SaveUnfollowerRequest;
import com.rs.fer.unfollow.validation.UnfollowValidation;
import com.rs.fer.util.FERUtil;
@Component
public class UnfollowValidationImpl implements UnfollowValidation {

	@Override
	public Set<String> validateSaveUnfollowerRequest(SaveUnfollowerRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter userId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUnfollowerId(), "Please enter unfollowerId");


		return errorMessages;

}
}