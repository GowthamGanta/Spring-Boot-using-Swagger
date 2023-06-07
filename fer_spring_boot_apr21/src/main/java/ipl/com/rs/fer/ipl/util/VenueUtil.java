package com.rs.fer.ipl.util;

import com.rs.fer.ipl.entity.Venue;
import com.rs.fer.ipl.request.SaveVenueRequest;

public interface VenueUtil {
	Venue loadSaveVenueRequestToVenue(SaveVenueRequest request);

}
