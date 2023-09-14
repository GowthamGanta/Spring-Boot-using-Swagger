package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.rs.fer.eis.request.DeleteEmployeeSkillsRequest;
import com.rs.fer.eis.request.EditEmployeeSkillsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsRequest;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
import com.rs.fer.eis.validation.EmployeeSkillsValidation;
import com.rs.fer.util.FERUtil;

@Service
public class EmployeeSkillsValidationImpl implements EmployeeSkillsValidation {

	@Override
	public Set<String> validateSaveEmployeeSkillsRequest(SaveEmployeeSkillsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter employeeId");

		return errorMessages;
	}

	@Override
	public Set<String> validateEditEmployeeSkillsRequest(EditEmployeeSkillsRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter employeeId");

		return errorMessages;

	}

	@Override
	public Set<String> validateDeleteEmployeeSkillsRequest(DeleteEmployeeSkillsRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter employeeId");

		return errorMessages;

	}

	@Override
	public Set<String> validateGetEmployeeSkillsRequest(GetEmployeeSkillsRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter employeeId");

		return errorMessages;

	}

	@Override
	public Set<String> validateGetEmployeeSkillsOptionsRequest(GetEmployeeSkillsOptionsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter Id");

		return errorMessages;

	}

}
