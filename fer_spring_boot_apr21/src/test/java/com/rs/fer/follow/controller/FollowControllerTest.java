package com.rs.fer.follow.controller;

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

import com.rs.fer.follow.request.DeletefollowerRequest;
import com.rs.fer.follow.request.GetFollowersRequest;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.response.DeletefollowerResponse;
import com.rs.fer.follow.response.GetFollowersResponse;
import com.rs.fer.follow.response.SaveFollowerResponse;
import com.rs.fer.follow.service.FollowerService;
import com.rs.fer.follow.validation.FollowValidation;
import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.response.DeleteMessageResponse;

@SpringBootTest
public class FollowControllerTest {

	@InjectMocks
	private FollowController followController;

	@Mock
	FollowValidation followValidation;

	@Mock
	FollowerService followService;

	@Test
	public void testSaveFollow() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		SaveFollowerRequest request = new SaveFollowerRequest();
		SaveFollowerResponse response = new SaveFollowerResponse(HttpStatus.OK, "000", "", null);

		// when
		when(followValidation.validateSaveFollowerRequest(Mockito.any())).thenReturn(errorMessages);
		when(followService.saveFollower(Mockito.any())).thenReturn(response);

		// Then
		SaveFollowerResponse saveResponse = followController.saveFollower(request);

		assertEquals("000", saveResponse.statusCode);

	}

	@Test
	public void testSaveFollowFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please entre userId");

		SaveFollowerRequest request = new SaveFollowerRequest();

		// when
		when(followValidation.validateSaveFollowerRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		SaveFollowerResponse response = followController.saveFollower(request);

		assertEquals("999", response.statusCode);

	}

	@Test
	public void testDeleteFollow() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		DeletefollowerRequest request = new DeletefollowerRequest();
		DeletefollowerResponse response = new DeletefollowerResponse(HttpStatus.OK, "000", "", null);

		// when
		when(followValidation.validateDeleteFollowerRequest(Mockito.any())).thenReturn(errorMessages);
		when(followService.deleteFollower(Mockito.any())).thenReturn(response);

		// when(followValidation.validateDeleteMessageRequest(Mockito.any())).thenReturn(errorMessages);
		// when(followController.deleteFollower(Mockito.any())).thenReturn(response);

		// Then
		DeletefollowerResponse Response = followController.deleteFollower(request);

		assertEquals("000", Response.statusCode);

	}

	@Test
	public void testDeleteFollowFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please entre id");

		DeletefollowerRequest request = new DeletefollowerRequest();

		// when
		when(followValidation.validateDeleteFollowerRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		DeletefollowerResponse response = followController.deleteFollower(request);

		assertEquals("999", response.statusCode);

	}
	
	@Test
	public void testGetFollowers() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		GetFollowersRequest request = new GetFollowersRequest();
		GetFollowersResponse response = new GetFollowersResponse(HttpStatus.OK, "000", "", null);

		// when
		when(followValidation.validateGetFollowersRequest(Mockito.any())).thenReturn(errorMessages);
		when(followService.getFollowers(Mockito.any())).thenReturn(response);

		// when(followValidation.validateDeleteMessageRequest(Mockito.any())).thenReturn(errorMessages);
		// when(followController.deleteFollower(Mockito.any())).thenReturn(response);

		// Then
		GetFollowersResponse Response = followController.getFollowers(request);

		assertEquals("000", Response.statusCode);

	}
	@Test
	public void testGetFollowersFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please entre id");
		GetFollowersRequest request = new GetFollowersRequest();

		// when
		when(followValidation.validateGetFollowersRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		GetFollowersResponse response = followController.getFollowers(request);

		assertEquals("999", response.statusCode);

	}
}
	