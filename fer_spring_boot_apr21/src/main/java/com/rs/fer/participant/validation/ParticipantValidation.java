package com.rs.fer.participant.validation;

import java.util.Set;

import com.rs.fer.participant.request.SavePartcipantRequest;

public interface ParticipantValidation {

	Set<String> validateSavePartcipantRequest(SavePartcipantRequest request);

}
