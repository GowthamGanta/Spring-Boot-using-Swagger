package com.rs.fer.participant.validation.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.participant.request.DeleteParticipantRequest;
import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.validation.ParticipantValidation;
import com.rs.fer.util.FERUtil;

@Component
public class ParticipantValidationImpl implements ParticipantValidation {

	@Override
	public Set<String> validateSaveParticipantRequest(SaveParticipantRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getParticipantId(),
				"Please enter valid participantId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGroupId(), "Please enter valid group id");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteParticipantRequest(DeleteParticipantRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getParticipantId(),
				"Please enter ParticipantId");

		return errorMessages;

	}

}
