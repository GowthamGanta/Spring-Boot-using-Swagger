package com.rs.fer.eis.service;

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

public interface SaveExperienceService {
	
	SaveExperienceResponse saveExperience(SaveExperienceRequest request);
	EditExperienceResponse editExperience(EditExperienceRequest request);
	GetExperienceOptionsResponse getExperienceOptions(GetExperienceOptionsRequest request);
	DeleteEmployeeExperienceResponse deleteEmployeeExperience(DeleteEmployeeExperienceRequest request);
	GetEmployeeExperienceResponse getEmployeeExperience(GetEmployeeExperienceRequest requestt);
	

}
