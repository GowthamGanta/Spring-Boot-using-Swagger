package com.rs.fer.admin.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.GetBlockUserRequest;
import com.rs.fer.admin.request.GetUnblockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.validation.AdminValidation;
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

	@Override
	public Set<String> validateGetBlockUserRequest(GetBlockUserRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetUnblockUserRequest(GetUnblockUserRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");

		return errorMessages;
	}

}
