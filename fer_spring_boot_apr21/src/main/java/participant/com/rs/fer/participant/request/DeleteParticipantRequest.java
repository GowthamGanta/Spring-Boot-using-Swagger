package com.rs.fer.participant.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteParticipantRequest {

	private int groupId;
	
	private int participantId;

}
