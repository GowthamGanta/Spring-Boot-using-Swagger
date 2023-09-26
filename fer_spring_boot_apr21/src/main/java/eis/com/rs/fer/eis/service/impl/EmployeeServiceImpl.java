package com.rs.fer.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.repository.EmployeeRepository;
import com.rs.fer.eis.request.AddEmployeeRequest;
import com.rs.fer.eis.request.DeleteEmployeeRequest;
import com.rs.fer.eis.request.EditEmployeeRequest;
import com.rs.fer.eis.request.GetEmployeeRequest;
import com.rs.fer.eis.request.LoginEmployeeRequest;
import com.rs.fer.eis.response.AddEmployeeResponse;
import com.rs.fer.eis.response.DeleteEmployeeResponse;
import com.rs.fer.eis.response.EditEmployeeResponse;
import com.rs.fer.eis.response.GetEmployeeResponse;
import com.rs.fer.eis.response.LoginEmployeeResponse;
import com.rs.fer.eis.service.EmployeeService;
import com.rs.fer.eis.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeUtil employeeUtil;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public AddEmployeeResponse addEmployee(AddEmployeeRequest request) {
		AddEmployeeResponse response = null;

		// Employee is present or not check
		List<Employee> employees = employeeRepository.findByEmail(request.getEmail());

		if (!CollectionUtils.isEmpty(employees)) {
			// Employee already there
			response = new AddEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"Employee details exists with the registered email", null);
			return response;
		}

		// load vo to bean
		Employee employee = employeeUtil.loadAddEmployeeRequestToEmployee(request);

		// save bean to database
		employee = employeeRepository.save(employee);

		// load response
		if (employee.getEmployeeId() > 0) {
			response = new AddEmployeeResponse(HttpStatus.OK, "000", "Employee added successfully", null);
			response.setEmployee(employee);
		} else {
			response = new AddEmployeeResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Employee not added", null);
		}

		return response;
	}

	@Override
	public LoginEmployeeResponse loginEmployee(LoginEmployeeRequest request) {
		LoginEmployeeResponse response = null;
		int employeeId = 0;

		// load vo to bean
		String email = request.getEmail();
		String password = request.getPassword();

		List<Employee> employee = employeeRepository.findByEmailAndPassword(email, password);
		if (employee != null && !employee.isEmpty()) {
			Employee employeeObj = employee.get(0);
			employeeId = employeeObj.getEmployeeId();
		}

		// load response
		if (employeeId > 0) {
			// success
			response = new LoginEmployeeResponse(HttpStatus.OK, "000", "Welcome to Employee", null);

		} else {
			// failure
			response = new LoginEmployeeResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Invalid Email/password..Please try again.", null);
		}

		return response;

	}

	@Override
	public EditEmployeeResponse editEmployee(EditEmployeeRequest request) {

		EditEmployeeResponse response = null;

		// Employee is present or not check
		List<Employee> employees = employeeRepository.findByEmail(request.getEmail());

		if (!CollectionUtils.isEmpty(employees)) {
			// Employee already there
			response = new EditEmployeeResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"Employee details exists with the registered email", null);
			return response;
		}

		Optional<Employee> employeeobj = employeeRepository.findById(request.getEmployeeId());

		if (employeeobj.isPresent()) {

			// load vo to bean

			Employee employee = employeeobj.get();

			employee = employeeUtil.loadEditEmployeeRequestToEmployee(request, employee);
			// save bean to database
			employee = employeeRepository.save(employee);

			// User already present
			response = new EditEmployeeResponse(HttpStatus.OK, "000", "Employee details edited successfully", null);
			response.setEmployee(employee);
		} else {
			// failure
			response = new EditEmployeeResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Employee edit is failed",
					null);
		}

		return response;
	}

	@Override
	public DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequest request) {

		DeleteEmployeeResponse response = null;

		// To get the User based on userId
		Optional<Employee> employeeObj = employeeRepository.findById(request.getEmployeeId());

		// If user is not present
		if (employeeObj.isPresent()) {

			employeeRepository.deleteById(request.getEmployeeId());

			response = new DeleteEmployeeResponse(HttpStatus.OK, "000", "Employee deleted successfully ", null);
			response.setEmployee(employeeObj.get());

		} else {
			// failure
			response = new DeleteEmployeeResponse(HttpStatus.INTERNAL_SERVER_ERROR, "106", "Employee deletion failed",
					null);
		}

		return response;
	}

	@Override
	public GetEmployeeResponse getEmployee(GetEmployeeRequest request) {

		GetEmployeeResponse response = null;

		// To get the user based on userId
		Optional<Employee> employeeObj = employeeRepository.findById(request.getEmployeeId());

		if (employeeObj.isPresent()) {
			// If user is present
			response = new GetEmployeeResponse(HttpStatus.OK, "000", "fetched Employee details", null);
			response.setEmployee(employeeObj.get());

		} else {
			// if user not present
			response = new GetEmployeeResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No Employee found", null);
		}
		return response;
	}

}
