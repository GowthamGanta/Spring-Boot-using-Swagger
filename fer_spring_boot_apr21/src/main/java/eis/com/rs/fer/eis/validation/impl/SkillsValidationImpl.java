package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.request.SaveSkillsRequest;
import com.rs.fer.eis.validation.SkillsValidation;
import com.rs.fer.util.FERUtil;

@Component
public class SkillsValidationImpl implements SkillsValidation {

	@Override
	public Set<String> validateSaveSkillsRequest(SaveSkillsRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getName(), "Please enter name");

		return errorMessages;
	}

}
