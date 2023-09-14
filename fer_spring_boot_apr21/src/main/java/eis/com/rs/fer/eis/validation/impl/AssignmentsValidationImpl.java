package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.request.AddAssignmentsRequest;
import com.rs.fer.eis.request.DeleteAssignmentsRequest;
import com.rs.fer.eis.request.EditAssignmentsRequest;
import com.rs.fer.eis.request.GetAssignmentsOptionsRequest;
import com.rs.fer.eis.request.GetAssignmentsRequest;
import com.rs.fer.eis.validation.AssignmentsValidation;
import com.rs.fer.util.FERUtil;

@Component
public class AssignmentsValidationImpl implements AssignmentsValidation {

	public Set<String> validateAddAssignmentsRequest(AddAssignmentsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getAssignmentName(),
				"Please enter assignmentName");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getStartDate(), "Please enter startDate");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEndDate(), "Please enter endDate");

		return errorMessages;
	}

	@Override
	public Set<String> validateEditAssignmentsRequest(EditAssignmentsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getAssignmentName(),
				"Please enter assignmentName");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getStartDate(), "Please enter startDate");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEndDate(), "Please enter endDate");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteAssignmentsRequest(DeleteAssignmentsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetAssignmentsOptionsRequest(GetAssignmentsOptionsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetAssignmentsRequest(GetAssignmentsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getRoleId(), "Please enter Id");

		return null;
	}

}
