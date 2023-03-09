package com.rs.fer.group.validation.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.validation.GroupValidation;
import com.rs.fer.util.FERUtil;

@Component
public class GroupValidationImpl implements GroupValidation {

	@Override
	public Set<String> validateSaveGroupRequest(SaveGroupRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter valid id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGroupName(), "Please enter  group name");

		return errorMessages;
	}

}
