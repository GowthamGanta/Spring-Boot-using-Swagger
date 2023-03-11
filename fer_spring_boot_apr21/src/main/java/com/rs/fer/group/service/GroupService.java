package com.rs.fer.group.service;

import com.rs.fer.group.request.DeleteGroupRequest;
import com.rs.fer.group.request.GetGroupRequest;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.response.DeleteGroupResponse;
import com.rs.fer.group.response.GetGroupResponse;
import com.rs.fer.group.response.SaveGroupResponse;

public interface GroupService {

	SaveGroupResponse saveGroup(SaveGroupRequest saveGroupRequest);

	GetGroupResponse getGroup(GetGroupRequest request);

	DeleteGroupResponse deleteGroup(DeleteGroupRequest request);
	
}
