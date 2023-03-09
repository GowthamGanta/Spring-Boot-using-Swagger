package com.rs.fer.participant.util;

import com.rs.fer.participant.entity.Participant;
import com.rs.fer.participant.request.SaveParticipantRequest;

public interface ParticipantUtil {
	
	Participant loadSaveParticipantRequest(SaveParticipantRequest request, int participantId, int groupId);

}
