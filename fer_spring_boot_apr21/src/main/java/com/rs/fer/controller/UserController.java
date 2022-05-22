package com.rs.fer.controller;

import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.bean.User;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
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

	@GetMapping("/getUser")
	public GetUserResponse getUser(@RequestParam int userId) {

		GetUserResponse response = null;

		Set<String> errorMessages = userValidation.validateGetUserRequest(userId);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.getUser(userId);
		}
		return response;
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody String username, String password, LoginRequest userid) {

		LoginResponse response = null;

		Set<String> errorMessages = userValidation.validateLoginRequest(userid);
		// return response with error messages
		 if(!CollectionUtils.isEmpty(errorMessages)) {
			response = new LoginResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.login(userid);
		}
		return response;
	}

	
	
	@PutMapping("/resetPassword")
	   public  ResetPasswordResponse resetPassword(@RequestBody ResetPasswordRequest request){
		ResetPasswordResponse response = null;
		Set<String> errorMessages = userValidation.validateResetPasswordRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.resetPassword(request);
		}
		return response;
	}
	  
	

@PutMapping("/updateUser")
	public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request) {
		UpdateUserResponse response = null;
		Set<String> errorMessages = userValidation.validateUpdateUserRequest(request);
//return response errorMessages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = userService.updateUser(request);
		}
		return response;
	}

	@PutMapping("/updateUser2")
	public UpdateUserResponse updateUser2(@ModelAttribute UpdateUserRequest request) {
		UpdateUserResponse response = null;
		Set<String> errorMessages = userValidation.validateUpdateUserRequest(request);
//return response errorMessages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = userService.updateUser(request);
		}
		return response;
	}
}
