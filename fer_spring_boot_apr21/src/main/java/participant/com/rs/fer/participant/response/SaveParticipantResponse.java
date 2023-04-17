package com.rs.fer.participant.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.participant.Participant;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveParticipantResponse extends AbstractResponse {

	public SaveParticipantResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);

		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

	private Participant participants;
}
