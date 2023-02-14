package com.rs.fer.admin.validation;

import java.util.Set;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.GetBlockUserRequest;
import com.rs.fer.admin.request.GetUnblockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;


public interface AdminValidation {

	Set<String> validateBlockUserRequest(BlockUserRequest request);

	Set<String> validateUnblockUserRequest(UnblockUserRequest request);
	
	Set<String> validateGetBlockUserRequest(GetBlockUserRequest request);
	
	Set<String> validateGetUnblockUserRequest(GetUnblockUserRequest request);
}
 