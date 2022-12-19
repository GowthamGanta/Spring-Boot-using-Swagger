package com.rs.fer.user.service;

import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.request.VerifyEmailRequest;
import com.rs.fer.user.request.VerifyOtpRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.response.UpdateUserResponse;
import com.rs.fer.user.response.VerifyEmailResponse;
import com.rs.fer.user.response.VerifyOtpResponse;

public interface UserService {

	UpdateUserResponse updateUser(UpdateUserRequest request);

	RegistrationResponse registration(RegistrationRequest request);

	LoginResponse login(LoginRequest request);

	ResetPasswordResponse resetPassword(ResetPasswordRequest request);

	GetUserResponse getUser(GetUserRequest request);


	VerifyOtpResponse verifyOtp(VerifyOtpRequest request);


	VerifyEmailResponse verifyEmail(VerifyEmailRequest request);

}
