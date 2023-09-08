package com.rs.fer.ipl.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.request.GetMatcheRequest;

@SpringBootTest
public class MatchValidationImplTest {
	
	@InjectMocks
	private MatchValidationImpl matchValidationImpl;
	
	@Test
	public void testValidateGetMatchRequest(Integer matchId) {
		
		GetMatcheRequest request = new GetMatcheRequest();
		
		request.setMatchId(1);
		
		Set<String> errorMessages = matchValidationImpl.validateGetMatchRequest(matchId);
		
		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testValidateGetMatchRequestFailure(Integer matchId) {
		
		GetMatcheRequest request = new GetMatcheRequest();
		
		request.setMatchId(0);
		
		Set<String> errorMessages = matchValidationImpl.validateGetMatchRequest(matchId);
		
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);  
		
		}
	}
