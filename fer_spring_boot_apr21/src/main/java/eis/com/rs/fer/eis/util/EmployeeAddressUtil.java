package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;

public interface EmployeeAddressUtil {

	EmployeeAddress loadAddEmployeeAddressRequestToEmployeeAddress(AddEmployeeAddressRequest request);

	EmployeeAddress loadEditEmployeeAddressRequestToEmployeeAddress(EditEmployeeAddressRequest request, EmployeeAddress employeeAddress);
}
