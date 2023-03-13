package com.rs.fer.group.response;

import java.security.acl.Group;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.response.AbstractResponse;

public class SaveGroupResponse extends AbstractResponse{
	
	public SaveGroupResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		
		super(status, statusCode, message, errorMessages);
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}
	
	private Group Group;

	public Group getGroup() {
		return Group;
	}

	public void setGroup(Group group) {
		Group = group;
	}
	

}
