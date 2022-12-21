package com.rs.fer.admin.validation;

import java.util.Set;

import com.rs.fer.user.request.BlockUserRequest;
import com.rs.fer.user.request.UnblockUserRequest;

public interface AdminValidation {

	Set<String> validateBlockUserRequest(BlockUserRequest request);

	Set<String> validateUnblockUserRequest(UnblockUserRequest request);
}
 