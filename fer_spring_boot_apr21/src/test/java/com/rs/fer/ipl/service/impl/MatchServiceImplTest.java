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
import com.rs.fer.ipl.request.GetMatcheRequest;
import com.rs.fer.ipl.response.GetMatchResponse;
import com.rs.fer.ipl.service.impl.MatchServiceImpl;
import com.rs.fer.ipl.util.MatchUtil;

@SpringBootTest
public class MatchServiceImplTest {

	@InjectMocks
	private MatchServiceImpl matchServiceImpl;

	@Mock
	MatchUtil matchUtil;

	@Mock
	MatchRepository matchRepository;

	@Mock
	TeamRepository teamRepository;

	@Test
	public void testGetMatch(Integer matchId) {

		IPLMatch match = new IPLMatch();
		match.setMatchId(1);

		Optional<IPLMatch> iPLMatchObj = Optional.empty();

		// Mock
		when(matchRepository.findById(Mockito.anyInt())).thenReturn(iPLMatchObj);

		// 1.
		GetMatcheRequest request = new GetMatcheRequest();

		// 2.
		GetMatchResponse response = matchServiceImpl.getMatch(matchId);
				

		// 3.
		assertEquals("000", response.statusCode);
	}
	@Test
	public void testGetMatchNotFound(Integer matchId) {
		
		Optional<IPLMatch> iPLMatchObj = Optional.empty();
		
		//Mock
		when(matchRepository.findById(Mockito.anyInt())).thenReturn(iPLMatchObj);
		
		//1.
		GetMatcheRequest request = new GetMatcheRequest();
		
		//2.
		GetMatchResponse response =matchServiceImpl.getMatch(matchId);
		
		//3.
		assertEquals("002", response.statusCode);
		
	}
}
