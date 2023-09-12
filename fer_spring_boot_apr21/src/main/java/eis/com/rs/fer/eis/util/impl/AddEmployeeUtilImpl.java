package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.mapper.AddEmployeeRequestMapper;
import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.util.AddEmployeeUtil;
import com.rs.fer.util.DateUtil;

@Component
public class AddEmployeeUtilImpl implements AddEmployeeUtil {

	@Override
	public Employee loadAddEmployeeRequestToEmployee(AddEmployeeRequest request) {

		Employee employee = AddEmployeeRequestMapper.MAPPER.mapToEmployee(request);
		employee.setCreated(DateUtil.getCurrentDate()); 
		
		return employee;
	}

}
