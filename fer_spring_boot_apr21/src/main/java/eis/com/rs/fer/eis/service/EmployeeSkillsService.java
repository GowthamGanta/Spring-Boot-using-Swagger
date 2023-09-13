package com.rs.fer.eis.service;

import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
import com.rs.fer.eis.response.SaveEmployeeSkillsResponse;

public interface EmployeeSkillsService {
	
	SaveEmployeeSkillsResponse saveEmployeeSkills(SaveEmployeeSkillsRequest request);

}
