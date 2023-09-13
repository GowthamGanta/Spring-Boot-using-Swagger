package com.rs.fer.eis.service;

import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.request.DeleteEmployeeRequest;
import com.rs.fer.eis.request.EditEmployeeRequest;
import com.rs.fer.eis.request.GetEmployeeRequest;
import com.rs.fer.eis.response.AddEmployeeResponse;
import com.rs.fer.eis.response.DeleteEmployeeResponse;
import com.rs.fer.eis.response.EditEmployeeResponse;
import com.rs.fer.eis.response.GetEmployeeResponse;

public interface EmployeeService {
	
	AddEmployeeResponse addEmployee(AddEmployeeRequest request);
	
	EditEmployeeResponse editEmployee(EditEmployeeRequest request);

	DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequest request);
	
	GetEmployeeResponse getEmployee(GetEmployeeRequest request);
}


