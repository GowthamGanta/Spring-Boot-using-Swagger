package com.rs.fer.group.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.util.GroupUtil;

@Component
public class GroupUtilImpl implements GroupUtil {

	@Override
	public Group loadSaveGroupRequest(SaveGroupRequest request, int userId, String groupName) {
		Group group = new Group();

		group.setUserId(request.getUserId());
		group.setGroupName(request.getGroupName());

		return group;

	}
}
