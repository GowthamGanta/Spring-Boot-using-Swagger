package com.rs.fer.group.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.rs.fer.group.request.DeleteGroupRequest;
import com.rs.fer.group.request.GetGroupRequest;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.response.DeleteGroupResponse;
import com.rs.fer.group.response.GetGroupResponse;
import com.rs.fer.group.response.SaveGroupResponse;
import com.rs.fer.group.service.GroupService;
import com.rs.fer.group.validation.GroupValidation;

@SpringBootTest
public class GroupControllerTest {

	@InjectMocks
	private GroupController groupController;

	@Mock
	GroupValidation groupValidation;

	@Mock
	GroupService groupService;

	@Test
	public void testSaveGroup() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		SaveGroupRequest request = new SaveGroupRequest();
		SaveGroupResponse response = new SaveGroupResponse(HttpStatus.OK, "000", "", null);

		// when
		when(groupValidation.validateSaveGroupRequest(Mockito.any())).thenReturn(errorMessages);
		when(groupService.saveGroup(Mockito.any())).thenReturn(response);

		// Then
		SaveGroupResponse saveResponse = groupController.saveGroup(request);

		assertEquals("000", saveResponse.statusCode);

	}

	@Test
	public void testSaveGroupFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter userId");

		SaveGroupRequest request = new SaveGroupRequest();

		// when
		when(groupValidation.validateSaveGroupRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		SaveGroupResponse response = groupController.saveGroup(request);

		assertEquals("999", response.statusCode);

	}

	@Test
	public void testDeleteGroup() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		DeleteGroupRequest request = new DeleteGroupRequest();
		DeleteGroupResponse response = new DeleteGroupResponse(HttpStatus.OK, "000", "", null);

		// when
		when(groupValidation.validateDeleteGroupRequest(Mockito.any())).thenReturn(errorMessages);
		when(groupService.deleteGroup(Mockito.any())).thenReturn(response);

		// Then
		DeleteGroupResponse Response = groupController.deleteGroup(request);

		assertEquals("000", Response.statusCode);

	}

	@Test
	public void testDeleteGroupFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter id");

		DeleteGroupRequest request = new DeleteGroupRequest();

		// when
		when(groupValidation.validateDeleteGroupRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		DeleteGroupResponse response = groupController.deleteGroup(request);

		assertEquals("999", response.statusCode);

	}

	@Test
	public void testGetGroup() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		GetGroupRequest request = new GetGroupRequest();
		GetGroupResponse response = new GetGroupResponse(HttpStatus.OK, "000", "", null);

		// when
		when(groupValidation.validateGetGroupRequest(Mockito.any())).thenReturn(errorMessages);
		when(groupService.getGroup(Mockito.any())).thenReturn(response);

		// Then
		GetGroupResponse Response = groupController.getGroup(request);

		assertEquals("000", Response.statusCode);

	}

	@Test
	public void testGetGroupFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please entre id");
		GetGroupRequest request = new GetGroupRequest();

		// when
		when(groupValidation.validateGetGroupRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		GetGroupResponse response = groupController.getGroup(request);

		assertEquals("999", response.statusCode);

	}

}