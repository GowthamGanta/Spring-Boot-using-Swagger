package com.rs.fer.group.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.repository.GroupRepository;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.response.SaveGroupResponse;
import com.rs.fer.group.service.GroupService;
import com.rs.fer.group.util.GroupUtil;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupUtil groupUtil;

	@Autowired
	UserRepository userRepository;

	@Autowired
	GroupRepository groupRepository;

	@Override
	public SaveGroupResponse saveGroupResponse(SaveGroupRequest request) {
		SaveGroupResponse response = null;
		Group group = new Group();

		Optional<User> userObj = userRepository.findById(request.getUserId());
		
		if(!userObj.isPresent()) {
			response = new SaveGroupResponse(HttpStatus.OK, "801", " User Not Found", null);
		}

		group = groupUtil.loadSaveGroupRequest(request, request.getUserId(), request.getGroupName());

		groupRepository.save(group);

		// response if success
		if (group.getId() > 0) {
			response = new SaveGroupResponse(HttpStatus.OK, "000", " Group Created Successfully", null);

		} else {
			// response if failure
			response = new SaveGroupResponse(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Group creating Failed", null);

		}

		return response;
	}

}
