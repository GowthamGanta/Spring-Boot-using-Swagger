package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.response.UpdateUserResponse;
//github.com/GowthamGanta/Spring-Boot-using-Swagger.git
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.validation.UserValidation;

@RestController
@RequestMapping("/api")
public class UserController {

	
	
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

	@PostMapping("/registration/ma")
	public RegistrationResponse registrationMa(@ModelAttribute RegistrationRequest request) {

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
	public void  login(@RequestBody LoginRequest request) {

		LoginResponse response = null;

		// int userId = ferService.login(username, password);
		Set<String> errorMessages = userValidation.validateLoginRequest(request);

		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new LoginResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = userService.login(request);
		}
		return;
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

	@PutMapping("/resetPassword")
	public void resetPassword(@RequestBody ResetPasswordRequest request) {

		ResetPasswordResponse response = null;

		Set<String> errorMessages = userValidation.validateResetPasswordRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.resetPassword(request);
		}
		return;
	}

	@PutMapping("/updateUser")
	public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request) {

		UpdateUserResponse response = null;

		Set<String> errorMessages = userValidation.validateUpdateUserRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.updateUser(request);
		}
		return response;
	}

}