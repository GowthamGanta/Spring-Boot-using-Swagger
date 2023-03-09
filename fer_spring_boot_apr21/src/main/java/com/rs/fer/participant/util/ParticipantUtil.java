package com.rs.fer.participant.util;

import com.rs.fer.participant.entity.Participant;
import com.rs.fer.participant.request.SavePartcipantRequest;

public interface ParticipantUtil {
	
	Participant loadSaveParticipantRequest(SavePartcipantRequest request, int participantId, int groupId);

}
