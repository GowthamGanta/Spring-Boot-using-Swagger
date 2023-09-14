package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.DeleteEmployeeAddressRequest;
import com.rs.fer.eis.request.DeleteEmployeeExperienceRequest;
import com.rs.fer.eis.request.EditEmployeeAddressRequest;
import com.rs.fer.eis.request.EditExperienceRequest;
import com.rs.fer.eis.request.GetEmployeeAddressOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeAddressRequest;
import com.rs.fer.eis.request.GetEmployeeExperienceRequest;
import com.rs.fer.eis.request.GetExperienceOptionsRequest;
import com.rs.fer.eis.request.SaveExperienceRequest;
import com.rs.fer.eis.response.DeleteEmployeeAddressResponse;
import com.rs.fer.eis.response.DeleteEmployeeExperienceResponse;
import com.rs.fer.eis.response.EditEmployeeAddressResponse;
import com.rs.fer.eis.response.EditExperienceResponse;
import com.rs.fer.eis.response.GetEmployeeAddressOptionsResponse;
import com.rs.fer.eis.response.GetEmployeeAddressResponse;
import com.rs.fer.eis.response.GetEmployeeExperienceResponse;
import com.rs.fer.eis.response.GetExperienceOptionsResponse;
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
	@PutMapping("/editExperience")
	public EditExperienceResponse editEmployeeAddress(@RequestBody EditExperienceRequest request) {

		EditExperienceResponse response = null;
		Set<String> errorMessages = experienceValidation.validateEditExperienceRequest(request);

		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new EditExperienceResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = experienceService.editExperience(request);
		}
		return response;
		

}
	
	@PostMapping("/getExpereienceOptions")
	public GetExperienceOptionsResponse getEmployeeAddress(@ModelAttribute GetExperienceOptionsRequest request) {

		GetExperienceOptionsResponse response = null;

		Set<String> errorMessages = experienceValidation.validateGetExperienceRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExperienceOptionsResponse(HttpStatus.PRECONDITION_FAILED, "999", null,
					errorMessages);

		} else {
			response = experienceService.getExperienceOptions(request);
		}
		return response;
	}
	
	@DeleteMapping("/deleteEmployeeExperience")

	public DeleteEmployeeExperienceResponse deleteEmployeeExperience(@ModelAttribute DeleteEmployeeExperienceRequest request) {

		DeleteEmployeeExperienceResponse response = null;

		Set<String> errorMessages = experienceValidation.validateDeleteEmployeeExperienceRequest(request);

		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteEmployeeExperienceResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = experienceService.deleteEmployeeExperience(request);
		}
		return response;
	}
	
	@PostMapping("/getEmployeeExperience")
	public GetEmployeeExperienceResponse getEmployeeExperience(@ModelAttribute GetEmployeeExperienceRequest request) {

		GetEmployeeExperienceResponse response = null;

		Set<String> errorMessages = experienceValidation.validateGetEmployeeExperienceRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetEmployeeExperienceResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = experienceService.getEmployeeExperience(request);
		}
		return response;

	}


}
