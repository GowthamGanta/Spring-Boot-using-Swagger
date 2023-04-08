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

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.SaveTeamResponse;
import com.rs.fer.ipl.util.TeamUtil;

@SpringBootTest
public class TeamServiceImplTest {
	@InjectMocks
	private TeamServiceImpl teamServiceImpl;

	@Mock

	TeamRepository teamRepository;

	@Mock
	TeamUtil teamUtil;

	@Test
	public void testSaveTeam() {

		List<Team> team = new ArrayList<>();

		Team teams = new Team();
		
		teams.setTeamId(1);

		// Mock
		when(teamRepository.findByTeamId(Mockito.anyInt())).thenReturn(team);
		when(teamRepository.save(Mockito.any())).thenReturn(teams);

		when(teamUtil.loadSaveTeamRequestToTeam(Mockito.any())).thenReturn(teams);

		// 1.
		SaveTeamRequest request = new SaveTeamRequest();
		request.setName("CSK");

		// 2.
		SaveTeamResponse response = teamServiceImpl.saveTeam(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testSaveTeamDuplicate() {

		List<Team> team = new ArrayList<>();

		Team teams = new Team();
		teams.setTeamId(1);

		team.add(teams);

		// Mock
		when(teamRepository.findByTeamId(Mockito.anyInt())).thenReturn(team);

		when(teamRepository.save(Mockito.any())).thenReturn(teams);

		when(teamUtil.loadSaveTeamRequestToTeam(Mockito.any())).thenReturn(teams);

		// 1.
		SaveTeamRequest request = new SaveTeamRequest();
		request.setName("Dhoni");

		// 2.
		SaveTeamResponse response = teamServiceImpl.saveTeam(request);

		// 3.
		assertEquals("001", response.statusCode);
	}

	@Test
	public void testSaveTeamFailure() {

		List<Team> team = new ArrayList<>();

		Team teams = new Team();

		when(teamRepository.findByTeamId(Mockito.anyInt())).thenReturn(team);

		when(teamRepository.save(Mockito.any())).thenReturn(teams);

		when(teamUtil.loadSaveTeamRequestToTeam(Mockito.any())).thenReturn(teams);

		SaveTeamRequest request = new SaveTeamRequest();
		// request.setName("Dhoni");

		SaveTeamResponse response = teamServiceImpl.saveTeam(request);

		assertEquals("002", response.statusCode);
	}

}
