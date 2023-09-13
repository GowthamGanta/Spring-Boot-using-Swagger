package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.EducationalDetails;
import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.repository.EducationalDetailsRepository;
import com.rs.fer.eis.repository.EmployeeRepository;
import com.rs.fer.eis.request.EducationalDetailsRequest;
import com.rs.fer.eis.response.EducationalDetailsResponse;
import com.rs.fer.eis.service.EducationalDetailsService;
import com.rs.fer.eis.util.EducationalDetailsUtil;

@Service
public class EducationalDetailsServiceImpl implements EducationalDetailsService {

	@Autowired
	EducationalDetailsUtil educationalDetailsUtil;

	@Autowired
	EducationalDetailsRepository educationalDetailsRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public EducationalDetailsResponse saveEducationalDetails(EducationalDetailsRequest request) {

		EducationalDetailsResponse response = null;
		Optional<Employee> empObj = employeeRepository.findById(request.getEmployeeId());
		if (empObj.isPresent()) {
			EducationalDetails educationaldetails = educationalDetailsUtil
					.loadSaveEducationalDetailsRequestToEducationalDetails(request);

			Employee employee = empObj.get();
			employee.getEducationalDetails().add(educationaldetails);
			employee = employeeRepository.save(employee);
			response = new EducationalDetailsResponse(HttpStatus.OK, "000",
					"Employee Education Details Added is succesfully ", null);
			response.setEducationalDetails(educationaldetails);

		} else {
			response = new EducationalDetailsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Employee is not present", null);
		}

		return response;

	}

}

