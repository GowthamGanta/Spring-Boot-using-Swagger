package com.rs.fer.admin.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.GetBlockUserRequest;
import com.rs.fer.admin.request.GetUnblockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.BlockUserResponse;
import com.rs.fer.admin.response.GetBlockUserResponse;
import com.rs.fer.admin.response.GetUnblockUserResponse;
import com.rs.fer.admin.response.UnblockUserResponse;
import com.rs.fer.admin.service.AdminService;
import com.rs.fer.admin.validation.AdminValidation;

@RestController
@RequestMapping("/api")
public class AdminController2 {

	@Autowired
	AdminValidation adminValidation;

	@Autowired
	AdminService adminService;

	@PostMapping("/blockUser")
	public BlockUserResponse blockUser(@RequestBody BlockUserRequest request) {

		BlockUserResponse response = null;

		Set<String> errorMessages = adminValidation.validateBlockUserRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new BlockUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = adminService.blockUser(request);
		}
		return response;
	}

	@PostMapping("/blockUser2")
	public BlockUserResponse blockUser2(@RequestBody BlockUserRequest request) {

		BlockUserResponse response = null;

		Set<String> errorMessages = adminValidation.validateBlockUserRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new BlockUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = adminService.blockUser(request);
		}
		return response;
	}

	@PostMapping("/unblockUser")
	public UnblockUserResponse unblockUser(@RequestBody UnblockUserRequest request) {

		UnblockUserResponse response = null;

		Set<String> errorMessages = adminValidation.validateUnblockUserRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UnblockUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = adminService.unblockUser(request);
		}
		return response;
		
	}
	@PostMapping("/unblockUser2")
	public UnblockUserResponse unblockUser2(@RequestBody UnblockUserRequest request) {

		UnblockUserResponse response = null;

		Set<String> errorMessages = adminValidation.validateUnblockUserRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UnblockUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = adminService.unblockUser(request);
		}
		return response;
		
	}

}