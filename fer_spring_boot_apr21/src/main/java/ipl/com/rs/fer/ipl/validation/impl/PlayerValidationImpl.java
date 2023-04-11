package com.rs.fer.ipl.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;
import com.rs.fer.ipl.validation.PlayerValidation;
import com.rs.fer.util.FERUtil;

@Component
public class PlayerValidationImpl implements PlayerValidation {

	@Override
	public Set<String> validateSavePlayerRequest(SavePlayerRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirstName(), "Please enter First Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLastName(), "Please enter Lastname");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGender(), "Please enter Gender");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDob(), "Please enter Dob");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getRole(), "Please enter Role");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getSpecilization(),
				"Please enter Specialization");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getJerseyNumber(), "Please entre JerseyNumber");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeletePlayerRequest(int playerId) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, playerId, "Please enter valid PlayerId");

		return errorMessages;

	}

	@Override
	public Set<String> validateGetPlayersRequest(Integer teamId) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, teamId, "Please enter TeamId");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetPlayerRequest(Integer playerId) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, playerId, "Please enter PlayerId");

		return errorMessages;
	}

	@Override
	public Set<String> validateUpdatePlayerRequest(UpdatePlayerRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirstName(), "Please enter First Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLastName(), "Please enter Lastname");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGender(), "Please enter Gender");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDob(), "Please enter Dob");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getRole(), "Please enter Role");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getSpecilization(),
				"Please enter Specialization");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getJerseyNumber(), "Please entre JerseyNumber");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPlayerId(), "Plaese entre PlayerId");

		return errorMessages;
	}

}
