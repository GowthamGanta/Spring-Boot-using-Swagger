package com.rs.fer.eis.service;

import com.rs.fer.eis.request.DeleteEmployeeSkillsRequest;
import com.rs.fer.eis.request.EditEmployeeSkillsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsOptionsRequest;
import com.rs.fer.eis.request.GetEmployeeSkillsRequest;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
import com.rs.fer.eis.response.DeleteEmployeeSkillsResponse;
import com.rs.fer.eis.response.EditEmployeeSkillsResponse;
import com.rs.fer.eis.response.GetEmployeeSkillsOptionsResponse;
import com.rs.fer.eis.response.GetEmployeeSkillsResponse;
import com.rs.fer.eis.response.SaveEmployeeSkillsResponse;

public interface EmployeeSkillsService {

	SaveEmployeeSkillsResponse saveEmployeeSkills(SaveEmployeeSkillsRequest request);

	DeleteEmployeeSkillsResponse deleteEmployeeSkills(DeleteEmployeeSkillsRequest request);

	EditEmployeeSkillsResponse editEmployeeSkills(EditEmployeeSkillsRequest request);

	GetEmployeeSkillsResponse getEmployeeSkills(GetEmployeeSkillsRequest request);

	GetEmployeeSkillsOptionsResponse getEmployeeSkillsOptions(GetEmployeeSkillsOptionsRequest request);

}
