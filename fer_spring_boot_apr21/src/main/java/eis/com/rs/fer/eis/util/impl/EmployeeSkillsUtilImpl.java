package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.EmployeeSkills;
import com.rs.fer.eis.mapper.EditEmployeeSkillsRequestMapper;
import com.rs.fer.eis.mapper.SaveEmployeeSkillsRequestMapper;
import com.rs.fer.eis.request.EditEmployeeSkillsRequest;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;
import com.rs.fer.eis.util.EmployeeSkillsUtil;
import com.rs.fer.util.DateUtil;

@Component
public class EmployeeSkillsUtilImpl implements EmployeeSkillsUtil {

	@Override
	public EmployeeSkills loadSaveEmployeeSkillsRequestToEmployeeSkills(SaveEmployeeSkillsRequest request) {

		EmployeeSkills employeeSkills = SaveEmployeeSkillsRequestMapper.MAPPER.mapToEmployeeSkills(request);
		employeeSkills.setCreated(DateUtil.getCurrentDate());

		return employeeSkills;
	}

	@Override
	public EmployeeSkills loadEditEmployeeSkillsRequestToEmployeeSkills(EditEmployeeSkillsRequest request,
			EmployeeSkills employeeSkills) {
		employeeSkills = EditEmployeeSkillsRequestMapper.MAPPER.mapToEmployeeSkills(request,employeeSkills);
		employeeSkills.setUpdated(DateUtil.getCurrentDate());
		
		
		return employeeSkills;
	}

}
