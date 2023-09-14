package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.EmployeeSkills;
import com.rs.fer.eis.request.EditEmployeeSkillsRequest;

@Mapper
public interface EditEmployeeSkillsRequestMapper {

	EditEmployeeSkillsRequestMapper  MAPPER  = Mappers.getMapper(EditEmployeeSkillsRequestMapper.class) ;
	
	EmployeeSkills mapToEmployeeSkills(EditEmployeeSkillsRequest request, EmployeeSkills employeeSkills);
}
