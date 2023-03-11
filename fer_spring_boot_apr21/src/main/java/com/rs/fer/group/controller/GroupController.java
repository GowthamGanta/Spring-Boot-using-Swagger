package com.rs.fer.group.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.group.request.DeleteGroupRequest;
import com.rs.fer.group.request.GetGroupRequest;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.response.DeleteGroupResponse;
import com.rs.fer.group.response.GetGroupResponse;
import com.rs.fer.group.response.SaveGroupResponse;
import com.rs.fer.group.service.GroupService;
import com.rs.fer.group.validation.GroupValidation;

@RestController
@RequestMapping("/api")
public class GroupController {

	@Autowired
	GroupValidation groupValidation;

	@Autowired
	GroupService groupService;

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

	@DeleteMapping("/deleteGroup")
	public DeleteGroupResponse deleteGroup(@RequestBody DeleteGroupRequest request) {

		DeleteGroupResponse response = null;
		Set<String> errorMessages = groupValidation.validateDeleteGroupRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteGroupResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = groupService.deleteGroup(request);
		}

		return response;
	}

	@PostMapping("/getParticipants")
	public GetGroupResponse getGroup(@RequestBody GetGroupRequest request) {

		GetGroupResponse response = null;
		Set<String> errorMessages = groupValidation.validateGetGroupRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetGroupResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = groupService.getGroup(request);
		}

		return response;
	}
}
