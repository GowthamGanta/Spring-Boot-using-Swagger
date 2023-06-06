package com.rs.fer.ipl.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.ipl.entity.Venue;
import com.rs.fer.ipl.request.SaveVenueRequest;
import com.rs.fer.ipl.util.VenueUtil;

@Component


public class VenueUtilImpl implements VenueUtil {


	public Venue loadSaveVenueRequestToVenue(SaveVenueRequest request) {
		
		Venue venue = new Venue();

		venue.setStadiumName(request.getStadiumName());
		venue.setCity(request.getCity());

		return venue;
	}

}
