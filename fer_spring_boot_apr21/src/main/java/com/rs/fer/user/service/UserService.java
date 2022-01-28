package com.rs.fer.user.service;

import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.response.UpdateUserResponse;

public interface UserService {

	UpdateUserResponse updateuser(UpdateUserRequest request);

	RegistrationResponse registration(RegistrationRequest request);

	LoginResponse login(LoginRequest request);

	ResetPasswordResponse resetPassword(ResetPasswordRequest requestd);

	GetUserResponse getUser(int userid);
	

}
