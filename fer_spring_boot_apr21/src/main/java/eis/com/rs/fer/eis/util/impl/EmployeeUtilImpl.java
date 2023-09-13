package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.mapper.EmployeeRequestMapper;
import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.util.EmployeeUtil;
import com.rs.fer.util.DateUtil;

@Component
public class EmployeeUtilImpl implements EmployeeUtil {

	@Override
	public Employee loadAddEmployeeRequestToEmployee(AddEmployeeRequest request) {

		Employee employee = EmployeeRequestMapper.MAPPER.mapToEmployee(request);
		employee.setCreated(DateUtil.getCurrentDate()); 
		
		return employee;
	}

}
