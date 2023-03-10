package com.rs.fer.participant.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.participant.Participant;
import com.rs.fer.participant.request.SaveParticipantRequest;

@SpringBootTest
public class ParticipantUtilImplTest {

	@InjectMocks
	private ParticipantUtilImpl participantUtilImpl;

	@Test
	public void loadSaveParticipantRequest() {
		SaveParticipantRequest request = new SaveParticipantRequest();
		request.setGroupId(1);
		request.setParticipantId(2);

		Participant participant = participantUtilImpl.loadSaveParticipantRequest(request, 2, 1);
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != participant.getParticipantId() && 0 != participant.getGroupId());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	
	@Test
	public void loadSaveParticipantRequestFailure() {
		SaveParticipantRequest request = new SaveParticipantRequest();
		//request.setGroupId(1);
		request.setParticipantId(2);

		Participant participant = participantUtilImpl.loadSaveParticipantRequest(request, 2, 1);
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = (0 != participant.getParticipantId() && 0 != participant.getGroupId());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}


}
