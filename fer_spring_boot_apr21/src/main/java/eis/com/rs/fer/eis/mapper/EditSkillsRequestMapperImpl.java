package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.eis.request.EditSkillsRequest;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-04-19T07:34:40+0530", comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)")
public class EditSkillsRequestMapperImpl implements EditSkillsRequestMapper {

	@Override
	public Skills mapToSkills(EditSkillsRequest request, Skills skills) {
		if (request == null) {
			return null;
		}

		skills.setId(request.getId());
		skills.setName(request.getName());

		return skills;
	}

}