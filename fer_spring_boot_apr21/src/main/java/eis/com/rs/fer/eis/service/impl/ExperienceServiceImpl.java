package com.rs.fer.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Employee;
import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.repository.EmployeeRepository;
import com.rs.fer.eis.repository.ExperienceRepository;
import com.rs.fer.eis.request.DeleteEmployeeExperienceRequest;
import com.rs.fer.eis.request.EditExperienceRequest;
import com.rs.fer.eis.request.GetEmployeeExperienceRequest;
import com.rs.fer.eis.request.GetExperienceOptionsRequest;
import com.rs.fer.eis.request.SaveExperienceRequest;
import com.rs.fer.eis.response.DeleteEmployeeExperienceResponse;
import com.rs.fer.eis.response.EditExperienceResponse;
import com.rs.fer.eis.response.GetEmployeeExperienceResponse;
import com.rs.fer.eis.response.GetExperienceOptionsResponse;
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
	EmployeeRepository employeeRepository;

	@Override
	public SaveExperienceResponse saveExperience(SaveExperienceRequest request) {

		SaveExperienceResponse response = null;

		Optional<Employee> experience = employeeRepository.findById(request.getEmployeeId());
		if (experience.isPresent()) {
			// load to bean

			Experience_Details experienceDetails = experienceUtil.loadSaveExperienceRequestToEmployee(request);

			Employee employee = experience.get();

			employee.getExperience_Details().add(experienceDetails);

			employee = employeeRepository.save(employee);
			response = new SaveExperienceResponse(HttpStatus.OK, "000", " Experience save  succesfully ", null);
			response.setExperienceDetails(experienceDetails);

		} else {
			// failure
			response = new SaveExperienceResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "employee is not present",
					null);
		}

		return response;
	}

	@Override
	public EditExperienceResponse editExperience(EditExperienceRequest request) {
		EditExperienceResponse response = null;
		Optional<Experience_Details> experience = experienceRepository.findById(request.getId());

		if (experience.isPresent()) {

			Experience_Details emDetails = experience.get();

			// load vo to bean
			emDetails = experienceUtil.loadEditExperienceRequestToEmployee(request, emDetails);

			// save bean to database
			emDetails = experienceRepository.save(emDetails);

			// load response
			// success
			response = new EditExperienceResponse(HttpStatus.OK, "000", "experience edited successfully", null);
			response.setExperience_Details(emDetails);
		} else {
			// failure
			response = new EditExperienceResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Address editing failed",
					null);

			response = new EditExperienceResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "expense editing failed",
					null);

		}

		return response;
	}

	@Override
	public GetExperienceOptionsResponse getExperienceOptions(GetExperienceOptionsRequest request) {
		GetExperienceOptionsResponse response = null;

		// To load the userObject based on userId
		Optional<Employee> employeeObj = employeeRepository.findById(request.getEmployeeId());

		if (employeeObj.isPresent()) {

			// success
			response = new GetExperienceOptionsResponse(HttpStatus.OK, "000", "Get Employee Experience Success", null);
			response.setExperience_Details(employeeObj.get().getExperience_Details());
		} else {

			// failure
			response = new GetExperienceOptionsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No Experiences",
					null);
		}

		return null;
	}

	@Override
	public DeleteEmployeeExperienceResponse deleteEmployeeExperience(DeleteEmployeeExperienceRequest request) {
		DeleteEmployeeExperienceResponse response = null;
		Optional<Experience_Details> experience = experienceRepository.findById(request.getId());
		if (experience.isPresent()) {
			experienceRepository.deleteById(request.getId());
			response = new DeleteEmployeeExperienceResponse(HttpStatus.OK, "000", "Experience is succesfully Deleted",
					null);
			response.setExperienceDetails(experience.get());

		} else {
			// if Address is deleted failure case
			response = new DeleteEmployeeExperienceResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Delete  is failed", null);
		}
		return response;
	}

	@Override
	public GetEmployeeExperienceResponse getEmployeeExperience(GetEmployeeExperienceRequest request) {
		GetEmployeeExperienceResponse response = null;
		Optional<Experience_Details> employeeExpObj = experienceRepository.findById(request.getId());
		if (employeeExpObj.isPresent()) {
			response = new GetEmployeeExperienceResponse(HttpStatus.OK, "000", "fetch Experience", null);

			response.setExperienceDetails(employeeExpObj.get());

		} else {
			// failure
			response = new GetEmployeeExperienceResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No Expense found",
					null);

		}

		return response;
	}

}
