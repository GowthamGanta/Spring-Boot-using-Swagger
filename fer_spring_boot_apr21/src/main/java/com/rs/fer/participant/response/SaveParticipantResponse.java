package com.rs.fer.participant.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.participant.entity.Participant;
import com.rs.fer.response.AbstractResponse;

public class SaveParticipantResponse extends AbstractResponse {

	public SaveParticipantResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		// TODO Auto-generated constructor stub

		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

	private Participant participants;

	public Participant getParticipants() {
		return participants;
	}

	public void setParticipants(Participant participants) {
		this.participants = participants;
	}

	

}
