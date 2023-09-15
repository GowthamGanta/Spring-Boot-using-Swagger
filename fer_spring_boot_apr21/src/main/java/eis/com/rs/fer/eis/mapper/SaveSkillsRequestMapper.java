package com.rs.fer.eis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.eis.request.SaveSkillsRequest;

@Mapper(componentModel = "spring")

public interface SaveSkillsRequestMapper {

	SaveSkillsRequestMapper MAPPER = Mappers.getMapper(SaveSkillsRequestMapper.class);

	Skills mapToSkills(SaveSkillsRequest request);

}
