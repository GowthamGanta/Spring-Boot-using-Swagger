package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.entity.EmployeeSkills;
import com.rs.fer.eis.repository.AddEmployeeRepository;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
import com.rs.fer.eis.response.SaveEmployeeSkillsResponse;
import com.rs.fer.eis.service.EmployeeSkillsService;
import com.rs.fer.eis.util.EmployeeSkillsUtil;
@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {

	@Autowired
	EmployeeSkillsUtil employeeSkillsUtil;

	@Autowired
	AddEmployeeRepository addEmployeeRepository;


	public SaveEmployeeSkillsResponse saveEmployeeSkills(SaveEmployeeSkillsRequest request) {
		SaveEmployeeSkillsResponse response = null;
		Optional<Employee> empObj = addEmployeeRepository.findById(request.getEmployeeId());
		if (empObj.isPresent()) {
			
			EmployeeSkills employeeSkills = employeeSkillsUtil.loadSaveEmployeeSkillsRequestToEmployeeSkills(request);
			
			Employee employee = empObj.get();
			employee.getEmployeeSkills().add(employeeSkills);
			
			employee = addEmployeeRepository.save(employee);
			response = new SaveEmployeeSkillsResponse(HttpStatus.OK, "000", " skills added  succesfully ", null);
			response.setEmployeeSkills(employeeSkills);
		} else {
			// failure
			response = new SaveEmployeeSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User is not present",
					null);
		}

		return response;

	}

}
