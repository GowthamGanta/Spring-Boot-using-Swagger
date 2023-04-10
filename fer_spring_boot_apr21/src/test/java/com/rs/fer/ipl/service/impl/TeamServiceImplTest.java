package com.rs.fer.ipl.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.GetTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.GetTeamResponse;
import com.rs.fer.ipl.response.SaveTeamResponse;
import com.rs.fer.ipl.util.TeamUtil;
import com.rs.fer.loan.entity.LoanAccount;
import com.rs.fer.loan.response.GetLoanAccountResponse;

@SpringBootTest
public class TeamServiceImplTest {
	@InjectMocks
	private TeamServiceImpl teamServiceImpl;

	@Mock
	TeamRepository teamRepository;

	@Mock
	TeamUtil teamUtil;

	// private Object teams;

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

	@Test
	public void testTeamResponse() {
		Team team = new Team();
		team.setTeamId(1);
		Optional<Team> teams = Optional.of(team);

		when(teamRepository.findById(Mockito.anyInt())).thenReturn(teams);

		int teamId = 1;

		GetTeamResponse response = teamServiceImpl.getTeam(teamId);

		// 3.

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetTeamNotFound() {

		Optional<Team> teams = Optional.empty();
		// Team teams = new Team();
		// Mock
		when(teamRepository.findById(Mockito.anyInt())).thenReturn(teams);

		// 1.
		GetTeamRequest request = new GetTeamRequest();

		// 2.
		int teamId = 0;
		GetTeamResponse response = teamServiceImpl.getTeam(teamId);

		// 3.
		assertEquals("002", response.statusCode);
	}

}
