package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.mapper.AddDepartmentRequestMapper;
import com.rs.fer.eis.mapper.DeleteDepartmentRequestMapper;
import com.rs.fer.eis.mapper.EditDepartmentRequestMapper;
import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.request.DeleteDepartmentRequest;
import com.rs.fer.eis.request.EditDepartmentRequest;
import com.rs.fer.eis.request.GetDepartmentRequest;
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

	@Override
	public Department loadEditDepartmentRequestToDepartment(EditDepartmentRequest request) {

		Department department = EditDepartmentRequestMapper.MAPPER.mapToDepartment(request);
		department.setCreated(DateUtil.getCurrentDate());

		return department;
	}

	@Override
	public Department loadDeleteDepartmentRequestToDepartment(DeleteDepartmentRequest request) {

		Department department = DeleteDepartmentRequestMapper.MAPPER.mapToDepartment(request);
		department.setCreated(DateUtil.getCurrentDate());

		return null;
	}

	public Department loadGetDepartmentRequestToDepartment(GetDepartmentRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
