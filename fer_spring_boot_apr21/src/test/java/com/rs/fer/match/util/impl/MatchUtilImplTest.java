package com.rs.fer.match.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.request.GetMatcheRequest;
import com.rs.fer.ipl.util.impl.MatchUtilImpl;

@SpringBootTest
public class MatchUtilImplTest {
	
	@InjectMocks
	private MatchUtilImpl matchUtilImpl;
	
	@Test
	public void testUtilGetMatch() {

		GetMatcheRequest request = new GetMatcheRequest();

		request.getMatchId();


		IPLMatch errorMessage = matchUtilImpl.getMatchById(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != errorMessage.getMatchId());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	
	/*
	 * @Test public void testUtilGetMatchFailure() {
	 * 
	 * GetMatcheRequest request = new GetMatcheRequest();
	 * 
	 * request.getMatchId();
	 * 
	 * IPLMatch iPLMatch = matchUtilImpl.getMatchById(request); boolean
	 * isExpectedEmpty = false; boolean isActualEmpty = (null
	 * !=iPLMatch.getMatchId() && 0 != iPLMatch.getMatchNumber());
	 * 
	 * assertEquals(isExpectedEmpty, isActualEmpty);
	 * 
	 * }
	 */
}
