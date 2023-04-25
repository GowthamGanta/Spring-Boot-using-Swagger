package com.rs.fer.user.validation.impl;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

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
import com.rs.fer.user.validation.UserValidation;
import com.rs.fer.util.FERUtil;

@Component
public class UserValidationImpl implements UserValidation {

	@Override
	public Set<String> validateRegistrationRequest(RegistrationRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirstname(), "Please enter First Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLastname(), "Please enter Lastname");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmail(), "Please enter Email");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUsername(), "Please enter Username");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPassword(), "Please enter Password");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMobile(), "Please enter Mobile");

		return errorMessages;
	}

	@Override
	public Set<String> validateResetPasswordRequest(ResetPasswordRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter UserId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCurrentPassword(),
				"Please enter CurrentPassword");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getNewPassword(), "Please enter NewPassword");
		// errorMessages = FERUtil.addErrorIfEmpty(errorMessages,
		// request.getConfirmNewPassword(), "Please enter ConfirmNewPassword");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetUserRequest(GetUserRequest request) {
		Set<String> errorMessages = new HashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter valid userId");

		return errorMessages;
	}

	@Override
	public Set<String> validateUpdateUserRequest(UpdateUserRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter User Id");

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirstname(), "Please enter First Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLastname(), "Please enter Lastname");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmail(), "Please enter Email");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMobile(), "Please enter Mobile");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLineone(), "Please enter Line One");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLinetwo(), "Please enter Line Two");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCity(), "Please enter City");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getState(), "Please enter state");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPincode(), "Please enter Pincode");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCountry(), "Please enter country");

		return errorMessages;

	}

	@Override
	public Set<String> validateLoginRequest(LoginRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUsername(), "Please enter Username");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPassword(), "Please enter Password");

		return errorMessages;
	}

	@Override
	public Set<String> verifyOtpRequest(VerifyOtpRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getOtp(), "Please enter Otp");

		return errorMessages;
	}

	@Override
	public Set<String> verifyEmailRequest(VerifyEmailRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getVerificationCode(),
				"Please enter VerificationCode");

		return errorMessages;
	}

	@Override
	public Set<String> validateSaveRatingRequest(SaveRatingRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getComments(), "Please enter Comments");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getRating(), "Please enter Rating");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getReviewerId(), "Please enter reviewer Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter User Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateEditRatingRequest(EditRatingRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getComments(), "Please enter Comments");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getRating(), "Please enter Rating");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getReviewerId(), "Please enter reviewer Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter User Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteRatingRequest(DeleteRatingRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getComments(), "Please enter Comments");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getRating(), "Please enter Rating");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getReviewerId(), "Please enter reviewer Id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter User Id");

		return errorMessages;
	}

	@Override
	public Set<String> validateGetRatingRequest(GetRatingRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getRatingId(), "Please enter valid RatingId");

		return errorMessages;
	}
}
