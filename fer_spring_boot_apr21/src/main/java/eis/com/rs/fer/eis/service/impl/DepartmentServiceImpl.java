package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.repository.DepartmentRepository;
import com.rs.fer.eis.repository.EmployeeRepository;
import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.request.DeleteDepartmentRequest;
import com.rs.fer.eis.request.EditDepartmentRequest;
import com.rs.fer.eis.request.GetDepartmentOptionsRequest;
import com.rs.fer.eis.request.GetDepartmentRequest;
import com.rs.fer.eis.request.GetEmployeeAddressOptionsRequest;
import com.rs.fer.eis.response.AddDepartmentResponse;
import com.rs.fer.eis.response.DeleteDepartmentResponse;
import com.rs.fer.eis.response.EditDepartmentResponse;
import com.rs.fer.eis.response.GetDepartmentOptionsResponse;
import com.rs.fer.eis.response.GetDepartmentResponse;
import com.rs.fer.eis.response.GetEmployeeAddressOptionsResponse;
import com.rs.fer.eis.service.DepartmentService;
import com.rs.fer.eis.util.DepartmentUtil;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentUtil departmentUtil;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public AddDepartmentResponse addDepartment(AddDepartmentRequest request) {

		AddDepartmentResponse response = null;

		Optional<Employee> employeeObj = employeeRepository.findById(request.getId());

		if (employeeObj.isPresent()) {
			// load vo to bean
			Department department = departmentUtil.loadAddDepartmentRequestToDepartment(request);
			Employee employee = employeeObj.get();
			employee.setDepartment(department);

			// save bean to database
			// department = departmentRepository.save(department);
			employee = employeeRepository.save(employee);
			response = new AddDepartmentResponse(HttpStatus.OK, "000", "Department Added is succesfully ", null);
			response.setDepartment(department);

		} else {
			// failure
			response = new AddDepartmentResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User is not present", null);
		}
		return response;

	}

	@Override
	public EditDepartmentResponse editDepartment(EditDepartmentRequest request) {
		EditDepartmentResponse response = null;

		Optional<Employee> employeeObj = employeeRepository.findById(request.getId());

		if (employeeObj.isPresent()) {
			// load vo to bean
			Department department = departmentUtil.loadEditDepartmentRequestToDepartment(request);
			Employee employee = employeeObj.get();
			employee.setDepartment(department);

			// save bean to database
			// department = departmentRepository.save(department);
			employee = employeeRepository.save(employee);
			response = new EditDepartmentResponse(HttpStatus.OK, "000", "Department Edit is succesfully ", null);
			response.setDepartment(department);

		} else {
			// failure
			response = new EditDepartmentResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User is not present", null);
		}
		return response;

	}

	@Override
	public DeleteDepartmentResponse deleteDepartment(DeleteDepartmentRequest request) {
		DeleteDepartmentResponse response = null;

		Optional<Employee> employeeObj = employeeRepository.findById(request.getId());
		if (employeeObj.isPresent()) {

			// Delete department to database
			employeeRepository.deleteById(request.getId());
			
			// if department is deleted
			response = new DeleteDepartmentResponse(HttpStatus.OK, "000", "Department Delete is succesfully ", null);
			response.setDepartment(employeeObj.get());

		} else {
			// failure
			response = new DeleteDepartmentResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Department is not present", null);
		}
		return response;

	}

	@Override
	public GetDepartmentResponse getDepartment(GetDepartmentRequest request) {

		GetDepartmentResponse response = null;

		Optional<Employee> employeeObj = employeeRepository.findById(request.getId());
		
		if (employeeObj.isPresent()) {
			response = new GetDepartmentResponse(HttpStatus.OK, "000", "Fetch Department Detaiils ", null);
			response.setDepartment(employeeObj.get());

		} else {
			// failure
			response = new GetDepartmentResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Department Details is failed", null);
		}
		return response;

	}
	@Override
	public GetDepartmentOptionsResponse getdepartmentOptions(GetDepartmentOptionsRequest request) {
     GetDepartmentOptionsResponse response = null;

		
		Optional<Employee> employeeObj = employeeRepository.findById(request.getEmployeeid());

		if (employeeObj.isPresent()) {

			// success
			response = new GetDepartmentOptionsResponse(HttpStatus.OK, "000", "Get department Success", null);
			response.setDepartment(employeeObj.get());
		} else {

			// failure
			response = new GetDepartmentOptionsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No department",
					null);
		}

		return response;
	}
	

}

