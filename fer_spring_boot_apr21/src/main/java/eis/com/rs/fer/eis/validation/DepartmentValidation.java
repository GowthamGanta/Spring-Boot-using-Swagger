package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.AddDepartmentRequest;

public interface DepartmentValidation {

	Set<String> validateAddDepartmentRequest(AddDepartmentRequest request);

	
	
}