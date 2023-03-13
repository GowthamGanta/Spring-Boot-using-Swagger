package com.rs.fer.follow.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.follow.request.SaveFollowerRequest;

@SpringBootTest
public class FollowUtilImplTest {

	@InjectMocks
	private FollowUtilImpl followUtilImpl;

	@Test
	public void loadSaveFollowRequest() {

		SaveFollowerRequest request = new SaveFollowerRequest();
		request.setFollowerId(1);
		request.setUserId(2);

		Follow follow = followUtilImpl.loadSaveFollowerRequest(request, 1, 2);
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != follow.getFollowerId() && 0 != follow.getUserId());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void loadSaveFollowRequestFailure() {

		SaveFollowerRequest request = new SaveFollowerRequest();
		// request.setFollowerId(1);
		request.setUserId(2);

		Follow follow = followUtilImpl.loadSaveFollowerRequest(request, 1, 2);
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = (0 != follow.getFollowerId() && 0 != follow.getUserId());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
}