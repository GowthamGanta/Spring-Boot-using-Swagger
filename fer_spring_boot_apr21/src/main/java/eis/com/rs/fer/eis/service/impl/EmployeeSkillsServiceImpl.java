package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.entity.EmployeeSkills;
import com.rs.fer.eis.repository.EmployeeRepository;
import com.rs.fer.eis.repository.EmployeeSkillsRepository;
import com.rs.fer.eis.request.DeleteEmployeeSkillsRequest;
import com.rs.fer.eis.request.EditEmployeeSkillsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsRequest;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
import com.rs.fer.eis.response.DeleteEmployeeSkillsResponse;
import com.rs.fer.eis.response.EditEmployeeSkillsResponse;
import com.rs.fer.eis.response.GetEmployeeSkillsOptionsResponse;
import com.rs.fer.eis.response.GetEmployeeSkillsResponse;
import com.rs.fer.eis.response.SaveEmployeeSkillsResponse;
import com.rs.fer.eis.service.EmployeeSkillsService;
import com.rs.fer.eis.util.EmployeeSkillsUtil;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {

	@Autowired
	EmployeeSkillsUtil employeeSkillsUtil;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeSkillsRepository employeeSkillsRepository;

	@Override
	public SaveEmployeeSkillsResponse saveEmployeeSkills(SaveEmployeeSkillsRequest request) {

		SaveEmployeeSkillsResponse response = null;

		Optional<Employee> empObj = employeeRepository.findById(request.getEmployeeId());
		if (empObj.isPresent()) {

			EmployeeSkills employeeSkills = employeeSkillsUtil.loadSaveEmployeeSkillsRequestToEmployeeSkills(request);

			Employee employee = empObj.get();
			employee.getEmployeeSkills().add(employeeSkills);

			employee = employeeRepository.save(employee);

			response = new SaveEmployeeSkillsResponse(HttpStatus.OK, "000", " skills added  succesfully ", null);

			response.setEmployeeSkills(employeeSkills);
		} else {
			// failure
			response = new SaveEmployeeSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Employee is not present", null);
		}

		return response;

	}

	@Override
	public EditEmployeeSkillsResponse editEmployeeSkills(EditEmployeeSkillsRequest request) {

		EditEmployeeSkillsResponse response = null;

		// employee is present or not check
		Optional<EmployeeSkills> empSkillsObj = employeeSkillsRepository.findById(request.getId());

		if (empSkillsObj.isPresent()) {

			EmployeeSkills employeeSkills = empSkillsObj.get();

			// load vo to bean
			employeeSkills = employeeSkillsUtil.loadEditEmployeeSkillsRequestToEmployeeSkills(request, employeeSkills);

			// save bean to databae
			employeeSkills = employeeSkillsRepository.save(employeeSkills);

			// load response
			// success
			response = new EditEmployeeSkillsResponse(HttpStatus.OK, "000", " skills edited  succesfully ", null);
			response.setEmployeeSkills(employeeSkills);
		} else {
			// failure
			response = new EditEmployeeSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "skills editing failed",
					null);
		}

		return response;
	}

	@Override
	public DeleteEmployeeSkillsResponse deleteEmployeeSkills(DeleteEmployeeSkillsRequest request) {

		DeleteEmployeeSkillsResponse response = null;

		// employee is present or not check
		Optional<EmployeeSkills> empSkillsObj = employeeSkillsRepository.findById(request.getId());

		if (empSkillsObj.isPresent()) {

			// delete address based on Address id
			employeeSkillsRepository.deleteById(request.getId());

			// load response
			// success
			response = new DeleteEmployeeSkillsResponse(HttpStatus.OK, "000", " skills deleted  succesfully ", null);
			response.setEmployeeSkills(empSkillsObj.get());
		} else {
			// failure
			response = new DeleteEmployeeSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"skills deleted failed", null);
		}

		return response;
	}

	@Override
	public GetEmployeeSkillsResponse getEmployeeSkills(GetEmployeeSkillsRequest request) {

		GetEmployeeSkillsResponse response = null;

		// employee is present or not check
		Optional<EmployeeSkills> empSkillsObj = employeeSkillsRepository.findById(request.getId());

		if (empSkillsObj.isPresent()) {

			// load response
			// success
			response = new GetEmployeeSkillsResponse(HttpStatus.OK, "000", " get skills  succesfully ", null);
			response.setEmployeeSkills(empSkillsObj.get());
		} else {
			// failure
			response = new GetEmployeeSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "skills get failed",
					null);
		}

		return response;
	}

	@Override
	public GetEmployeeSkillsOptionsResponse getEmployeeSkillsOptions(GetEmployeeSkillsOptionsRequest request) {

		GetEmployeeSkillsOptionsResponse response = null;

		// employee is present or not check
		Optional<Employee> empObj = employeeRepository.findById(request.getEmployeeId());

		if (empObj.isPresent()) {

			// load response
			// success
			response = new GetEmployeeSkillsOptionsResponse(HttpStatus.OK, "000", " Get skillsOptions success ", null);
			response.setEmployeeSkills(empObj.get().getEmployeeSkills());
		} else {
			// failure
			response = new GetEmployeeSkillsOptionsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"No EmployeeSkillsOptions", null);
		}
		return response;

	}

}
