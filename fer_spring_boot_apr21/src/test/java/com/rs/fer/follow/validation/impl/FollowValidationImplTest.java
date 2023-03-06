package com.rs.fer.follow.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.validation.Impl.FollowValidationImpl;

@SpringBootTest
public class FollowValidationImplTest {

	@InjectMocks
	public FollowValidationImpl followValidationImpl;
	@Test
	public void testValidateSaveFollowRequest() {
	
		SaveFollowerRequest request = new SaveFollowerRequest();
		
		request.setFollowerId(3);
		request.setUserId(4);
		
		Set<String> follow = followValidationImpl.validateSaveFollowerRequest(request);
		
		boolean isExpectedEmpty = true;

		boolean isActualEmpty = follow.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	@Test
	public void testValidateSaveFollowRequestFailure() {
		
		SaveFollowerRequest request = new SaveFollowerRequest();
		
	//	request.setFollowerId(3);
		request.setUserId(4);
		
		Set<String> follow = followValidationImpl.validateSaveFollowerRequest(request);
		
		boolean isExpectedEmpty = false;

		boolean isActualEmpty = follow.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

}
