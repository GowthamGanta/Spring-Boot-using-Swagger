package com.rs.fer.participant.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.participant.Participant;
import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.util.ParticipantUtil;

@Component
public class ParticipantUtilImpl implements ParticipantUtil {

	@Override
	public Participant loadSaveParticipantRequest(SaveParticipantRequest request, int participantId, int groupId) {

		Participant participants = new Participant();
		participants.setParticipantId(request.getParticipantId());
		participants.setGroupId(request.getGroupId());

		return participants;

	}

}