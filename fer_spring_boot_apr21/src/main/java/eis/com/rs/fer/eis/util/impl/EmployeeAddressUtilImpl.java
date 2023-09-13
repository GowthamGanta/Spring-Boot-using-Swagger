package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.mapper.AddEmployeeAddressRequestMapper;
import com.rs.fer.eis.mapper.EditEmployeeAddressRequestMapper;
import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;
import com.rs.fer.eis.util.EmployeeAddressUtil;
import com.rs.fer.util.DateUtil;

@Component
public class EmployeeAddressUtilImpl implements EmployeeAddressUtil {

	@Override
	public EmployeeAddress loadAddEmployeeAddressRequestToEmployeeAddress(AddEmployeeAddressRequest request) {

		EmployeeAddress employeeAddress = AddEmployeeAddressRequestMapper.MAPPER.mapToEmployeeAddress(request);
		employeeAddress.setCreated(DateUtil.getCurrentDate());

		return employeeAddress;
	}

	@Override
	public EmployeeAddress loadEditEmployeeAddressRequestToEmployeeAddress(EditEmployeeAddressRequest request,
			EmployeeAddress employeeAddress) {

		employeeAddress = EditEmployeeAddressRequestMapper.MAPPER.mapToEmployeeAddress(request, employeeAddress);
		employeeAddress.setUpdated(DateUtil.getCurrentDate());

		return employeeAddress;

	}

}
