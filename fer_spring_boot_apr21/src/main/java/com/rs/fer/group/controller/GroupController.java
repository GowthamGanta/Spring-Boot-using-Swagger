package com.rs.fer.group.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.response.SaveGroupResponse;
import com.rs.fer.group.service.GroupService;
import com.rs.fer.group.validation.GroupValidation;

@RestController
@RequestMapping("/api")
public class GroupController {

	@Autowired
	GroupService groupService;

	@Autowired
	GroupValidation groupValidation;

	@PostMapping("/saveGroup")
	public SaveGroupResponse saveGroup(@RequestBody SaveGroupRequest request) {

		SaveGroupResponse response = null;
		Set<String> errorMessages = groupValidation.validateSaveGroupRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveGroupResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = groupService.saveGroup(request);
		}

		return response;
	}

}
