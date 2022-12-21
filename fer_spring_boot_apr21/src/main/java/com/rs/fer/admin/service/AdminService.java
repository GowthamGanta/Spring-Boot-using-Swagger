package com.rs.fer.admin.service;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.BlockUserResponse;
import com.rs.fer.admin.response.UnblockUserResponse;

public interface AdminService {

	BlockUserResponse blockUser(BlockUserRequest request);

	UnblockUserResponse unblockUser(UnblockUserRequest request);
 
}
 