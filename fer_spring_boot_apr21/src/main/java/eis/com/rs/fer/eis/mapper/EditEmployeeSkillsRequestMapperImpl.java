package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import com.rs.fer.eis.entity.EmployeeSkills;
import com.rs.fer.eis.request.EditEmployeeSkillsRequest;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-04-19T07:34:40+0530", comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)")
public class EditEmployeeSkillsRequestMapperImpl implements EditEmployeeSkillsRequestMapper {

	@Override
	public EmployeeSkills mapToEmployeeSkills(EditEmployeeSkillsRequest request, EmployeeSkills employeeSkills) {

		if (request == null) {
			return null;
		}

		employeeSkills.setId(request.getId());

		employeeSkills.setEmployeeId(request.getEmployeeId());

		return employeeSkills;
	}
}
