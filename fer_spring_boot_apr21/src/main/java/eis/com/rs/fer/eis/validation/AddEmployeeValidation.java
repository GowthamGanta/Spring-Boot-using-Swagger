package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.AddEmployeeRequest;

public interface AddEmployeeValidation {

	Set<String> validateAddEmployeeRequest(AddEmployeeRequest request);

}
