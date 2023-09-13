package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.EmployeeSkills;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;

public interface EmployeeSkillsUtil {
	
	EmployeeSkills  loadSaveEmployeeSkillsRequestToEmployeeSkills(SaveEmployeeSkillsRequest request);


}
