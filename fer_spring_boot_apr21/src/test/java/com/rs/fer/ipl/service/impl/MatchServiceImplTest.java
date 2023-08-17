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

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.repository.MatchRepository;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.EditMatchRequest;
import com.rs.fer.ipl.request.EditTeamRequest;
import com.rs.fer.ipl.response.EditMatchResponse;
import com.rs.fer.ipl.response.EditTeamResponse;
import com.rs.fer.ipl.util.MatchUtil;

@SpringBootTest
public class MatchServiceImplTest {
	@InjectMocks
	private MatchServiceImpl matchServiceImpl;
	@Mock
	MatchRepository matchRepository;
	@Mock
	MatchUtil matchUtil;
	@Mock
	TeamRepository teamRepository;

	@Test
	public void testEditMatchNumber() {

		List<IPLMatch> matchObj = new ArrayList<>();

		IPLMatch match = new IPLMatch();
		match.setMatchNumber(1);
		// Mock
		when(matchRepository.findByMatchNumber(Mockito.anyInt())).thenReturn(matchObj);
		when(matchRepository.save(Mockito.any())).thenReturn(match);
		when(matchUtil.loadEditMatchRequestToMatch(Mockito.any())).thenReturn(match);

		EditMatchRequest request = new EditMatchRequest();
		// 2.
		EditMatchResponse response = matchServiceImpl.editMatch(request);

		// 3.
		assertEquals("000", response.statusCode);

	}
	
	@Test
	public void testEditMatchNumberFailure() {

		List<IPLMatch> matchObj = new ArrayList<>();

		IPLMatch match = new IPLMatch();
		match.setMatchNumber(1);
		// Mock
		when(matchRepository.findByMatchNumber(Mockito.anyInt())).thenReturn(matchObj);

		EditMatchRequest request = new EditMatchRequest();
		// 2.
		EditMatchResponse response = matchServiceImpl.editMatch(request);

		// 3.
		assertEquals("002", response.statusCode);

	}
	
	@Test
	public void testEditMatchId() {

		List<IPLMatch> matchObj = new ArrayList<>();

		IPLMatch match = new IPLMatch();
		match.setMatchId(1);
		// Mock
		when(matchRepository.findByMatchId(Mockito.anyInt())).thenReturn(matchObj);
		when(matchRepository.save(Mockito.any())).thenReturn(match);
		when(matchUtil.loadEditMatchRequestToMatch(Mockito.any())).thenReturn(match);

		EditMatchRequest request = new EditMatchRequest();
		// 2.
		EditMatchResponse response = matchServiceImpl.editMatch(request);

		// 3.
		assertEquals("000", response.statusCode);

	}
	
	@Test
	public void testEditMatchIdFailure() {

		List<IPLMatch> matchObj = new ArrayList<>();

		IPLMatch match = new IPLMatch();
		match.setMatchId(1);
		// Mock
		when(matchRepository.findByMatchId(Mockito.anyInt())).thenReturn(matchObj);

		EditMatchRequest request = new EditMatchRequest();
		// 2.
		EditMatchResponse response = matchServiceImpl.editMatch(request);

		// 3.
		assertEquals("002", response.statusCode);

	}


}
