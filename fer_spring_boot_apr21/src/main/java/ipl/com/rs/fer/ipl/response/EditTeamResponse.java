package com.rs.fer.ipl.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditTeamResponse extends AbstractResponse {
	public EditTeamResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

	private Team teamId;
}