package com.rs.fer.user.validation;

import java.util.Set;

import com.rs.fer.user.request.EditRatingRequest;
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.SaveRatingRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.request.VerifyEmailRequest;
import com.rs.fer.user.request.VerifyOtpRequest;

public interface UserValidation {

	Set<String> validateRegistrationRequest(RegistrationRequest request);

	Set<String> validateLoginRequest(LoginRequest request);

	Set<String> validateResetPasswordRequest(ResetPasswordRequest request);

	Set<String> validateGetUserRequest(GetUserRequest request);

	Set<String> validateUpdateUserRequest(UpdateUserRequest request);

	Set<String> verifyEmailRequest(VerifyEmailRequest request);

	Set<String> verifyOtpRequest(VerifyOtpRequest request);


	Set<String> validateSaveRatingRequest(SaveRatingRequest request);
	
	Set<String> validateEditRatingRequest(EditRatingRequest request);
}
