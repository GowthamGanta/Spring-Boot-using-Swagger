package com.rs.fer.eis.mapper;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.eis.request.SaveSkillsRequest;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-04-18T12:16:17+0530", comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)")
@Component
public class SkillsRequestMapperImpl implements SkillsRequestMapper {

	@Override
	public Skills mapToSkills(SaveSkillsRequest request) {

		if (request == null) {
			return null;
		}

		Skills skills = new Skills();

		skills.setName(request.getName());

		return skills;
	}

	

	

}
