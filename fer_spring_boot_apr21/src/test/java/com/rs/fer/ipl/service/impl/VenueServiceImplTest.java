package com.rs.fer.ipl.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.entity.Venue;
import com.rs.fer.ipl.repository.VenueRepository;
import com.rs.fer.ipl.request.SaveVenueRequest;
import com.rs.fer.ipl.response.SaveVenueResponse;
import com.rs.fer.ipl.util.VenueUtil;

@SpringBootTest
public class VenueServiceImplTest<StadiumName> {
	
	@InjectMocks
	private VenueServiceImpl venueServiceImpl;
	
	@Mock
	VenueRepository venueRepository;
	
	@Mock
	VenueUtil venueUtil;

	@Test
	public void testSaveVenue() {
		
		List<Venue> venues=new ArrayList<>();
		
		Venue venue=new Venue();
		
		venue.setVenueId(5);
		
		// when
		when(venueRepository.findByStadiumName(Mockito.anyString())).thenReturn(venues);
		
		when(venueRepository.save(Mockito.any())).thenReturn(venue);
		
		when(venueUtil.loadSaveVenueRequestToVenue(Mockito.any())).thenReturn(venue);
		
		//1.
		SaveVenueRequest saveVenueRequest=new SaveVenueRequest();
		
		saveVenueRequest.setStadiumName("LBStadium");

		// 2.
		SaveVenueResponse response=venueServiceImpl.saveVenue(saveVenueRequest);
		
		//3.
		assertEquals("000", response.statusCode);

	}
	

	@Test
	public void testSaveVenueDuplicateStadiumName() {
		
		List<Venue> venues=new ArrayList<>();
		
		Venue venue=new Venue();
		
		venue.setVenueId(5);
		
		// when
		when(venueRepository.findByStadiumName(Mockito.anyString())).thenReturn(venues);
		
		
		//1.
		SaveVenueRequest saveVenueRequest=new SaveVenueRequest();
		
		saveVenueRequest.setStadiumName("LBStadium");

		// 2.
		SaveVenueResponse response=venueServiceImpl.saveVenue(saveVenueRequest);
		
		//3.
		assertEquals("001", response.statusCode);

	}
	

	@Test
	public void testSaveVenueFailure() {
		
		List<Venue> venues=new ArrayList<>();
		
		Venue venue=new Venue();
		
		venue.setVenueId(5);
		
		// when
		when(venueRepository.findByStadiumName(Mockito.anyString())).thenReturn(venues);
		
		
		//1.
		SaveVenueRequest saveVenueRequest=new SaveVenueRequest();
		
		saveVenueRequest.setStadiumName("LBStadium");

		// 2.
		SaveVenueResponse response=venueServiceImpl.saveVenue(saveVenueRequest);
		
		//3.
		assertEquals("002", response.statusCode);

	}
	
	


}
