package com.rs.fer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.UpdateUserResponse;
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
	public LoginResponse login1(@RequestBody LoginRequest request) {

		LoginResponse response = null;

		Set<String> errorMessages = userValidation.validateLoginRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new LoginResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.login(request);
		}
		return response;
	}
	
	@PostMapping("/userRegistration")
	public RegistrationResponse userRegistration(@ModelAttribute RegistrationRequest request) {

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
	
	
	
	
	@PostMapping("/userLogin")
	public LoginResponse login(@ModelAttribute LoginRequest request) {
		LoginResponse response = null;

		Set<String> errorMessages = userValidation.validateLoginRequest(request);
		// return response with error messages
		 if(!CollectionUtils.isEmpty(errorMessages)) {
			response = new LoginResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.login(request);
		}
		return response;
	}
	
	@PostMapping("/updateUser")
	public UpdateUserResponse userUpdate(@RequestBody UpdateUserRequest request) {
		UpdateUserResponse response = null;

		Set<String> errorMessages = userValidation.validateUpdateUserRequest(request);
		// return response with error messages
		 if(!CollectionUtils.isEmpty(errorMessages)) {
			response = new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.updateUser(request);
		}
		 
		  
		return response ;
	}
	  
	
	
	@PostMapping("/getuser")
	public GetUserResponse getuser(@RequestBody GetUserRequest request) {

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
