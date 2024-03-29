package com.rs.fer.admin.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.GetBlockUserRequest;
import com.rs.fer.admin.request.GetUnblockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.BlockUserResponse;
import com.rs.fer.admin.response.GetBlockUserResponse;
import com.rs.fer.admin.response.GetUnblockUserResponse;
import com.rs.fer.admin.response.UnblockUserResponse;
import com.rs.fer.admin.service.AdminService;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;

import com.rs.fer.user.util.UserUtil;

@Service

public class AdminServiceImpl implements AdminService {

	@Autowired
	
	UserUtil userUtil;

	@Autowired
	
	UserRepository userRepository;

	@Override
	public BlockUserResponse blockUser(BlockUserRequest request) {
		BlockUserResponse response = null;

	   // To get the user based on userId
		Optional<User> userObj = userRepository.findById(request.getId());
		// user is not present
		if (!userObj.isPresent()) {
			response = new BlockUserResponse(HttpStatus.PRECONDITION_FAILED, "001", "User is not found", null);

		}

		else {

			User user = userObj.get();
			// If user already is blocked

			if ("y".equals(user.getBlockStatus())) {
				response = new BlockUserResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "user already blocked", null);

			} else {
				// block the user
				user.setBlockStatus("y");
				userRepository.save(user);
				response = new BlockUserResponse(HttpStatus.OK, "000", "user upate is succesfully ", null);
				response.setUser(user);

			}

		}
		return response;
	}

	@Override
	public UnblockUserResponse unblockUser(UnblockUserRequest request) {
		UnblockUserResponse response = null;

		// To get the user based on userId
		Optional<User> userObj = userRepository.findById(request.getId());
		// user is not present
		if (!userObj.isPresent()) {
			response = new UnblockUserResponse(HttpStatus.PRECONDITION_FAILED, "001", "User is not present", null);

		}

		else {

			User user = userObj.get();
			// If user already is blocked

			if ("N".equals(user.getBlockStatus())) {
				response = new UnblockUserResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User is already unblocked",
						null);

			} else {
				// unblock the user
				user.setBlockStatus("N");
				userRepository.save(user);
				response = new UnblockUserResponse(HttpStatus.OK, "000", "User unblocked  succesfully ", null);
				response.setUser(user);

			}

		}
		return response;

	}

	@Override
	public GetUnblockUserResponse getUnblockUsers(GetUnblockUserRequest request) {

		GetUnblockUserResponse response = null;

		List<User> users = userRepository.findByBlockStatus("N");
		if (users.isEmpty()) {
			// no results found
			response = new GetUnblockUserResponse(HttpStatus.OK, "101", "No users found", null);

		} else {

			// success
			response = new GetUnblockUserResponse(HttpStatus.OK, "000", "User present ", null);
			response.setUsers(users);
		}

		return response; 
	}  

	@Override
	public GetBlockUserResponse getBlockUsers(GetBlockUserRequest request) {

		GetBlockUserResponse response = null;

		List<User> users = userRepository.findByBlockStatus("Y");
		if (users.isEmpty()) {
			// no results found
			response = new GetBlockUserResponse(HttpStatus.OK, "101", "No users found", null);

		} else {
			//success
			response = new GetBlockUserResponse(HttpStatus.OK, "000", "User present ", null);
			response.setUsers(users);
		}

		return response;

	}

}
