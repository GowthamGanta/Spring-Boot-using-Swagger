package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.request.AddEmployeeRequest;

public interface AddEmployeeUtil {

	Employee loadAddEmployeeRequestToEmployee(AddEmployeeRequest request);

}
