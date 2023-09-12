package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.AddEmployeeAddressRequest;

public interface EmployeeAddressValidation {

	Set<String> validateAddEmployeeAddressRequest(AddEmployeeAddressRequest request);

}
