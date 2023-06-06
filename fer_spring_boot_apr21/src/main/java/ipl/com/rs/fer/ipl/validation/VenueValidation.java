package com.rs.fer.ipl.validation;

import java.util.Set;

import com.rs.fer.ipl.request.SaveVenueRequest;

public interface VenueValidation {
  
	
	Set<String> validateSaveVenueRequest(SaveVenueRequest request);

}
