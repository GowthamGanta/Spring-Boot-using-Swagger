package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.entity.EmployeeAddress;
import com.rs.fer.eis.repository.EmployeeAddressRepository;
import com.rs.fer.eis.repository.EmployeeRepository;
import com.rs.fer.eis.request.AddEmployeeAddressRequest;
import com.rs.fer.eis.request.DeleteEmployeeAddressRequest;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;
import com.rs.fer.eis.request.GetEmployeeAddressOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeAddressRequest;
import com.rs.fer.eis.response.AddEmployeeAddressResponse;
import com.rs.fer.eis.response.DeleteEmployeeAddressResponse;
import com.rs.fer.eis.response.EditEmployeeAddressResponse;
import com.rs.fer.eis.response.GetEmployeeAddressOptionsResponse;
import com.rs.fer.eis.response.GetEmployeeAddressResponse;
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
	public AddEmployeeAddressResponse addEmployeeAddress(AddEmployeeAddressRequest request) {

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

	@Override
	public EditEmployeeAddressResponse editEmployeeAddress(EditEmployeeAddressRequest request) {

		EditEmployeeAddressResponse response = null;

		// User is present or not check
		Optional<EmployeeAddress> employeeAddressObj = employeeAddressRepository.findById(request.getId());

		if (employeeAddressObj.isPresent()) {

			EmployeeAddress employeeAddress = employeeAddressObj.get();

			// load vo to bean
			employeeAddress = employeeAddressUtil.loadEditEmployeeAddressRequestToEmployeeAddress(request,
					employeeAddress);

			// save bean to database
			employeeAddress = employeeAddressRepository.save(employeeAddress);

			// load response
			// success
			response = new EditEmployeeAddressResponse(HttpStatus.OK, "000", "Address edited successfully", null);
			response.setEmployeeAddress(employeeAddress);
		} else {
			// failure
			response = new EditEmployeeAddressResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Address editing failed", null);

			response = new EditEmployeeAddressResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"expense editing failed", null);

		}

		return response;

	}

	@Override
	public GetEmployeeAddressOptionsResponse getEmployeeAddressOptions(GetEmployeeAddressOptionsRequest request) {
		GetEmployeeAddressOptionsResponse response = null;

		// To load the userObject based on userId
		Optional<Employee> employeeObj = employeeRepository.findById(request.getEmployeeId());

		if (employeeObj.isPresent()) {

			// success
			response = new GetEmployeeAddressOptionsResponse(HttpStatus.OK, "000", "Get Address Success", null);
			response.setEmployeeAddress(employeeObj.get().getEmployeeAddress());
		} else {

			// failure
			response = new GetEmployeeAddressOptionsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No Address",
					null);
		}

		return response;
	}

	@Override
	public DeleteEmployeeAddressResponse deleteEmployeeAddress(DeleteEmployeeAddressRequest request) {
		DeleteEmployeeAddressResponse response = null;

		Optional<EmployeeAddress> employeeAddressObj = employeeAddressRepository.findById(request.getId());

		if (employeeAddressObj.isPresent()) {

			// Delete Address based on Address id
			employeeAddressRepository.deleteById(request.getId());

			// if Address is deleted success case
			response = new DeleteEmployeeAddressResponse(HttpStatus.OK, "000", "Address is succesfully Deleted", null);
			response.setEmployeeAddress(employeeAddressObj.get());
		} else {
			// if Address is deleted failure case
			response = new DeleteEmployeeAddressResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Delete Address is failed", null);
		}

		return response;
	}

	@Override
	public GetEmployeeAddressResponse getEmployeeAddress(GetEmployeeAddressRequest request) {

		GetEmployeeAddressResponse response = null;

		Optional<EmployeeAddress> employeeAddressObj = employeeAddressRepository.findById(request.getId());

		if (employeeAddressObj.isPresent()) {

			response = new GetEmployeeAddressResponse(HttpStatus.OK, "000", "fetch Address", null);

			response.setEmployeeAddress(employeeAddressObj.get());

		} else {
			// failure
			response = new GetEmployeeAddressResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No Address found",
					null);

		}

		return response;

	}

}
