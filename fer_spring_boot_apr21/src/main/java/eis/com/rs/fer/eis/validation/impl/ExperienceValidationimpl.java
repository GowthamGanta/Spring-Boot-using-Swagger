package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.request.DeleteEmployeeExperienceRequest;
import com.rs.fer.eis.request.EditExperienceRequest;
import com.rs.fer.eis.request.GetEmployeeExperienceRequest;
import com.rs.fer.eis.request.GetExperienceOptionsRequest;
import com.rs.fer.eis.request.SaveExperienceRequest;
import com.rs.fer.eis.validation.ExperienceValidation;
import com.rs.fer.util.FERUtil;

@Component
public class ExperienceValidationimpl implements ExperienceValidation {

	@Override
	public Set<String> validateSaveExperienceRequest(SaveExperienceRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter employeeId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirm(), "Please enter firm");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFromDate(), "Please enter fromdate");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getToDate(), "Please enter todate");
		return errorMessages;
	}

	@Override
	public Set<String> validateEditExperienceRequest(EditExperienceRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter employeeId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirm(), "Please enter firm");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFromDate(), "Please enter fromdate");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getToDate(), "Please enter todate");
		return errorMessages;
	}

	@Override
	public Set<String> validateGetExperienceRequest(GetExperienceOptionsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter employeeId");
		
		
		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteEmployeeExperienceRequest(DeleteEmployeeExperienceRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");
		return errorMessages;
	}

	@Override
	public Set<String> validateGetEmployeeExperienceRequest(GetEmployeeExperienceRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");
		
		return errorMessages;
	}

}
