package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.repository.EmployeeRepository;
import com.rs.fer.eis.repository.EmployeeAddressRepository;
import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.response.AddEmployeeAddressResponse;
import com.rs.fer.eis.service.EmployeeAddressService;
import com.rs.fer.eis.util.EmployeeAddressUtil;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	@Autowired
	EmployeeAddressUtil employeeAddressUtil;

	@Autowired
	EmployeeAddressRepository employeeAddressRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public AddEmployeeAddressResponse addEmployee(AddEmployeeAddressRequest request) {

		AddEmployeeAddressResponse response = null;

		Optional<Employee> employeeObj = employeeRepository.findById(request.getEmployeeId());

		if (employeeObj.isPresent()) {

			// load vo to bean
			EmployeeAddress employeeAddress = employeeAddressUtil
					.loadAddEmployeeAddressRequestToEmployeeAddress(request);

			Employee employee = employeeObj.get();
			employee.getEmployeeAddress().add(employeeAddress);

			// save bean to database
			employee = employeeRepository.save(employee);

			response = new AddEmployeeAddressResponse(HttpStatus.OK, "000", "Employee Address Added is succesfully ",
					null);
			response.setEmployeeAddress(employeeAddress);

		} else {
			// failure
			response = new AddEmployeeAddressResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Employee is not present", null);
		}
		return response;
	}
}