package com.rs.fer.participant.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.validation.Impl.ParticipantValidationImpl;

@SpringBootTest
public class ParticipantValidationImplTest {

	@InjectMocks
	public ParticipantValidationImpl participantValidationImpl;

	@Test
	public void testValidateSaveParticipantRequest() {

		SaveParticipantRequest request = new SaveParticipantRequest();
		request.setParticipantId(2);
		request.setGroupId(1);

		Set<String> participant = participantValidationImpl.validateSaveParticipantRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = participant.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateSaveParticipantRequestFailure() {

		SaveParticipantRequest request = new SaveParticipantRequest();

		// request.setUserId(4);

		Set<String> participant = participantValidationImpl.validateSaveParticipantRequest(request);

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = participant.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

}
