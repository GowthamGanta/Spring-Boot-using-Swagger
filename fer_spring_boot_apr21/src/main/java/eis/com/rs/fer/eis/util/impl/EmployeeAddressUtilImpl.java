package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.mapper.EmployeeAddressRequestMapper;
import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.util.EmployeeAddressUtil;
import com.rs.fer.util.DateUtil;

@Component
public class EmployeeAddressUtilImpl implements EmployeeAddressUtil {

	@Override
	public EmployeeAddress loadAddEmployeeAddressRequestToEmployeeAddress(AddEmployeeAddressRequest request) {

		EmployeeAddress employeeAddress = EmployeeAddressRequestMapper.MAPPER.mapToEmployeeAddress(request);
		employeeAddress.setCreated(DateUtil.getCurrentDate());

		return employeeAddress;
	}

}
