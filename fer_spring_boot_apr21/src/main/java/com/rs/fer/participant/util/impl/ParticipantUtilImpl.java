package com.rs.fer.participant.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.participant.entity.Participant;
import com.rs.fer.participant.request.SavePartcipantRequest;
import com.rs.fer.participant.util.ParticipantUtil;

@Component
public class ParticipantUtilImpl implements ParticipantUtil {

	@Override
	public Participant loadSaveParticipantRequest(SavePartcipantRequest request, int participantId, int groupId) {
		
		Participant participants = new Participant();
		participants.setParticipantId(request.getParticipantId());
		participants.setGroupId(request.getGroupId());

		return participants;

		
	
	}
	
}
