package com.rs.fer.user.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.user.request.BlockUserRequest;
import com.rs.fer.user.request.UnblockUserRequest;
import com.rs.fer.user.validation.AdminValidation;

import com.rs.fer.util.FERUtil;

@Component
public class AdminValidationImpl implements AdminValidation {

	@Override
	public Set<String> validateBlockUserRequest(BlockUserRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateUnblockUserRequest(UnblockUserRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");

		return errorMessages;

	}

}
