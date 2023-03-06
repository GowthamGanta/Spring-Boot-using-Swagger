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

import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.response.SaveFollowerResponse;
import com.rs.fer.follow.service.FollowerService;
import com.rs.fer.follow.validation.FollowValidation;
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

}
