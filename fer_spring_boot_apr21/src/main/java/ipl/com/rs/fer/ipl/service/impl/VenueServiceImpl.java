package com.rs.fer.ipl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.entity.Venue;
import com.rs.fer.ipl.repository.VenueRepository;
import com.rs.fer.ipl.request.SaveVenueRequest;
import com.rs.fer.ipl.response.GetPlayerResponse;
import com.rs.fer.ipl.response.GetVenuesResponse;
import com.rs.fer.ipl.response.SaveVenueResponse;
import com.rs.fer.ipl.service.VenueService;
import com.rs.fer.ipl.util.VenueUtil;

@Service
public class VenueServiceImpl implements VenueService {
	@Autowired
	VenueUtil venueUtil;
	@Autowired
	VenueRepository venueRepository;

	@Override
	public SaveVenueResponse saveVenue(SaveVenueRequest request) {

		SaveVenueResponse response = null;
		List<Venue> venues = venueRepository.findByStadiumName(request.getStadiumName());

		if (!CollectionUtils.isEmpty(venues)) {

			response = new SaveVenueResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"Venue is already find with the given StadiumName", null);
			return response;
		}

		// load vo to bean
		Venue venue = venueUtil.loadSaveVenueRequestToVenue(request);

		// save bean to database
		venue = venueRepository.save(venue);

		// load response
		if (venue.getVenueId() > 0) {
			// success
			response = new SaveVenueResponse(HttpStatus.OK, "000", "Venue is succesfully saved", null);
			response.setVenue(venue);
		} else {
			// failure
			response = new SaveVenueResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Venue saved is failed", null);
		}

		return response;
	}

	@Override
	public GetVenuesResponse getVenues() {
		
		GetVenuesResponse response = null;

		List<Venue> venueObj =venueRepository.findAll();

		if (!venueObj.isEmpty()) {

			response = new GetVenuesResponse(HttpStatus.OK, "000", "Fetched Venues  succesfully", null);
			response.setVenues(venueObj);

		} else {

			response = new GetVenuesResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Fetching is failed", null);

		}
		return response;
	}
	
}
