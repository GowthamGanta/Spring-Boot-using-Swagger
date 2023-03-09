package com.rs.fer.participant.service;

import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.response.SaveParticipantResponse;

public interface ParticipantService {

	SaveParticipantResponse saveParticipantResponse(SaveParticipantRequest saveParticipantRequest);
}
