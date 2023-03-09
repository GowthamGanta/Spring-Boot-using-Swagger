package com.rs.fer.participant.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.repository.GroupRepository;
import com.rs.fer.participant.Participant;
import com.rs.fer.participant.repository.ParticipantRepository;
import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.response.SaveParticipantResponse;
import com.rs.fer.participant.service.ParticipantService;
import com.rs.fer.participant.util.ParticipantUtil;
import com.rs.fer.user.repository.UserRepository;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	ParticipantUtil participantUtil;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ParticipantRepository participantRepository;

	@Autowired
	GroupRepository groupRepository;

	@Override
	public SaveParticipantResponse saveParticipantResponse(SaveParticipantRequest request) {
		SaveParticipantResponse response = null;

		Participant participants = new Participant();

		Optional<Group> userObj = groupRepository.findById(request.getGroupId());
		if (!userObj.isPresent()) {
			response = new SaveParticipantResponse(HttpStatus.OK, "999", " No Group Present", null);
		}

		participants = participantUtil.loadSaveParticipantRequest(request, request.getParticipantId(),
				request.getGroupId());

		participantRepository.save(participants);

		// response if success
		if (participants.getId() > 0) {
			response = new SaveParticipantResponse(HttpStatus.OK, "000", " Participant added into group Successfully",
					null);

		} else {
			// response if failure
			response = new SaveParticipantResponse(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Participant adding failed",
					null);

		}

		return response;
	}

}
