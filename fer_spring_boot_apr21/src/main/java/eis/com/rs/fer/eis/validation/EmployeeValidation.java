package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.request.DeleteEmployeeRequest;
import com.rs.fer.eis.request.EditEmployeeRequest;
import com.rs.fer.eis.request.GetEmployeeRequest;
import com.rs.fer.eis.request.LoginEmployeeRequest;

public interface EmployeeValidation {

	Set<String> validateAddEmployeeRequest(AddEmployeeRequest request);
	
	Set<String> validateEditEmployeeRequest(EditEmployeeRequest request);
	
	Set<String> validateDeleteEmployeeRequest(DeleteEmployeeRequest request);
	
	Set<String> validateGetEmployeeRequest(GetEmployeeRequest request);

	Set<String> validateLoginEmployeeRequest(LoginEmployeeRequest request);
}

