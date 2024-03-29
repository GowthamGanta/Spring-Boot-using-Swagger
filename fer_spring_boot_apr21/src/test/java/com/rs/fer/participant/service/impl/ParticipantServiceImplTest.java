package com.rs.fer.participant.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.repository.GroupRepository;
import com.rs.fer.participant.Participant;
import com.rs.fer.participant.repository.ParticipantRepository;
import com.rs.fer.participant.request.DeleteParticipantRequest;
import com.rs.fer.participant.request.SaveParticipantRequest;
import com.rs.fer.participant.response.DeleteParticipantResponse;
import com.rs.fer.participant.response.SaveParticipantResponse;
import com.rs.fer.participant.service.ParticipantService;
import com.rs.fer.participant.util.ParticipantUtil;
import com.rs.fer.user.repository.UserRepository;

@SpringBootTest
public class ParticipantServiceImplTest {
	
	@InjectMocks
	ParticipantServiceImpl participantServiceImpl;

	@Mock
	ParticipantService participantService;
	@Mock
	ParticipantRepository participantRepository;
	@Mock
	UserRepository userRepository;
	@Mock
	ParticipantUtil participantUtil;
	@Mock
	GroupRepository groupRepository;
	@Test
	public void testSaveParticipant() {

		Group group = new Group();
		Optional<Group> userObj = Optional.of(group);

		SaveParticipantRequest request = new SaveParticipantRequest();
		request.setGroupId(2);
		request.setParticipantId(3);

		Participant participant = new Participant();
		participant.setId(1);

		// mock

		when(groupRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(participantUtil.loadSaveParticipantRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(participant);

		when(participantRepository.save(Mockito.any())).thenReturn(participant);

		SaveParticipantResponse response = participantServiceImpl.saveParticipant(request);

		assertEquals("000", response.statusCode);

	}
	
	@Test
	public void testSaveParticipantFailure() {

		Group group = new Group();
		Optional<Group> userObj = Optional.of(group);

		SaveParticipantRequest request = new SaveParticipantRequest();
		//request.setGroupId(2);
		//request.setParticipantId(3);

		Participant participant = new Participant();
		//participant.setId(1);

		// mock

		when(groupRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(participantUtil.loadSaveParticipantRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(participant);

		when(participantRepository.save(Mockito.any())).thenReturn(participant);

		SaveParticipantResponse response = participantServiceImpl.saveParticipant(request);

		assertEquals("001", response.statusCode);

	}
	@Test
	public void testParticipantUserNotFound() {
 
		Optional<Group> userObj = Optional.empty();
		SaveParticipantRequest request = new SaveParticipantRequest();

		request.setGroupId(1);
		request.setParticipantId(22);

		// mock
		when(groupRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		SaveParticipantResponse response = participantServiceImpl.saveParticipant(request);

		assertEquals("901", response.statusCode);

	}	
	@Test
	public void testDeleteParticipant() {

		Participant participants = new Participant();
		Optional<Participant> participantObj = Optional.of(participants);

		DeleteParticipantRequest request = new DeleteParticipantRequest();
		request.setGroupId(1);

		Participant participant = new Participant();
		participant.setId(5);

		// mock

		when(participantRepository.findByGroupIdAndParticipantId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(participantObj);		
		DeleteParticipantResponse response = participantServiceImpl.deleteParticipant(request);

		assertEquals("000", response.statusCode);

	}
     
	@Test
	public void testDeleteParticipantNotFound() {

		Optional<Participant> participantObj = Optional.empty();
		DeleteParticipantRequest request = new DeleteParticipantRequest();

		request.setGroupId(2);

		// mock
		when(participantRepository.findByGroupIdAndParticipantId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(participantObj);		
		DeleteParticipantResponse response = participantServiceImpl.deleteParticipant(request);

		assertEquals("902", response.statusCode);

	}




}