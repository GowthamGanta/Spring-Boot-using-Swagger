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

import com.rs.fer.ipl.request.DeleteTeamRequest;
import com.rs.fer.ipl.request.EditTeamRequest;
import com.rs.fer.ipl.request.GetTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.DeleteTeamResponse;
import com.rs.fer.ipl.response.EditTeamResponse;
import com.rs.fer.ipl.response.GetTeamResponse;
import com.rs.fer.ipl.response.GetTeamsResponse;
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
	public void testGetTeamId() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		new GetTeamRequest();
		GetTeamResponse response = new GetTeamResponse(HttpStatus.OK, "000", "", null);

		when(teamValidation.validateGetTeamRequest(Mockito.anyInt())).thenReturn(errorMessages);
		when(teamService.getTeam(Mockito.anyInt())).thenReturn(response);
		Integer teamId = 1;
		GetTeamResponse Response = teamController.getTeam(teamId);

		assertEquals("000", Response.statusCode);

	}

	@Test
	public void testGetTeamIdFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		errorMessages.add("Please enter TeamId");

		// When
		when(teamValidation.validateGetTeamRequest(Mockito.anyInt())).thenReturn(errorMessages);

		// Then
		Integer teamId = 0;

		GetTeamResponse response = teamController.getTeam(teamId);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testDeleteTeam() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		DeleteTeamRequest request = new DeleteTeamRequest();
		DeleteTeamResponse response = new DeleteTeamResponse(HttpStatus.OK, "000", "", null);

		// when
		when(teamValidation.validateDeleteTeamRequest(Mockito.any())).thenReturn(errorMessages);
		when(teamService.deleteTeam(Mockito.any())).thenReturn(response);

		// Then
		DeleteTeamResponse Response = teamController.deleteTeam(request);

		assertEquals("000", Response.statusCode);

	}

	@Test
	public void testDeleteTeamFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter id");

		DeleteTeamRequest request = new DeleteTeamRequest();

		// when
		when(teamValidation.validateDeleteTeamRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		DeleteTeamResponse response = teamController.deleteTeam(request);

		assertEquals("999", response.statusCode);

	}

	@Test
	public void testEditTeam() {

		Set<String> errorMessages = new LinkedHashSet<String>();

		EditTeamRequest request = new EditTeamRequest();
		EditTeamResponse response = new EditTeamResponse(HttpStatus.OK, "000", "", null);

		when(teamValidation.validateEditTeamRequest(Mockito.any())).thenReturn(errorMessages);
		when(teamService.editTeam(Mockito.any())).thenReturn(response);

		EditTeamResponse editTeamResponse = teamController.editTeam(request);

		assertEquals("000", editTeamResponse.statusCode);

	}

	@Test
	public void testEditTeamFailure() {

		Set<String> errorMessages = new LinkedHashSet<String>();
		errorMessages.add("Please enter Type");

		EditTeamRequest request = new EditTeamRequest();

		// When
		when(teamValidation.validateEditTeamRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		EditTeamResponse response = teamController.editTeam(request);

		assertEquals("999", response.statusCode);

	}

}
