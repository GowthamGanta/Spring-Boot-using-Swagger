package com.rs.fer.group.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

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

@SpringBootTest
public class GroupServiceImplTest {

	@InjectMocks
	GroupServiceImpl groupServiceImpl;

	@Mock
	GroupService groupService;
	@Mock
	GroupRepository groupRepository;
	@Mock
	UserRepository userRepository;
	@Mock
	GroupUtil groupUtil;
	@Mock
	ParticipantRepository participantRepository;

	@Test
	public void testSaveGroup() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveGroupRequest request = new SaveGroupRequest();
		request.setGroupName("abc");
		request.setUserId(1);

		Group group = new Group();
		group.setId(5);

		// mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(groupUtil.loadSaveGroupRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyString())).thenReturn(group);

		when(groupRepository.save(Mockito.any())).thenReturn(group);

		SaveGroupResponse response = groupServiceImpl.saveGroup(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testSaveGroupFailure() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveGroupRequest request = new SaveGroupRequest();
		request.setGroupName("abc");
		request.setUserId(1);

		Group group = new Group();
		// group.setId(5);

		// mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(groupUtil.loadSaveGroupRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyString())).thenReturn(group);

		when(groupRepository.save(Mockito.any())).thenReturn(group);

		SaveGroupResponse response = groupServiceImpl.saveGroup(request);

		assertEquals("001", response.statusCode);

	}

	@Test
	public void testGroupUserNotFound() {

		Optional<User> userObj = Optional.empty();
		SaveGroupRequest request = new SaveGroupRequest();

		// mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		SaveGroupResponse response = groupServiceImpl.saveGroup(request);

		assertEquals("801", response.statusCode);

	}

	@Test
	public void testGetGroup() {

		Group group = new Group();
		User user = new User();
		Optional<Group> groupObj = Optional.of(group);
		Optional<User> userObj = Optional.of(user);

		GetGroupRequest request = new GetGroupRequest();
		request.setGroupId(1);
		List<Participant> participantObj = new ArrayList<Participant>(1);
		Participant participant = new Participant();
		participant.setGroupId(1);
		participantObj.add(participant);

		// mock

		when(groupRepository.findById(Mockito.anyInt())).thenReturn(groupObj);

		when(participantRepository.findByGroupId(Mockito.anyInt())).thenReturn(participantObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		GetGroupResponse response = groupServiceImpl.getGroup(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetGroupNotFound() {

		Optional<Group> groupObj = Optional.empty();
		GetGroupRequest request = new GetGroupRequest();

		// mock
		when(groupRepository.findById(Mockito.anyInt())).thenReturn(groupObj);
		GetGroupResponse response = groupServiceImpl.getGroup(request);

		assertEquals("803", response.statusCode);

	}

	@Test
	public void testDeleteGroup() {

		Group groups = new Group();
		Optional<Group> groupObj = Optional.of(groups);

		DeleteGroupRequest request = new DeleteGroupRequest();
		request.setGroupId(1);

		Group group = new Group();
		group.setId(5);

		// mock

		when(groupRepository.findById(Mockito.anyInt())).thenReturn(groupObj);

		DeleteGroupResponse response = groupServiceImpl.deleteGroup(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testDeleteGroupNotFound() {

		Optional<Group> groupObj = Optional.empty();
		DeleteGroupRequest request = new DeleteGroupRequest();

		// mock
		when(groupRepository.findById(Mockito.anyInt())).thenReturn(groupObj);
		DeleteGroupResponse response = groupServiceImpl.deleteGroup(request);

		assertEquals("802", response.statusCode);

	}

}