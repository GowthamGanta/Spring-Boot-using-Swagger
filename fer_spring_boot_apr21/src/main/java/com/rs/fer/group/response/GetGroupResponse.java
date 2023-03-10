package com.rs.fer.group.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.group.entity.Group;
import com.rs.fer.response.AbstractResponse;

public class GetGroupResponse extends AbstractResponse {

	public GetGroupResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);

		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

	private Set<Group> group;

	public Set<Group> getgroup() {
		return group;
	}

	public void setGroup(Set<Group> group) {
		this.group = group;
	}

}
