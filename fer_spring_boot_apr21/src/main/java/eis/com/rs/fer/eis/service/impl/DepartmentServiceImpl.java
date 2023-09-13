package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.repository.AddEmployeeRepository;
import com.rs.fer.eis.repository.DepartmentRepository;
import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.response.AddDepartmentResponse;
import com.rs.fer.eis.service.DepartmentService;
import com.rs.fer.eis.util.DepartmentUtil;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentUtil departmentUtil;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	AddEmployeeRepository addEmployeeRepository;

	public AddDepartmentResponse addDepartment(AddDepartmentRequest request)  {

		AddDepartmentResponse response = null;

		Optional<Employee> employeeObj = addEmployeeRepository.findById(request.getId());

		if (employeeObj.isPresent()) {
			// load vo to bean
			Department department = departmentUtil.loadAddDepartmentRequestToDepartment(request);
			Employee employee = employeeObj.get();
			employee.getDepartment().add(department);

			// save bean to database
			department = departmentRepository.save(department);

			response = new AddDepartmentResponse(HttpStatus.OK, "000", "Expense Added is succesfully ", null);
			response.setDepartment(department);

		} else {
			// failure
			response = new AddDepartmentResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User is not present", null);
		}
		return response;

	}
}
	
