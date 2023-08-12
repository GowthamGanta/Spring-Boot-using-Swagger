package com.rs.fer.user.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rs.fer.user.request.DeleteRatingRequest;
import com.rs.fer.user.request.EditRatingRequest;
import com.rs.fer.user.request.GetRatingRequest;
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.SaveRatingRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.request.VerifyEmailRequest;
import com.rs.fer.user.request.VerifyOtpRequest;
import com.rs.fer.user.response.DeleteRatingResponse;
import com.rs.fer.user.response.EditRatingResponse;
import com.rs.fer.user.response.GetRatingResponse;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.response.SaveRatingResponse;
import com.rs.fer.user.response.UpdateUserResponse;
import com.rs.fer.user.response.VerifyEmailResponse;
import com.rs.fer.user.response.VerifyOtpResponse;
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
 
	/*@PostMapping("/registration/ma")
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
	}*/

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

	@PutMapping("/resetPassword")
	public ResetPasswordResponse resetPassword(@RequestBody ResetPasswordRequest request) {

		ResetPasswordResponse response = null;

		Set<String> errorMessages = userValidation.validateResetPasswordRequest(request);

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
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.updateUser(request);
		}
		return response;
	}

	@PutMapping("/verifyOtp")
	public VerifyOtpResponse verifyOtp(@RequestBody VerifyOtpRequest request) {

		VerifyOtpResponse response = null;

		Set<String> errorMessages = userValidation.verifyOtpRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new VerifyOtpResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.verifyOtp(request);
		}
		return response;
	}

	@PutMapping("/verifyEmail")
	public VerifyEmailResponse verifyEmail(@RequestBody VerifyEmailRequest request) {

		VerifyEmailResponse response = null;

		Set<String> errorMessages = userValidation.verifyEmailRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new VerifyEmailResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.verifyEmail(request);
		}
		return response;
	}

	@PostMapping("/saveRating")
	public SaveRatingResponse saveRating(@RequestBody SaveRatingRequest request) {

		SaveRatingResponse response = null;

		Set<String> errorMessages = userValidation.validateSaveRatingRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveRatingResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.saveRating(request);
		}
		return response;
	}
	
	
	
	@PostMapping("/editRating")
	public EditRatingResponse editRating(@RequestBody EditRatingRequest request) {

		EditRatingResponse response = null;

		Set<String> errorMessages = userValidation.validateEditRatingRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new EditRatingResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.editRating(request);
		}
		return response;
	}
	@PostMapping("/deleteRating")
	public DeleteRatingResponse deleteRating(@RequestBody DeleteRatingRequest request) {

		DeleteRatingResponse response = null;

		Set<String> errorMessages = userValidation.validateDeleteRatingRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteRatingResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.deleteRating(request);
		}
		return response;
	}
	@PostMapping("/getRating")
	public GetRatingResponse getRating(@RequestBody GetRatingRequest request) {

		GetRatingResponse response = null;

		Set<String> errorMessages = userValidation.validateGetRatingRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetRatingResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.getRating(request);
		}
		return response;
	}
} 