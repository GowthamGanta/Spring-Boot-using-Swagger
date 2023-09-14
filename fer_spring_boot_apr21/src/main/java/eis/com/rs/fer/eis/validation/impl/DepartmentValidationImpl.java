package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.request.DeleteDepartmentRequest;
import com.rs.fer.eis.request.EditDepartmentRequest;
import com.rs.fer.eis.request.GetDepartmentOptionsRequest;
import com.rs.fer.eis.request.GetDepartmentRequest;
import com.rs.fer.eis.validation.DepartmentValidation;
import com.rs.fer.util.FERUtil;

@Component
public class DepartmentValidationImpl implements DepartmentValidation {

	@Override
	public Set<String> validateAddDepartmentRequest(AddDepartmentRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDepartmentName(),
				"Please enter departmentName");

		return errorMessages;
	}

	@Override
	public Set<String> validateEditDepartmentRequest(EditDepartmentRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getDepartmentName(),
				"Please enter departmentName");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteDepartmentRequest(DeleteDepartmentRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");
		return errorMessages;
	}

	@Override
	public Set<String> validateGetDepartmentRequest(GetDepartmentRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");
		return errorMessages;
	}

	@Override
	public Set<String> validateGetDepartmentOptionsRequest(GetDepartmentOptionsRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeid(), "Please enter Id");

		return errorMessages;
	}

}


