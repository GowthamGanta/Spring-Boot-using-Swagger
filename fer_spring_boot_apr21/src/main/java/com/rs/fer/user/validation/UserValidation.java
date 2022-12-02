package com.rs.fer.user.validation;

import java.util.Set;

import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;

public interface UserValidation {

	Set<String> validateRegistrationRequest(RegistrationRequest request);

	Set<String> validateLoginRequest(LoginRequest request);

	Set<String> validateResetPasswordRequest(ResetPasswordRequest request);

	Set<String> validateGetUserRequest(GetUserRequest request);

	Set<String> validateUpdateUserRequest(UpdateUserRequest request);
}
