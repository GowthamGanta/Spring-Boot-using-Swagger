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
import com.rs.fer.ipl.request.SaveVenueRequest;
import com.rs.fer.ipl.response.SaveMatchResponse;
import com.rs.fer.ipl.response.SaveVenueResponse;
import com.rs.fer.ipl.service.MatchService;
import com.rs.fer.ipl.service.VenueService;
import com.rs.fer.ipl.validation.MatchValidation;
import com.rs.fer.ipl.validation.VenueValidation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VenueController {
	@Autowired
	VenueValidation venueValidation;

	@Autowired
	VenueService venueService;

	@PostMapping("/ipl/saveVenue")
	public SaveVenueResponse saveVenue(@RequestBody SaveVenueRequest request) {

		SaveVenueResponse response = null;

		Set<String> errorMessages = venueValidation.validateSaveVenueRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveVenueResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = venueService.saveVenue(request);
		}

		return response;
	}

}
