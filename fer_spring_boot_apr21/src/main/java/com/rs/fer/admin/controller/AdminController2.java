package com.rs.fer.admin.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.BlockUserResponse;
import com.rs.fer.admin.response.GetBlockUserResponse;
import com.rs.fer.admin.response.GetUnblockUserResponse;
import com.rs.fer.admin.response.UnblockUserResponse;
import com.rs.fer.admin.service.AdminService;
import com.rs.fer.admin.validation.AdminValidation;
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.validation.UserValidation;

@RestController
@RequestMapping("/adminapi")
public class AdminController2 {

	@Autowired
	UserValidation userValidation;

	@Autowired
	UserService userService;

	@PostMapping("/registration")
	public RegistrationResponse registration(@RequestBody RegistrationRequest request) {

		RegistrationResponse response = null;

		Set<String> errorMessages = userValidation.validateRegistrationRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.registration(request);
		}

		return response;

	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {

		LoginResponse response = null;

		// int userId = ferService.login(username, password);
		Set<String> errorMessages = userValidation.validateLoginRequest(request);

		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new LoginResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = userService.login(request);
		}
		return response;
	}
	@PostMapping("/getUser")
	public GetUserResponse getUser(@RequestBody GetUserRequest request) {

		GetUserResponse response = null;

		Set<String> errorMessages = userValidation.validateGetUserRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.getUser(request);
		}
		return response;
	}
}