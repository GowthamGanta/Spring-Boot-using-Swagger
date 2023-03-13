package com.rs.fer.participant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.rs.fer.follow.request.DeletefollowerRequest;
import com.rs.fer.follow.request.GetFollowersRequest;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.response.DeletefollowerResponse;
import com.rs.fer.follow.response.GetFollowersResponse;
import com.rs.fer.follow.response.SaveFollowerResponse;
import com.rs.fer.follow.service.FollowerService;
import com.rs.fer.follow.validation.FollowValidation;
import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.response.DeleteMessageResponse;
import com.rs.fer.participant.request.DeleteParticipantRequest;
import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.response.DeleteParticipantResponse;
import com.rs.fer.participant.response.SaveParticipantResponse;
import com.rs.fer.participant.service.ParticipantService;
import com.rs.fer.participant.validation.ParticipantValidation;

@SpringBootTest
public class ParticipantControllerTest {

	@InjectMocks
	private ParticipantController participantController;

	@Mock
	ParticipantValidation participantValidation;

	@Mock
	ParticipantService participantService;

	@Test
	public void testSaveParticipant() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		SaveParticipantRequest request = new SaveParticipantRequest();
		SaveParticipantResponse response = new SaveParticipantResponse(HttpStatus.OK, "000", "", null);

		// when
		when(participantValidation.validateSaveParticipantRequest(Mockito.any())).thenReturn(errorMessages);
		when(participantService.saveParticipant(Mockito.any())).thenReturn(response);

		// Then
		SaveParticipantResponse saveResponse = participantController.saveParticipant(request);

		assertEquals("000", saveResponse.statusCode);

	}

	@Test
	public void testSaveParticipantFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter userId");

		SaveParticipantRequest request = new SaveParticipantRequest();

		// when
		when(participantValidation.validateSaveParticipantRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		SaveParticipantResponse response = participantController.saveParticipant(request);

		assertEquals("999", response.statusCode);

	}

	@Test
	public void testDeleteParticipant() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		DeleteParticipantRequest request = new DeleteParticipantRequest();
		DeleteParticipantResponse response = new DeleteParticipantResponse(HttpStatus.OK, "000", "", null);

		// when
		when(participantValidation.validateDeleteParticipantRequest(Mockito.any())).thenReturn(errorMessages);
		when(participantService.deleteParticipant(Mockito.any())).thenReturn(response);

		// Then
		DeleteParticipantResponse Response = participantController.deleteParticipant(request);

		assertEquals("000", Response.statusCode);

	}

	@Test
	public void testDeleteParticipantFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter id");

		DeleteParticipantRequest request = new DeleteParticipantRequest();

		// when
		when(participantValidation.validateDeleteParticipantRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		DeleteParticipantResponse response = participantController.deleteParticipant(request);

		assertEquals("999", response.statusCode);

	}

}