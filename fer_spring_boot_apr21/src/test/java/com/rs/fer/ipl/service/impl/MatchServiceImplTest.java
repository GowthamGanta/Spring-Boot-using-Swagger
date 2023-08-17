package com.rs.fer.ipl.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.repository.MatchRepository;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.response.GetMatchResponse;
import com.rs.fer.ipl.util.MatchUtil;

@SpringBootTest
public class MatchServiceImplTest {
	@InjectMocks
	private MatchServiceImpl matchServiceImpl;

	@Mock
	MatchRepository matchRepository;
	@Mock
	TeamRepository teamRepository;

	@Mock
	MatchUtil matchUtil;

	@Test
	public void testGetMatchResponse() {

		IPLMatch iplMatch = new IPLMatch();
		Optional<IPLMatch> matchObj = Optional.of(iplMatch);

		// To get the Applicant based on userId
		when(matchRepository.findById(Mockito.anyInt())).thenReturn(matchObj);
		int matchId = 1;

		GetMatchResponse response = matchServiceImpl.getMatch(matchId);
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetMatchNotFound() {
		Optional<IPLMatch> matches = Optional.empty();
		when(matchRepository.findById(Mockito.anyInt())).thenReturn(matches);
		int matchId = 0;
		GetMatchResponse response = matchServiceImpl.getMatch(matchId);
		assertEquals("002", response.statusCode);

	}

}
