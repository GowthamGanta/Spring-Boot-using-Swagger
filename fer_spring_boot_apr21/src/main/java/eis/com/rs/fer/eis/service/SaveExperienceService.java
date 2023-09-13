package com.rs.fer.eis.service;

import com.rs.fer.eis.request.SaveExperienceRequest;
import com.rs.fer.eis.response.SaveExperienceResponse;

public interface SaveExperienceService {
	
	SaveExperienceResponse saveExperience(SaveExperienceRequest request);

}
