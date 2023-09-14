package com.rs.fer.eis.mapper;

import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.eis.request.EditSkillsRequest;

public interface EditSkillsRequestMapper {

	EditSkillsRequestMapper MAPPER = Mappers.getMapper(EditSkillsRequestMapper.class);

	Skills mapToSkills(EditSkillsRequest request, Skills skills);

}
