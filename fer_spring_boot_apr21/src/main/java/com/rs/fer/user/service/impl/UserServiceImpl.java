package com.rs.fer.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
//github.com/javars100321/javars_jan21.git
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.response.UpdateUserResponse;
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserUtil userUtil;

	@Autowired
	UserRepository userRepository;

	@Override
	public RegistrationResponse registration(RegistrationRequest request) {
		RegistrationResponse response = null;

		// User is present or not check
		List<User> users = userRepository.findByEmail(request.getEmail());

		if (!CollectionUtils.isEmpty(users)) {
			// User already present
			response = new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"User is already registered with the given email address", null);
			return response;
		}

		// load vo to bean
		User user = userUtil.loadRegistrationRequestToUser(request);

		// save bean to database
		user = userRepository.save(user);

		// load response
		if (user.getUserId() > 0) {
			// success
			response = new RegistrationResponse(HttpStatus.OK, "000", "User is succesfully registered", null);
			response.setUser(user);
		} else {
			// failure
			response = new RegistrationResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User registration is failed",
					null);
		}

		return response;
		// return null;
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		LoginResponse response = null;
		int userid = 0;
		
		// load vo to bean
		String username = request.getUsername();
		String password= request.getPassword();
		// List<User> findByUsernameAndPassword(String username, String password);

		// save bean to database
//		List<User> user = userRepository.findByUsernameAndPassword(request);

		List<User> users = userRepository.findByUsernameAndPassword( username,  password);
		if (users != null && !users.isEmpty()) {
			User user1 = users.get(0);
			userid = user1.getUserId();
		}

		// load response
		if (userid > 0) {
			// success
			response = new LoginResponse(HttpStatus.OK, "000", "Welcome to user", null);
			//response.setUser(user);
		} else {
			// failure
			response = new LoginResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Invalid username/password..Please try again.", null);
		}

		return response;
		// return null;
	}

	/**
	 * To get the password based on userId
	 * 
	 * @param userId
	 * @return response
	 */
	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
		ResetPasswordResponse response = null;
		Optional<User> userObj = userRepository.findById(request.getUserId());
		if (userObj.isPresent()) {
			User user = userObj.get();
			if (user.getPassword().equals(request.getCurrentPassword())) {

				// success
				user.setPassword(request.getNewPassword());
				userRepository.save(user);
				response = new ResetPasswordResponse(HttpStatus.OK, "000", "password changed successfully", null);
			} else {

				// failure

				response = new ResetPasswordResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
						"Current Password and password which is on the account are not matching", null);

			}

		} else {
			response = new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "002", "User is not foiund", null);
		}
		return response;
	}

	/**
	 * To get the user based on userid
	 * 
	 * @param userid
	 * @return response
	 */
	@Override
	public GetUserResponse getUser(GetUserRequest request) {
		GetUserResponse response = null;

		// To get the user based on userId
		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (userObj.isPresent()) {
			// If user is present
			response = new GetUserResponse(HttpStatus.OK, "000", "get User is succesfully ", null);
			response.setUser(userObj.get());

		} else {
			// If user not present
			response = new GetUserResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "get user is failed", null);

		}

		return response;
	}

	/**
	 * UpdateUser
	 * 
	 * @param request
	 * @return
	 */
	@Override

	public UpdateUserResponse updateUser(UpdateUserRequest request) {
		UpdateUserResponse response = null;

		// User is present or not check
		List<User> users = userRepository.findByEmail(request.getEmail());

		if (!CollectionUtils.isEmpty(users)) {
			// User already present
			response = new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"User is already registered with the given email address", null);
			return response;
		}

		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (userObj.isPresent()) {

			// load vo to bean

			User user = userUtil.loadUpdateUserRequestToUser(request);

			// save bean to database
			user = userRepository.save(user);

			// User already present
			response = new UpdateUserResponse(HttpStatus.OK, "000", "User is updated successfully", null);
			response.setUser(user);
		} else {
			// failure
			response = new UpdateUserResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User update failed", null);
		}

		return response;
	}


}
