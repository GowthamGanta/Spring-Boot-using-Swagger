package com.rs.fer.ipl.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.request.SaveVenueRequest;
import com.rs.fer.ipl.validation.MatchValidation;
import com.rs.fer.ipl.validation.VenueValidation;
import com.rs.fer.util.FERUtil;
@Component
public class VenueValidationImpl implements VenueValidation {

	@Override
	public Set<String> validateSaveVenueRequest(SaveVenueRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getStadiumName(), "Please enter StadiumName");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getCity(), "Please enter City");
		return errorMessages;
	}

}
