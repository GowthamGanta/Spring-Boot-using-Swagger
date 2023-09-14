package com.rs.fer.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.eis.entity.EmployeeRole;
import com.rs.fer.eis.entity.Role;
import com.rs.fer.response.AbstractResponse;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DeleteAssignmentsResponse extends AbstractResponse{

	private Role assignments;
	
	public DeleteAssignmentsResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);

		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;
	}

	public void setAssignments(EmployeeRole employeeRole) {
		// TODO Auto-generated method stub
		
	}
}
