package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.repository.AddEmployeeRepository;
import com.rs.fer.eis.repository.ExperienceRepository;
import com.rs.fer.eis.request.SaveExperienceRequest;
import com.rs.fer.eis.response.SaveExperienceResponse;
import com.rs.fer.eis.service.SaveExperienceService;
import com.rs.fer.eis.util.ExperienceUtil;

@Service
public class ExperienceServiceImpl implements SaveExperienceService {
	@Autowired
	ExperienceUtil experienceUtil;
	@Autowired
	ExperienceRepository experienceRepository;
	@Autowired
	AddEmployeeRepository addEmployeeRepository;

	@Override
	public SaveExperienceResponse saveExperience(SaveExperienceRequest request) {

		SaveExperienceResponse response = null;

		Optional<Employee> experience = addEmployeeRepository.findById(request.getEid());
		if (experience.isPresent()) {
			// load  to bean

			Experience_Details experienceDetails = experienceUtil.loadSaveExperienceRequestToEmployee(request);
			
			Employee employee = experience.get();
			employee.getExperience_Details().add(experienceDetails);

			employee = addEmployeeRepository.save(employee);
			response = new SaveExperienceResponse(HttpStatus.OK, "000", " Save  succesfully ", null);
			response.setExperienceDetails(experienceDetails);
			
		} else {
			// failure
			response = new SaveExperienceResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User is not present", null);
		}

		return response;
	}

}
