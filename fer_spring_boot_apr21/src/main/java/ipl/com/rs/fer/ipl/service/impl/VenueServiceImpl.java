package com.rs.fer.ipl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.entity.Venue;
import com.rs.fer.ipl.repository.MatchRepository;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.repository.VenueRepository;
import com.rs.fer.ipl.request.SaveMatchRequest;
import com.rs.fer.ipl.request.SaveVenueRequest;
import com.rs.fer.ipl.response.SaveMatchResponse;
import com.rs.fer.ipl.response.SaveTeamResponse;
import com.rs.fer.ipl.response.SaveVenueResponse;
import com.rs.fer.ipl.service.MatchService;
import com.rs.fer.ipl.service.VenueService;
import com.rs.fer.ipl.util.MatchUtil;
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
	List<Venue> venue=venueRepository.findByStadiumName(request.getStadiumName());
		




		response = new SaveVenueResponse(HttpStatus.OK, "000", "Venue is succesfully saved", null);
	
	
	return response;

}
}