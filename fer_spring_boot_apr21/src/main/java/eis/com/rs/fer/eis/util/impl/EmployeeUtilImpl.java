package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.mapper.AddEmployeeRequestMapper;
import com.rs.fer.eis.mapper.EditEmployeeRequestMapper;
import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.request.EditEmployeeRequest;
import com.rs.fer.eis.request.LoginEmployeeRequest;
import com.rs.fer.eis.util.EmployeeUtil;
import com.rs.fer.util.DateUtil;

@Component
public class EmployeeUtilImpl implements EmployeeUtil {

	@Override
	public Employee loadAddEmployeeRequestToEmployee(AddEmployeeRequest request) {

		Employee employee = AddEmployeeRequestMapper.MAPPER.mapToEmployee(request);
		employee.setCreated(DateUtil.getCurrentDate()); 
		
		return employee;
	}

	@Override
	public Employee loadEditEmployeeRequestToEmployee(EditEmployeeRequest request, Employee employee) {

		employee = EditEmployeeRequestMapper.MAPPER.mapToEmployee(request, employee);
		employee.setUpdated(DateUtil.getCurrentDate()); 
		
		return employee;
	}
	
	@Override
	public Employee loadLoginEmployeeRequestToEmployee(LoginEmployeeRequest request) {

		Employee employee = new Employee();

		employee.setEmail(request.getEmail());
		employee.setPassword(request.getPassword());

		return employee;
	}

}

