package com.rs.fer.eis.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.eis.repository.SkillsRepository;
import com.rs.fer.eis.request.SaveSkillsRequest;
import com.rs.fer.eis.response.SaveSkillsResponse;
import com.rs.fer.eis.service.SkillsService;
import com.rs.fer.eis.util.SkillsUtil;

import java.util.List;

@Service
public class SkillsServiceImpl implements SkillsService {
	@Autowired
	SkillsUtil skillsUtil;

	@Autowired
	SkillsRepository skillsRepository;

	@Override
	public SaveSkillsResponse saveSkills(SaveSkillsRequest request) {
		SaveSkillsResponse response = null;

		// User is present or not check
		List skill = (List) skillsRepository.findByName(request.getName());

		if (!CollectionUtils.isEmpty((Collection<?>) skill)) {
			// User alreadypresent

			response = new SaveSkillsResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"User is already registered with the given name", null);

			return response;
		}

		// load vo to bean
		Skills skills = skillsUtil.loadSaveSkillsRequestToSkills(request);

		// save bean to database
		skills = skillsRepository.save(skills);

		// load response
		if (skills.getId() > 0) {
			// success
			response = new SaveSkillsResponse(HttpStatus.OK, "000", "Skills added  succesfully ", null);
			response.setSkills(skills);
		} else {
			// failure
			response = new SaveSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Skills is failed", null);
		}

		return response;

	}
}
