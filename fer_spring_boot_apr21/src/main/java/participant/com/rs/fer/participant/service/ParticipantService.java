package com.rs.fer.participant.service;

import com.rs.fer.participant.request.DeleteParticipantRequest;
import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.response.DeleteParticipantResponse;
import com.rs.fer.participant.response.SaveParticipantResponse;

public interface ParticipantService {

	SaveParticipantResponse saveParticipant(SaveParticipantRequest saveParticipantRequest);

	DeleteParticipantResponse deleteParticipant(DeleteParticipantRequest request);
}
