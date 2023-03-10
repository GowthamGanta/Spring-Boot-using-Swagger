package com.rs.fer.group.service;

import com.rs.fer.group.request.DeleteGroupRequest;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.response.DeleteGroupResponse;
import com.rs.fer.group.response.SaveGroupResponse;

public interface GroupService {

	SaveGroupResponse saveGroup(SaveGroupRequest saveGroupRequest);

	DeleteGroupResponse deleteGroup(DeleteGroupRequest request);
	
}
