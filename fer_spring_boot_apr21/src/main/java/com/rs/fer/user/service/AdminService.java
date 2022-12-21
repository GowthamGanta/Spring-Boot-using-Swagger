package com.rs.fer.user.service;

import com.rs.fer.user.request.BlockUserRequest;
import com.rs.fer.user.request.UnblockUserRequest;
import com.rs.fer.user.response.BlockUserResponse;
import com.rs.fer.user.response.UnblockUserResponse;

public interface AdminService {

	BlockUserResponse blockUser(BlockUserRequest request);

	UnblockUserResponse unblockUser(UnblockUserRequest request);

}
