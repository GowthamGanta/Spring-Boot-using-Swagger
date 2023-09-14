package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.request.EditExperienceRequest;
import com.rs.fer.eis.request.SaveExperienceRequest;

public interface ExperienceUtil {
	Experience_Details loadSaveExperienceRequestToEmployee(SaveExperienceRequest request);
	Experience_Details loadEditExperienceRequestToEmployee(EditExperienceRequest request,Experience_Details experience_Details);

}
