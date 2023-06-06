package com.rs.fer.ipl.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.response.SaveMatchResponse;
import com.rs.fer.ipl.service.MatchService;
import com.rs.fer.ipl.validation.MatchValidation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MatchController {
	@Autowired
	MatchValidation matchValidation;

	@Autowired
	MatchService matchService;

	@PostMapping("/ipl/saveMatch")
	public SaveMatchResponse saveMatch(@RequestBody SaveMatchRequest request) {

		SaveMatchResponse response = null;

		Set<String> errorMessages = matchValidation.validateSaveMatchRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveMatchResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = matchService.saveMatch(request);
		}

		return response;
	}

}
