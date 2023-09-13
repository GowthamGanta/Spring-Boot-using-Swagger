package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

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

}
