package com.rs.fer.participant.validation;

import java.util.Set;

import com.rs.fer.participant.request.DeleteParticipantRequest;
import com.rs.fer.participant.request.SaveParticipantRequest;

public interface ParticipantValidation {

	Set<String> validateSaveParticipantRequest(SaveParticipantRequest request);
	
	Set<String> validateDeleteParticipantRequest(DeleteParticipantRequest request);


}
