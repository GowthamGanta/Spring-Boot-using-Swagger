package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.request.AddEmployeeRequest;

public interface EmployeeUtil {

	Employee loadAddEmployeeRequestToEmployee(AddEmployeeRequest request);

}
