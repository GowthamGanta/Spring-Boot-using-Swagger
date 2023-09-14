package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.eis.mapper.EditSkillsRequestMapper;
import com.rs.fer.eis.mapper.SkillsRequestMapper;
import com.rs.fer.eis.request.EditSkillsRequest;
import com.rs.fer.eis.request.SaveSkillsRequest;
import com.rs.fer.eis.util.SkillsUtil;
import com.rs.fer.util.DateUtil;

@Component
public class SkillsUtilImpl implements SkillsUtil {

	@Override
	public Skills loadSaveSkillsRequestToSkills(SaveSkillsRequest request) {

		Skills skills = SkillsRequestMapper.MAPPER.mapToSkills(request);
		skills.setCreated(DateUtil.getCurrentDate());

		return skills;
	}

	@Override
	public Skills loadEditSkillsRequestToSkills(EditSkillsRequest request, Skills skills) {
		skills = EditSkillsRequestMapper.MAPPER.mapToSkills(request, skills);
		skills.setCreated(DateUtil.getCurrentDate());

		return skills;
	}

}
