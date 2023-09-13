package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.mapper.AddDepartmentRequestMapper;
import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.util.DepartmentUtil;
import com.rs.fer.util.DateUtil;

@Component
public class DepartmentUtilImpl implements DepartmentUtil {

	@Override
	public Department loadAddDepartmentRequestToDepartment(AddDepartmentRequest request) {

		Department department = AddDepartmentRequestMapper.MAPPER.mapToDepartment(request);
		department.setCreated(DateUtil.getCurrentDate());

		return department;
	
	}

}
