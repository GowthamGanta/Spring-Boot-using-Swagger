package com.rs.fer.controller;

import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.validation.UserValidation;

/**
 * This class is mainly used for operations on user like registration, login,
 * resetPassword, getUser and updateUser.
 * 
 * @author Personal
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {

	private static final RegistrationRequest request = null;

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

	@PostMapping("/getUser")
	public GetUserResponse getUser(@RequestParam(value="userid" )GetUserRequest request) {

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

	@PostMapping("/getuser")
	public GetUserResponse getuser(@PathParam(value = "") GetUserRequest request) {

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
	
	@PostMapping("/restPassword")
	public ResetPasswordResponse resetPassword(@RequestBody ResetPasswordRequest request) {
		
		ResetPasswordResponse response = null;
		
		Set<String> errorMessages = userValidation.validateResetPasswordRequest(request);
		
		//return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED,"999",null,errorMessages);
			
		}else {
			response = userService.resetPassword(request);
		}
		
		return response;
		                            
	}
}
