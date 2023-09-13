package com.rs.fer.eis.service;

import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.request.DeleteEmployeeAddressRequest;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;
import com.rs.fer.eis.request.GetEmployeeAddressOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeAddressRequest;
import com.rs.fer.eis.response.AddEmployeeAddressResponse;
import com.rs.fer.eis.response.DeleteEmployeeAddressResponse;
import com.rs.fer.eis.response.EditEmployeeAddressResponse;
import com.rs.fer.eis.response.GetEmployeeAddressOptionsResponse;
import com.rs.fer.eis.response.GetEmployeeAddressResponse;

public interface EmployeeAddressService {

	AddEmployeeAddressResponse addEmployeeAddress(AddEmployeeAddressRequest request);

	EditEmployeeAddressResponse editEmployeeAddress(EditEmployeeAddressRequest request);

	GetEmployeeAddressOptionsResponse getEmployeeAddressOptions(GetEmployeeAddressOptionsRequest request);

	DeleteEmployeeAddressResponse deleteEmployeeAddress(DeleteEmployeeAddressRequest request);

	GetEmployeeAddressResponse getEmployeeAddress(GetEmployeeAddressRequest request);
}
