package com.rs.fer.eis.service;

import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.response.AddEmployeeResponse;

public interface AddEmployeeService {
	
	AddEmployeeResponse addEmployee(AddEmployeeRequest request);
	
}