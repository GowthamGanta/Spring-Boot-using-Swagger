package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.request.EducationalDetailsRequest;
import com.rs.fer.eis.validation.EducationalDetailsValidation;
import com.rs.fer.util.FERUtil;

@Component
public class EducationalDetailsValidationImpl implements EducationalDetailsValidation {

	@Override
	public Set<String> validateSaveEducationalDetailsRequest(EducationalDetailsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter employee Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getType(), "Please enter Type");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getYearOfPassing(),
				"Please enter YearOfPassing");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUniversity(), "Please enter University");

		return errorMessages;
	}

}
