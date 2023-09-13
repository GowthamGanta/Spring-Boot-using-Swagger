package com.rs.fer.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveSkillsResponse extends AbstractResponse {

	private Skills skills;

	public SaveSkillsResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

}
