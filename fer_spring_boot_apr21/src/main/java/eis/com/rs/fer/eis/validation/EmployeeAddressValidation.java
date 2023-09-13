package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.request.DeleteEmployeeAddressRequest;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;
import com.rs.fer.eis.request.GetEmployeeAddressOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeAddressRequest;

public interface EmployeeAddressValidation {

	Set<String> validateAddEmployeeAddressRequest(AddEmployeeAddressRequest request);

	Set<String> validateEditEmployeeAddressRequest(EditEmployeeAddressRequest request);

	Set<String> validateGetEmployeeAddressOptionsRequest(GetEmployeeAddressOptionsRequest request);

	Set<String> validateDeleteEmployeeAddressRequest(DeleteEmployeeAddressRequest request);

	Set<String> validateGetEmployeeAddressRequest(GetEmployeeAddressRequest request);
}
