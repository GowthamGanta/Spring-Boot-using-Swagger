package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.request.DeleteDepartmentRequest;
import com.rs.fer.eis.request.EditDepartmentRequest;
import com.rs.fer.eis.request.GetDepartmentOptionsRequest;
import com.rs.fer.eis.request.GetDepartmentRequest;

public interface DepartmentValidation {

	Set<String> validateAddDepartmentRequest(AddDepartmentRequest request);

	Set<String> validateEditDepartmentRequest(EditDepartmentRequest request);

	Set<String> validateDeleteDepartmentRequest(DeleteDepartmentRequest request);

	Set<String> validateGetDepartmentRequest(GetDepartmentRequest request);

	Set<String> validateGetDepartmentOptionsRequest(GetDepartmentOptionsRequest request);
	
	

}
