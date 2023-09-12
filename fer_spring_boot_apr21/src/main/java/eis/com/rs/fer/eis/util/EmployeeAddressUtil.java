package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.request.AddEmployeeAddressRequest;

public interface EmployeeAddressUtil {

	EmployeeAddress loadAddEmployeeAddressRequestToEmployeeAddress(AddEmployeeAddressRequest request);

}
