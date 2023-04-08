package com.rs.fer.ipl.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.request.SaveTeamRequest;

@SpringBootTest
public class TeamUtilImplTest {

	@InjectMocks
	private TeamUtilImpl teamUtilImpl;

	@Test
	public void testSaveTeamRequest() {

		SaveTeamRequest request = new SaveTeamRequest();
		request.setName("CSK");

		Team team = teamUtilImpl.loadSaveTeamRequestToTeam(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (null != team.getName());

		assertEquals(isExpectedNotEmpty, isActualNotEmpty);

	}

	@Test
	public void testSaveTeamRequestFailure() {

		SaveTeamRequest request = new SaveTeamRequest();
		// request.setName("abc");

		Team team = teamUtilImpl.loadSaveTeamRequestToTeam(request);

		boolean isExpectedNotEmpty = false;
		boolean isActualNotEmpty = (null != team.getName());

		assertEquals(isExpectedNotEmpty, isActualNotEmpty);

	}

}
