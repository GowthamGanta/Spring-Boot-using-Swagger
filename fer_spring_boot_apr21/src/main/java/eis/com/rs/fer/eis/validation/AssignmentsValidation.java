package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.AddAssignmentsRequest;


public interface AssignmentsValidation {

	Set<String> validateAddAssignmentsRequest(AddAssignmentsRequest request);	

}
