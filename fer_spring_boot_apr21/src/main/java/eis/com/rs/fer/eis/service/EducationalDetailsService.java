package com.rs.fer.eis.service;

import com.rs.fer.eis.request.EducationalDetailsRequest;
import com.rs.fer.eis.response.EducationalDetailsResponse;

public interface EducationalDetailsService {

	EducationalDetailsResponse saveEducationalDetails(EducationalDetailsRequest request);

}

