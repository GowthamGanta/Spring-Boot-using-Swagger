package com.rs.fer.user.validation;

import java.util.Set;

import com.rs.fer.user.request.BlockUserRequest;

public interface AdminValidation {

	Set<String> validateBlockUserRequest(BlockUserRequest request);
}
