package com.rs.fer.ipl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.Venue;
import com.rs.fer.ipl.repository.VenueRepository;
import com.rs.fer.ipl.request.SaveVenueRequest;
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

}
