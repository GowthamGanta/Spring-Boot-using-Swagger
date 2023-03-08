package com.rs.fer.follow.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.follow.request.DeletefollowerRequest;
import com.rs.fer.follow.request.GetFollowersRequest;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.response.DeletefollowerResponse;
import com.rs.fer.follow.response.GetFollowersResponse;
import com.rs.fer.follow.response.SaveFollowerResponse;
import com.rs.fer.follow.service.FollowerService;
import com.rs.fer.follow.validation.FollowValidation;
import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.response.DeleteMessageResponse;

@RestController
@RequestMapping("/api")
public class FollowController {

	@Autowired
	FollowerService followerService;

	@Autowired
	FollowValidation followValidation;

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

	@DeleteMapping("/deleteFollower")
	public DeletefollowerResponse deleteFollower(@RequestBody DeletefollowerRequest request) {

		DeletefollowerResponse response = null;
		Set<String> errorMessages = followValidation.validateDeleteFollowerRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new DeletefollowerResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = followerService.deleteFollower(request);
		}

		return response;
	}

	@GetMapping("/getFollowers")
	public GetFollowersResponse getFollowers(@RequestBody GetFollowersRequest request) {

		GetFollowersResponse response = null;
		Set<String> errorMessges = followValidation.validateGetFollowersRequest(request);

		if (!CollectionUtils.isEmpty(errorMessges)) {
			response = new GetFollowersResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessges);

		} else {
			response = followerService.getFollowers(request);
		}

		return  response;
	}

}
