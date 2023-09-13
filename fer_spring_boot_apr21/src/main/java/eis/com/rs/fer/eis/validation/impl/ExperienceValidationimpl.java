package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.request.SaveExperienceRequest;
import com.rs.fer.eis.validation.ExperienceValidation;
import com.rs.fer.util.FERUtil;
@Component
public class ExperienceValidationimpl implements ExperienceValidation {

	@Override
	public Set<String> validateSaveExperienceRequest(SaveExperienceRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>(); 
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEid(), "Please enter employeeId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirm(), "Please enter firm");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFromDate(), "Please enter date");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getToDate(), "Please enter date");
		return errorMessages;
	}

}
