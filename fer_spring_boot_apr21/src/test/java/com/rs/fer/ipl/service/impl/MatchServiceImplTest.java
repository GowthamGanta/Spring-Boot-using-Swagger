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
import org.springframework.util.Assert;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.repository.MatchRepository;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.EditMatchRequest;
import com.rs.fer.ipl.response.EditMatchResponse;
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

	@Mock
	EditMatchRequest request;

	@Mock
	EditMatchResponse response;

	@Test
	public void testEditMatchNumber() {

		IPLMatch match = new IPLMatch();
		match.setMatchNumber(1);
		List<IPLMatch> matchObj = new ArrayList<>();
		// Mock
		when(matchRepository.findByMatchNumber(Mockito.anyInt())).thenReturn(matchObj);
		when(matchRepository.save(Mockito.any())).thenReturn(match);
		when(matchUtil.loadEditMatchRequestToMatch(Mockito.any())).thenReturn(match);
		EditMatchRequest request = new EditMatchRequest();

		EditMatchResponse response = matchServiceImpl.editMatch(request);

		// 3.
		Assert.notNull("000", response.statusCode);

	}

	@Test
	public void testEditMatchNumberFailure() {

		IPLMatch match = new IPLMatch();
		match.setMatchNumber(1);
		List<IPLMatch> matchObj = new ArrayList<>();
		// Mock
		when(matchRepository.findByMatchNumber(Mockito.anyInt())).thenReturn(matchObj);

		EditMatchRequest request = new EditMatchRequest();

		EditMatchResponse response = matchServiceImpl.editMatch(request);

		// 3.
		assertEquals("002", response.statusCode);

	}

	@Test
	public void testEditMatchId() {

		IPLMatch match = new IPLMatch();
		match.setMatchId(1);
		List<IPLMatch> matchObj = new ArrayList<>();
		// Mock
		when(matchRepository.findByMatchId(Mockito.anyInt())).thenReturn(matchObj);
		when(matchRepository.save(Mockito.any())).thenReturn(match);
		when(matchUtil.loadEditMatchRequestToMatch(Mockito.any())).thenReturn(match);

		EditMatchRequest request = new EditMatchRequest();
		// 2.
		EditMatchResponse response = matchServiceImpl.editMatch(request);

		// 3.
		Assert.notNull("000", response.statusCode);

	}

	@Test
	public void testEditMatchIdFailure() {

		IPLMatch match = new IPLMatch();
		match.setMatchId(1);
		List<IPLMatch> matchObj = new ArrayList<>();
		// Mock
		when(matchRepository.findByMatchId(Mockito.anyInt())).thenReturn(matchObj);

		EditMatchRequest request = new EditMatchRequest();
		EditMatchResponse response = matchServiceImpl.editMatch(request);

		assertEquals("002", response.statusCode);

	}
}
