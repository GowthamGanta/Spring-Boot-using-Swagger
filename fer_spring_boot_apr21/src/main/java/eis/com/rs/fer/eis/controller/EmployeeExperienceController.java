package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.SaveExperienceRequest;
import com.rs.fer.eis.response.SaveExperienceResponse;
import com.rs.fer.eis.service.SaveExperienceService;
import com.rs.fer.eis.validation.ExperienceValidation;

@RestController
@RequestMapping("/api")
public class EmployeeExperienceController {
	

	@Autowired
	ExperienceValidation experienceValidation;
	@Autowired
	SaveExperienceService experienceService;
	@Autowired
	

	@PostMapping("/saveExperience")
	public SaveExperienceResponse saveExerience(@RequestBody SaveExperienceRequest request) {
		SaveExperienceResponse response=null;
		Set<String> errorMessages=experienceValidation.validateSaveExperienceRequest(request);
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveExperienceResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = experienceService.saveExperience(request);
		}
		
		
		return response;
		
	}

}
