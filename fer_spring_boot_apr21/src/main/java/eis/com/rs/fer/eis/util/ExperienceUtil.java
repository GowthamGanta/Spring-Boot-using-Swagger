package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.request.SaveExperienceRequest;

public interface ExperienceUtil {
	Experience_Details loadSaveExperienceRequestToEmployee(SaveExperienceRequest request);

}
