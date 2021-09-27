package com.rs.fer.user.validation;

import java.util.Set;

import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;

public interface UserValidation {

	Set<String> validateRegistrationRequest(RegistrationRequest request);

	Set<String> validateResetPasswordRequest(ResetPasswordRequest request);


	Set<String> validateGetUserRequest(int userId);
	
	Set<String> validateUpdateUserRequest(UpdateUserRequest request);
}
