package com.rs.fer.follow.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.response.SaveFollowerResponse;
import com.rs.fer.follow.service.FollowerService;
import com.rs.fer.follow.validation.FollowValidation;

@RestController
@RequestMapping("/followers")
public class FollowController {

	@Autowired
	FollowValidation followValidation;

	@Autowired
	FollowerService followerService;

	@PostMapping("/saveFollower")
	public SaveFollowerResponse saveFollower(@RequestBody SaveFollowerRequest request) {

		SaveFollowerResponse response = null;
		Set<String> errorMessages = followValidation.validateSaveFollowerRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveFollowerResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = followerService.saveFollower(request);
		}

		return response;
	}

}
