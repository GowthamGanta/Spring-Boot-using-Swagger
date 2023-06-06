package com.rs.fer.ipl.service;

import com.rs.fer.ipl.request.SaveVenueRequest;
import com.rs.fer.ipl.response.SaveVenueResponse;

public interface VenueService {

	SaveVenueResponse saveVenue(SaveVenueRequest request);

}