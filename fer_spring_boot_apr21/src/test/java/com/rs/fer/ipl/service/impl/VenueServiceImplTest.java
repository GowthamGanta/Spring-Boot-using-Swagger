package com.rs.fer.ipl.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.rs.fer.ipl.entity.Venue;
import com.rs.fer.ipl.repository.VenueRepository;
import com.rs.fer.ipl.response.GetVenuesResponse;
import com.rs.fer.ipl.util.VenueUtil;
@SpringBootTest
public class VenueServiceImplTest {
	
	@InjectMocks
	private VenueServiceImpl venueServiceImpl;

	@Mock
	VenueRepository venueRepository;

	@Mock
	VenueUtil venueUtil;

	// private Object teams;
	public void testGetVenue() {
		List<Venue> venue = new ArrayList<>();
        
        ((Venue) venue).setStadiumName("LBstadium");
        
        when(venueRepository.findByStadiumName(Mockito.anyString())).thenReturn(venue);
        
        String StadiumName="LBStadium";
        GetVenuesResponse response=venueServiceImpl.getVenues();
        
        Assert.notNull("000", response.statusCode);
        		   
	}
	@Test
	public void testGetVenueNotFound() {
		List<Venue> venue = new ArrayList<>();

		// Team teams = new Team();
		// Mock
		when(venueRepository.findByStadiumName(Mockito.anyString())).thenReturn(venue);

		// 2.
		String StadiumName = null;
		GetVenuesResponse response=venueServiceImpl.getVenues();
		

		// 3.
		assertEquals("002", response.statusCode);
	}
}
