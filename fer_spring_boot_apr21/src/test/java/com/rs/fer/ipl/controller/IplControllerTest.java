package com.rs.fer.ipl.controller;

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

import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.service.PlayerService;
import com.rs.fer.ipl.validation.PlayerValidation;

@SpringBootTest
public class IplControllerTest {

	@InjectMocks
	private IplController iplController;

	@Mock
	PlayerValidation playerValidation;

	@Mock
	PlayerService playerService;

	@Test
	public void testSavePlayer() {

		Set<String> errorMessages = new LinkedHashSet<>();

		SavePlayerRequest request = new SavePlayerRequest();
		SavePlayerResponse response = new SavePlayerResponse(HttpStatus.OK, "000", "", null);

		when(playerValidation.validateSavePlayerRequest(Mockito.any())).thenReturn(errorMessages);
		when(playerService.savePlayer(Mockito.any())).thenReturn(response);

		SavePlayerResponse savePlayerResponse = iplController.savePlayer(request);

		assertEquals("000", savePlayerResponse.statusCode);

	}

	@Test
	public void testSavePlayerFailure() {

		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Id");

		SavePlayerRequest request = new SavePlayerRequest();

		// When
		when(playerValidation.validateSavePlayerRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		SavePlayerResponse response = iplController.savePlayer(request);

		assertEquals("999", response.statusCode);
	}
}
