package com.rs.fer.ipl.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;
import com.rs.fer.ipl.response.DeletePlayerResponse;
import com.rs.fer.ipl.response.GetPlayerResponse;
import com.rs.fer.ipl.response.GetPlayersResponse;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.response.UpdatePlayerResponse;
import com.rs.fer.ipl.service.PlayerService;
import com.rs.fer.ipl.validation.PlayerValidation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PlayerController {

	@Autowired
	PlayerValidation playerValidation;

	@Autowired
	PlayerService playerService;

	@PostMapping("/ipl/savePlayer")
	public SavePlayerResponse savePlayer(@RequestBody SavePlayerRequest request) {

		SavePlayerResponse response = null;

		Set<String> errorMessages = playerValidation.validateSavePlayerRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SavePlayerResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = playerService.savePlayer(request);
		}

		return response;
	}

	@DeleteMapping("/ipl/player/{id}")
	public DeletePlayerResponse deletePlayer(@PathVariable("id") int playerId) {

		DeletePlayerResponse response = null;
		Set<String> errorMessages = playerValidation.validateDeletePlayerRequest(playerId);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new DeletePlayerResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = playerService.deletePlayer(playerId);
		}
		return response;

	}

	@GetMapping("/ipl/getPlayers/{teamId}")

	public GetPlayersResponse getPlayers(@PathVariable("teamId") Integer teamId) {
		GetPlayersResponse response = null;

		Set<String> errorMessages = playerValidation.validateGetPlayersRequest(teamId);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetPlayersResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = playerService.getPlayers(teamId);
		}
		return response;
	}

	@GetMapping("/ipl/getPlayer/{playerId}")

	public GetPlayerResponse getPlayer(@PathVariable("playerId") Integer playerId) {
		GetPlayerResponse response = null;

		Set<String> errorMessages = playerValidation.validateGetPlayerRequest(playerId);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetPlayerResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = playerService.getPlayer(playerId);
		}
		return response;
	}
	
	@PutMapping("/ipl/updatePlayer/{id}")
	public UpdatePlayerResponse updatePlayer(@RequestBody UpdatePlayerRequest request) {

		UpdatePlayerResponse response = null;

		Set<String> errorMessages = playerValidation.validateUpdatePlayerRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UpdatePlayerResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = playerService.updatePlayer(request);
		}
		return response;
	}

}


