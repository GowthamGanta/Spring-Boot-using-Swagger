package com.rs.fer.participant.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.participant.Participant;
import com.rs.fer.participant.mapper.SaveParticipantRequestMapper;
import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.util.ParticipantUtil;

@Component
public class ParticipantUtilImpl implements ParticipantUtil {

	@Override
	public Participant loadSaveParticipantRequest(SaveParticipantRequest request, int participantId, int groupId) {

		Participant participants = SaveParticipantRequestMapper.MAPPER.mapToParticipant(request);

		return participants;

	}

}
