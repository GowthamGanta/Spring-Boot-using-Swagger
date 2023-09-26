package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.request.EditEmployeeRequest;
import com.rs.fer.eis.request.LoginEmployeeRequest;

public interface EmployeeUtil {

	Employee loadAddEmployeeRequestToEmployee(AddEmployeeRequest request);

	Employee loadEditEmployeeRequestToEmployee(EditEmployeeRequest request, Employee employee);

	Employee loadLoginEmployeeRequestToEmployee(LoginEmployeeRequest request);
}

