package com.rs.fer.eis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.repository.AddEmployeeRepository;
import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.response.AddEmployeeResponse;
import com.rs.fer.eis.service.AddEmployeeService;
import com.rs.fer.eis.util.AddEmployeeUtil;

@Service
public class AddEmployeeServiceImpl implements AddEmployeeService{

	@Autowired 
	AddEmployeeUtil addEmployeeUtil;
	
	@Autowired
	AddEmployeeRepository addEmployeeRepository;
	
	@Override
	public AddEmployeeResponse addEmployee(AddEmployeeRequest request) {
		AddEmployeeResponse response = null;
		
		// Employee is present or not check
		List<Employee> employees = addEmployeeRepository.findByEmail(request.getEmail());
		
		if(!CollectionUtils.isEmpty(employees)) {
			// Employee already there
			response = new AddEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "001", "Employee details exists with the registered email", null);
			return response;
		}
		
		// load vo to bean
		Employee employee = addEmployeeUtil.loadAddEmployeeRequestToEmployee(request);
		
		// save bean to database
		employee = addEmployeeRepository.save(employee);
		
		// load response
		if (employee.getEmployeeId() > 0) {
			response = new AddEmployeeResponse(HttpStatus.OK, "000", "Employee added successfully", null);
			response.setEmployee(employee);
		} else {
			response = new AddEmployeeResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Employee not added", null);
		}
		
		return response;
	}

}
