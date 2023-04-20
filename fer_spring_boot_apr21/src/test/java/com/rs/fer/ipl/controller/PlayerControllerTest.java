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

import com.rs.fer.ipl.request.DeletePlayerRequest;
import com.rs.fer.ipl.request.GetPlayerRequest;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;
import com.rs.fer.ipl.response.DeletePlayerResponse;
import com.rs.fer.ipl.response.GetPlayerResponse;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.response.UpdatePlayerResponse;
import com.rs.fer.ipl.service.PlayerService;
import com.rs.fer.ipl.validation.PlayerValidation;

@SpringBootTest
public class PlayerControllerTest {

	@InjectMocks
	private PlayerController playerController;

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

		SavePlayerResponse savePlayerResponse = playerController.savePlayer(request);

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
		SavePlayerResponse response = playerController.savePlayer(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testDeletePlayer() {
		int playerId = 0;
		Set<String> errorMessages = new LinkedHashSet<>();
		new DeletePlayerRequest();
		DeletePlayerResponse response = new DeletePlayerResponse(HttpStatus.OK, "000", "", null);

		when(playerValidation.validateDeletePlayerRequest(Mockito.anyInt())).thenReturn(errorMessages);
		when(playerService.deletePlayer(Mockito.anyInt())).thenReturn(response);

		DeletePlayerResponse deletePlayerResponse = playerController.deletePlayer(playerId);

		assertEquals("000", deletePlayerResponse.statusCode);

	}

	@Test
	public void testDeletePlayerFailure() {
		int playerId = 0;
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("please enter Id");

		new DeletePlayerRequest();

		when(playerValidation.validateDeletePlayerRequest(Mockito.anyInt())).thenReturn(errorMessages);
		// when(playerService.deletePlayer(Mockito.anyInt())).thenReturn(response);

		DeletePlayerResponse deletePlayerResponse = playerController.deletePlayer(playerId);

		assertEquals("999", deletePlayerResponse.statusCode);

	}

	@Test
	public void testGetPlayerId() {

		Set<String> errorMessages = new LinkedHashSet<>();

		new GetPlayerRequest();
		GetPlayerResponse response = new GetPlayerResponse(HttpStatus.OK, "000", "", null);

		when(playerValidation.validateGetPlayerRequest(Mockito.any())).thenReturn(errorMessages);
		when(playerService.getPlayer(Mockito.any())).thenReturn(response);
		Integer playerId = 1;
		GetPlayerResponse getPlayerResponse = playerController.getPlayer(playerId);

		assertEquals("000", getPlayerResponse.statusCode);

	}

	@Test
	public void testGetPlayerFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter PlayerId");

		new GetPlayerRequest();

		// When
		when(playerValidation.validateGetPlayerRequest(Mockito.any())).thenReturn(errorMessages);

		Integer playerId = 0;
		GetPlayerResponse response = playerController.getPlayer(playerId);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testUpdatePlayer() {

		Set<String> errorMessages = new LinkedHashSet<>();

		UpdatePlayerRequest request = new UpdatePlayerRequest();
		UpdatePlayerResponse response = new UpdatePlayerResponse(HttpStatus.OK, "000", "", null);

		when(playerValidation.validateUpdatePlayerRequest(Mockito.any())).thenReturn(errorMessages);
		when(playerService.updatePlayer(Mockito.any())).thenReturn(response);

		UpdatePlayerResponse updatePlayerResponse = playerController.updatePlayer(request);

		assertEquals("000", updatePlayerResponse.statusCode);

	}

	@Test 
	public void testUpdatePlayerFailure() {

		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Id");

		UpdatePlayerRequest request = new UpdatePlayerRequest();

		// When
		when(playerValidation.validateUpdatePlayerRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		UpdatePlayerResponse response = playerController.updatePlayer(request);

		assertEquals("999", response.statusCode);
	}

}
