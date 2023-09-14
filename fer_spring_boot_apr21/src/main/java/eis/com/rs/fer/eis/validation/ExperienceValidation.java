package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.DeleteEmployeeExperienceRequest;
import com.rs.fer.eis.request.EditExperienceRequest;
import com.rs.fer.eis.request.GetEmployeeExperienceRequest;
import com.rs.fer.eis.request.GetExperienceOptionsRequest;
import com.rs.fer.eis.request.SaveExperienceRequest;

public interface ExperienceValidation {
	
	 Set<String> validateSaveExperienceRequest(SaveExperienceRequest request);
	 Set<String> validateEditExperienceRequest(EditExperienceRequest request);
	 Set<String> validateGetExperienceRequest(GetExperienceOptionsRequest request);
	 Set<String> validateDeleteEmployeeExperienceRequest(DeleteEmployeeExperienceRequest request);
	 Set<String> validateGetEmployeeExperienceRequest(GetEmployeeExperienceRequest request);
	 

}
