package com.rs.fer.ipl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.rs.fer.ipl.request.GetTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.GetTeamResponse;
import com.rs.fer.ipl.response.SaveTeamResponse;
import com.rs.fer.ipl.service.TeamService;
import com.rs.fer.ipl.validation.TeamValidation;

@SpringBootTest
public class TeamControllerTest {

	@InjectMocks
	private TeamController teamController;

	@Mock
	TeamValidation teamValidation;

	@Mock
	TeamService teamService;

	@Test
	public void testSaveTeam() {

		Set<String> errorMessages = new LinkedHashSet<>();

		SaveTeamRequest request = new SaveTeamRequest();
		SaveTeamResponse response = new SaveTeamResponse(HttpStatus.OK, "000", "", null);

		when(teamValidation.validateSaveTeamRequest(Mockito.any())).thenReturn(errorMessages);
		when(teamService.saveTeam(Mockito.any())).thenReturn(response);

		SaveTeamResponse saveTeamResponse = teamController.saveTeam(request);

		assertEquals("000", saveTeamResponse.statusCode);

	}

	@Test
	public void testSaveTeamFailure() {

		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter teamId");

		SaveTeamRequest request = new SaveTeamRequest();

		// When
		when(teamValidation.validateSaveTeamRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		SaveTeamResponse response = teamController.saveTeam(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testgetTeam() {

		Set<String> errorMessages = new LinkedHashSet<>();

		GetTeamRequest request = new GetTeamRequest();
		GetTeamResponse response = new GetTeamResponse(HttpStatus.OK, "000", "", null);

		when(teamValidation.validateGetTeamRequest(Mockito.any())).thenReturn(errorMessages);
		when(teamService.getTeam(Mockito.any())).thenReturn(response);

		GetTeamResponse getTeamResponse = teamController.getTeam(request);

		assertEquals("000", getTeamResponse.statusCode);

	}

	@Test
	public void testGetTeamFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter TeamId");

		GetTeamRequest request = new GetTeamRequest();

		// When
		when(teamValidation.validateGetTeamRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		GetTeamResponse response = teamController.getTeam(request);

		assertEquals("999", response.statusCode);
	}

}
