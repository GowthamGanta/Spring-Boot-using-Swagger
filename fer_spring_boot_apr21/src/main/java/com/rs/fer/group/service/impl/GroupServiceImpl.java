package com.rs.fer.group.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.repository.GroupRepository;
import com.rs.fer.group.request.DeleteGroupRequest;
import com.rs.fer.group.request.GetGroupRequest;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.response.DeleteGroupResponse;
import com.rs.fer.group.response.GetGroupResponse;
import com.rs.fer.group.response.SaveGroupResponse;
import com.rs.fer.group.service.GroupService;
import com.rs.fer.group.util.GroupUtil;
import com.rs.fer.participant.Participant;
import com.rs.fer.participant.repository.ParticipantRepository;
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

	@Autowired
	ParticipantRepository participantRepository;

	@Override
	public SaveGroupResponse saveGroup(SaveGroupRequest request) {
		SaveGroupResponse response = null;
		Group group = new Group();

		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (!userObj.isPresent()) {
			response = new SaveGroupResponse(HttpStatus.OK, "801", " User Not Found", null);
		} else {

		group = groupUtil.loadSaveGroupRequest(request, request.getUserId(), request.getGroupName());

		groupRepository.save(group);

		// response if success
		if (group.getId() > 0) {
			response = new SaveGroupResponse(HttpStatus.OK, "000", " Group Created Successfully", null);

		} else {
			// response if failure
			response = new SaveGroupResponse(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Group creating Failed", null);

		}
		}
		return response;
	}

	@Override
	public DeleteGroupResponse deleteGroup(DeleteGroupRequest request) {
		DeleteGroupResponse response = null;
		Optional<Group> groupObj = groupRepository.findById(request.getGroupId());

		if (!groupObj.isPresent()) {
			response = new DeleteGroupResponse(HttpStatus.OK, "802", " GroupId Not Found", null);
		} else {
		Group group = groupObj.get();

		int delete = group.getId();

		groupRepository.deleteById(delete);

		response = new DeleteGroupResponse(HttpStatus.OK, "000", " GroupId deleted Successfully", null);
		}
		return response;

	}

	@Override
	public GetGroupResponse getGroup(GetGroupRequest getGroupRequest) {
		GetGroupResponse response = null;

		User user = new User();
		List<String> users = new LinkedList<>();

		Optional<Group> groupObj = groupRepository.findById(getGroupRequest.getGroupId());
		if (!groupObj.isPresent()) {

			response = new GetGroupResponse(HttpStatus.PRECONDITION_FAILED, "803", "Group not Found", null);

		} else {
			
		List<Participant> participantObj = participantRepository.findByGroupId(getGroupRequest.getGroupId());

		for (Participant participant : participantObj) {
			Optional<User> userObj = userRepository.findById(participant.getParticipantId());
			user = userObj.get();
			users.add(user.getFirstname());
		}
		// response.setGroupParticipants(users);

		response = new GetGroupResponse(HttpStatus.OK, "000", "Fetch Participants", null);
		response.setUsers(users);
		}
		return response;
	}
}
