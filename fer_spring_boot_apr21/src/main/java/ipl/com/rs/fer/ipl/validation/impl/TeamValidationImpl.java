package com.rs.fer.ipl.validation.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.ipl.request.DeleteTeamRequest;
import com.rs.fer.ipl.request.EditTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.validation.TeamValidation;
import com.rs.fer.util.FERUtil;

@Component
public class TeamValidationImpl implements TeamValidation {

	@Override
	public Set<String> validateSaveTeamRequest(SaveTeamRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getName(), "Please enter Name");

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getTeamCode(), "Please entre teamCode");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetTeamRequest(Integer teamId) {

		Set<String> errorMessages = new HashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, teamId, "Please enter valid teamId");
		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteTeamRequest(DeleteTeamRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getTeamId(), "Please enter Valid TeamId");
		return errorMessages;
	}

	@Override
	public Set<String> validateEditTeamRequest(EditTeamRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getTeamId(), "Please entre teamId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getName(), "Please entre Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getTeamCode(), "Please entre teamCode");

		return errorMessages;
	}

}
