package com.rs.fer.eis.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.request.DeleteEmployeeAddressRequest;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;
import com.rs.fer.eis.request.GetEmployeeAddressOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeAddressRequest;
import com.rs.fer.eis.validation.EmployeeAddressValidation;
import com.rs.fer.util.FERUtil;

@Component
public class EmployeeAddressValidationImpl implements EmployeeAddressValidation {

	@Override
	public Set<String> validateAddEmployeeAddressRequest(AddEmployeeAddressRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter employeeId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLineOne(), "Please enter Line One");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCity(), "Please enter City");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getState(), "Please enter State");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPinCode(), "Please enter pincode");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCountry(), "Please enter Country");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getAddressType(), "Please enter Address Type");

		return errorMessages;
	}

	@Override
	public Set<String> validateEditEmployeeAddressRequest(EditEmployeeAddressRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Address Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLineOne(), "Please enter Line One");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCity(), "Please enter City");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getState(), "Please enter State");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPinCode(), "Please enter pincode");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCountry(), "Please enter Country");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getAddressType(), "Please enter Address Type");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetEmployeeAddressOptionsRequest(GetEmployeeAddressOptionsRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmployeeId(), "Please enter Employee Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteEmployeeAddressRequest(DeleteEmployeeAddressRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please select  Address Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetEmployeeAddressRequest(GetEmployeeAddressRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Address Id");

		return errorMessages;

	}

}
