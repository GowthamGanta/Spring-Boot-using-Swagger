package com.rs.fer.admin.service;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.GetBlockUserRequest;
import com.rs.fer.admin.request.GetUnblockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.BlockUserResponse;
import com.rs.fer.admin.response.GetBlockUserResponse;
import com.rs.fer.admin.response.GetUnblockUserResponse;
import com.rs.fer.admin.response.UnblockUserResponse;

public interface AdminService {

	BlockUserResponse blockUser(BlockUserRequest request);

	UnblockUserResponse unblockUser(UnblockUserRequest request);

	GetUnblockUserResponse getUnblockUsers(GetUnblockUserRequest request);

	GetBlockUserResponse getBlockUsers(GetBlockUserRequest request);
	

}
