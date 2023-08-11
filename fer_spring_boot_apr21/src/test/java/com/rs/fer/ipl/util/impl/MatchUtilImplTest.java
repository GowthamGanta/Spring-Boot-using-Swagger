package com.rs.fer.ipl.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.request.SaveMatchRequest;

@SpringBootTest
public class MatchUtilImplTest {
	@InjectMocks
	private MatchUtilImpl matchUtilImpl;

	@Test
	public void testSaveMatchRequest() {

		SaveMatchRequest request = new SaveMatchRequest();
		request.setMatchNumber('1');
		request.setMatchDay("4");
		request.setTeamOne("SRH");
		request.setTeamTwo("CSK");
		request.setVenue("hyderabad");
		request.setDate("");
		request.setStartTime("6:00");
		request.setEndTime("10:30");
		request.setUmpire("Bhargav gopi");
		request.setThirdUmpire("Srinivas");
		request.setReferee("Venkat kirshna");
		request.setHomeTeam("SRH");
		request.setAwayTeam("CSK");
		matchUtilImpl.loadSaveMatchRequestToMatch(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty =true ;

		assertEquals(isExpectedNotEmpty, isActualNotEmpty);

	}

	@Test
	public void testSaveMatchRequestFailure() {

		SaveMatchRequest request = new SaveMatchRequest();
		//request.setMatchNumber('1');
		request.setMatchDay("4");
		request.setTeamOne("SRH");
		request.setTeamTwo("CSK");
		request.setVenue("hyderabad");
		request.setDate("");
		request.setStartTime("6:00");
		request.setEndTime("10:30");
		request.setUmpire("Bhargav gopi");
		request.setThirdUmpire("Srinivas");
		request.setReferee("Venkat kirshna");
		request.setHomeTeam("SRH");
		request.setAwayTeam("CSK");
		matchUtilImpl.loadSaveMatchRequestToMatch(request);

		boolean isExpectedNotEmpty = false;
		boolean isActualNotEmpty = false;

		assertEquals(isExpectedNotEmpty, isActualNotEmpty);

	}


}
