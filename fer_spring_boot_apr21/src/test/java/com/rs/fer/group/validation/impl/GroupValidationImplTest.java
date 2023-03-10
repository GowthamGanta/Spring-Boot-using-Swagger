package com.rs.fer.group.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.follow.request.DeletefollowerRequest;
import com.rs.fer.follow.request.GetFollowersRequest;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.validation.Impl.FollowValidationImpl;
import com.rs.fer.group.request.SaveGroupRequest;
import com.rs.fer.group.validation.Impl.GroupValidationImpl;

@SpringBootTest
public class GroupValidationImplTest {

	@InjectMocks
	public GroupValidationImpl groupValidationImpl;

	@Test
	public void testValidateSaveGroupRequest() {

		SaveGroupRequest request = new SaveGroupRequest();
        request.setGroupName("abc");
		request.setUserId(1);

		Set<String> follow = groupValidationImpl.validateSaveGroupRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = follow.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateSaveGroupRequestFailure() {

		SaveGroupRequest request = new SaveGroupRequest();

		
		//request.setUserId(4);

		Set<String> follow = groupValidationImpl.validateSaveGroupRequest(request);

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = follow.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}


	
}
