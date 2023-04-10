package com.rs.fer.ipl.validation.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.validation.TeamValidation;
import com.rs.fer.util.FERUtil;

@Component
public class TeamValidationImpl implements TeamValidation {

	@Override
	public Set<String> validateSaveTeamRequest(SaveTeamRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getName(), "Please enter Name");
		return errorMessages;
	}

	@Override
	public Set<String> validateGetTeamRequest(Integer teamId) {

		Set<String> errorMessages = new HashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, teamId, "Please enter valid teamId");

		return errorMessages;
	}

}
