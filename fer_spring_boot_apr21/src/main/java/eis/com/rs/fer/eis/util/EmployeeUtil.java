package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.request.EditEmployeeRequest;

public interface EmployeeUtil {

	Employee loadAddEmployeeRequestToEmployee(AddEmployeeRequest request);

	Employee loadEditEmployeeRequestToEmployee(EditEmployeeRequest request, Employee employee);

}

