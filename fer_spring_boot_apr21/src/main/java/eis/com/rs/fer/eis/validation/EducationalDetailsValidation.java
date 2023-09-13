package com.rs.fer.eis.validation;

import java.util.Set;

import com.rs.fer.eis.request.EducationalDetailsRequest;

public interface EducationalDetailsValidation {

	Set<String> validateSaveEducationalDetailsRequest(EducationalDetailsRequest request);

	
			
}
