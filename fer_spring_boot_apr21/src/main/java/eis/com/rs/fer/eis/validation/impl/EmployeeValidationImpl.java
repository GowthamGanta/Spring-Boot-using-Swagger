package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.request.DeleteEmployeeRequest;
import com.rs.fer.eis.request.EditEmployeeRequest;
import com.rs.fer.eis.request.GetEmployeeRequest;
import com.rs.fer.eis.request.LoginEmployeeRequest;
import com.rs.fer.eis.validation.EmployeeValidation;
import com.rs.fer.util.FERUtil;

@Component
public class EmployeeValidationImpl implements EmployeeValidation {

	@Override
	public Set<String> validateAddEmployeeRequest(AddEmployeeRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirstName(), "Please enter First Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLastName(), "Please enter Last Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDateOfBirth(), "Please enter Date of birth");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGender(), "Please enter Gender");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmail(), "Please enter Email");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPassword(), "Please enter Password");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMobile(), "Please enter Mobile");

		return errorMessages;
	}

	@Override
	public Set<String> validateEditEmployeeRequest(EditEmployeeRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter employee Id");
		
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirstName(), "Please enter First Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLastName(), "Please enter Last Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDateOfBirth(), "Please enter Date of birth");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getGender(), "Please enter Gender");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmail(), "Please enter Email");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPassword(), "Please enter Password");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMobile(), "Please enter Mobile");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteEmployeeRequest(DeleteEmployeeRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter employee Id");
		
		return errorMessages;
	}

	@Override
	public Set<String> validateGetEmployeeRequest(GetEmployeeRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();
		
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter valid employee Id");
	
		return errorMessages;
		
	}
	@Override
	public Set<String> validateLoginEmployeeRequest(LoginEmployeeRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmail(), "Please enter Email");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPassword(), "Please enter Password");

		return errorMessages;
	}

}

