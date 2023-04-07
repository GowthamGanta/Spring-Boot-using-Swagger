package com.rs.fer.ipl.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.service.PlayerService;
import com.rs.fer.ipl.validation.PlayerValidation;

@RestController
@RequestMapping("/api")
public class IplController {

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
}
