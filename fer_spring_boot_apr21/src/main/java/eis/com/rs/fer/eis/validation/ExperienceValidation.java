package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.SaveExperienceRequest;

public interface ExperienceValidation {
	
	 Set<String> validateSaveExperienceRequest(SaveExperienceRequest request);

}
