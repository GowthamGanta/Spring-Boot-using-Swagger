package com.rs.fer.participant.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.response.SaveParticipantResponse;
import com.rs.fer.participant.service.ParticipantService;
import com.rs.fer.participant.validation.ParticipantValidation;

@RestController
@RequestMapping("/api")
public class ParticipantController {

	@Autowired
	ParticipantService participantService;

	@Autowired
	ParticipantValidation participantValidation;

	@PostMapping("/saveParticipant")
	public SaveParticipantResponse saveParticipant(@RequestBody SaveParticipantRequest request) {

		SaveParticipantResponse response = null;
		Set<String> errorMessages = participantValidation.validateSaveParticipantRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveParticipantResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = participantService.saveParticipant(request);
		}

		return response;
	}

}
