package com.rs.fer.eis.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.eis.repository.SkillsRepository;
import com.rs.fer.eis.request.DeleteSkillsRequest;
import com.rs.fer.eis.request.EditSkillsRequest;
import com.rs.fer.eis.request.GetSkillsRequest;
import com.rs.fer.eis.request.SaveSkillsRequest;
import com.rs.fer.eis.response.DeleteSkillsResponse;
import com.rs.fer.eis.response.EditSkillsResponse;
import com.rs.fer.eis.response.GetSkillsResponse;
import com.rs.fer.eis.response.SaveSkillsResponse;
import com.rs.fer.eis.service.SkillsService;
import com.rs.fer.eis.util.SkillsUtil;

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

	@Override
	public DeleteSkillsResponse deleteSkills(DeleteSkillsRequest request) {
		DeleteSkillsResponse response = null;

		// To get the User based on userId
		Optional<Skills> skillsObj = skillsRepository.findById(request.getId());

		// If user is not present
		if (skillsObj.isPresent()) {

			skillsRepository.deleteById(request.getId());

			response = new DeleteSkillsResponse(HttpStatus.OK, "000", "Skills deleted successfully ", null);
			response.setSkills(skillsObj.get());

		} else {
			// failure
			response = new DeleteSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "106", "Skills deletion failed",
					null);
		}

		return response;
	}

	@Override
	public GetSkillsResponse getSkills(GetSkillsRequest request) {
		GetSkillsResponse response = null;

		// To get the user based on userId
		Optional<Skills> skillsObj = skillsRepository.findById(request.getId());

		if (skillsObj.isPresent()) {
			// If user is present
			response = new GetSkillsResponse(HttpStatus.OK, "000", "fetched Skills details", null);
			response.setSkills(skillsObj.get());

		} else {
			// if user not present
			response = new GetSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No Skills found", null);
		}
		return response;
	}

	@Override
	public EditSkillsResponse editSkills(EditSkillsRequest request) {
		EditSkillsResponse response = null;
		// employee is present or not check
		Optional<Skills> skillsObj = skillsRepository.findById(request.getId());

		if (skillsObj.isPresent()) {

			Skills skills = skillsObj.get();

			// load vo to bean
			skills = skillsUtil.loadEditSkillsRequestToSkills(request,skills);

			// save bean to databae
			skills = skillsRepository.save(skills);

			// load response
			// success
			response = new EditSkillsResponse(HttpStatus.OK, "000", " skills edited  succesfully ", null);
			response.setSkills(skills);
		} else {
			// failure
			response = new EditSkillsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "skills editing failed", null);
		}

		return response;
	}

}
