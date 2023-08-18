package com.rs.fer.ipl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.rs.fer.ipl.controller.MatchController;
import com.rs.fer.ipl.request.GetMatcheRequest;
import com.rs.fer.ipl.response.GetMatchResponse;
import com.rs.fer.ipl.service.MatchService;
import com.rs.fer.ipl.validation.MatchValidation;

@SpringBootTest
public class MatchControllerTest {

	@InjectMocks
	private MatchController matchController;

	@Mock
	MatchValidation matchValidation;

	@Mock
	MatchService matchService;

	@Test
	public void testGetMatch(Integer matchId) {

		Set<String> errorMessages = new LinkedHashSet<>();

		GetMatcheRequest request = new GetMatcheRequest();
		GetMatchResponse response = new GetMatchResponse(HttpStatus.OK, "000", "", null);

		when(matchValidation.validateGetMatchRequest(Mockito.anyInt())).thenReturn(errorMessages);
		when(matchService.getMatch(Mockito.anyInt())).thenReturn(response);

		GetMatchResponse getMatchResponse = ((MatchService) matchController).getMatch(matchId);

		assertEquals("000", getMatchResponse.statusCode);

	}
	
	@Test
	public void testGetMatchFailure(Integer matchId) {
		
		//Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Type");
		
		GetMatcheRequest request = new GetMatcheRequest();
		
		//When
		when(matchValidation.validateGetMatchRequest(Mockito.anyInt())).thenReturn(errorMessages);

		//Then
		GetMatchResponse getMatchResponse = ((MatchService) matchController).getMatch(matchId);

		assertEquals("999", getMatchResponse.statusCode);

	}

}
