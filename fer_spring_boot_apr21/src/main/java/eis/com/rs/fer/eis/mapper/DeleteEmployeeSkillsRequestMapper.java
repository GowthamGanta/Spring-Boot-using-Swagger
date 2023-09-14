package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.EmployeeSkills;
import com.rs.fer.eis.request.SaveEmployeeSkillsRequest;

@Mapper
public interface DeleteEmployeeSkillsRequestMapper {

	DeleteEmployeeSkillsRequestMapper  MAPPER  = Mappers.getMapper(DeleteEmployeeSkillsRequestMapper.class) ;
	
	EmployeeSkills mapToEmployeeSkills(SaveEmployeeSkillsRequest request);
}
