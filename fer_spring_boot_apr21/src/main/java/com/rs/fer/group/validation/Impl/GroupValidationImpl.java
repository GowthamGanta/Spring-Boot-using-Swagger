package com.rs.fer.group.validation.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.group.request.DeleteGroupRequest;
import com.rs.fer.group.request.GetGroupRequest;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.validation.GroupValidation;
import com.rs.fer.util.FERUtil;

@Component
public abstract class GroupValidationImpl implements GroupValidation {

	@Override
	public Set<String> validateSaveGroupRequest(SaveGroupRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter valid id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGroupName(), "Please enter  group name");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetGroupRequest(GetGroupRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGroupId(), "Please enter Valid groupId");

		return errorMessages;
	}
	
	@Override
	public Set<String> validateDeleteGroupRequest(DeleteGroupRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGroupId(), "Please enter Valid groupId");

		return errorMessages;
	}

	
}
