package com.rs.fer.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.eis.request.SaveSkillsRequest;
import com.rs.fer.eis.response.SaveSkillsResponse;
import com.rs.fer.eis.service.SkillsService;
import com.rs.fer.eis.validation.SkillsValidation;

@RestController
@RequestMapping("/api")
public class SkillsController {
	@Autowired
	SkillsValidation skillsValidation;
	@Autowired
	SkillsService skillsService;

	@PostMapping("/saveSkills")
	public SaveSkillsResponse saveSkill(@RequestBody SaveSkillsRequest request) {

		SaveSkillsResponse response = null;

		Set<String> errorMessages = skillsValidation.validateSaveSkillsRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveSkillsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = skillsService.saveSkills(request);
		}
		return response;
	}

}
