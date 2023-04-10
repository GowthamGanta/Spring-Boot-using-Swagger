package com.rs.fer.ipl.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.ipl.request.DeleteTeamRequest;
import com.rs.fer.ipl.request.GetTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;
import com.rs.fer.ipl.response.DeleteTeamResponse;
import com.rs.fer.ipl.response.GetTeamResponse;
import com.rs.fer.ipl.response.SaveTeamResponse;
import com.rs.fer.ipl.service.TeamService;
import com.rs.fer.ipl.validation.TeamValidation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TeamController {

	@Autowired
	TeamService teamService;

	@Autowired
	TeamValidation teamValidation;

	@PostMapping("ipl/saveTeam")
	public SaveTeamResponse saveTeam(@RequestBody SaveTeamRequest request) {

		SaveTeamResponse response = null;
		Set<String> errorMessages = teamValidation.validateSaveTeamRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveTeamResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = teamService.saveTeam(request);

		}

		return response;
	}

	@GetMapping("/ipl/getTeam/{teamId}")

	public GetTeamResponse getTeam(@PathVariable("teamId") Integer teamId) {

		GetTeamResponse response = null;

		Set<String> errorMessages = teamValidation.validateGetTeamRequest(teamId);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetTeamResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = teamService.getTeam(teamId);
		}

		return response;
	}
	
	@DeleteMapping("/ipl/deleteTeamId")
	public DeleteTeamResponse deleteTeam(@RequestBody DeleteTeamRequest request) {
		DeleteTeamResponse response = null;
		Set<String> errorMessages = teamValidation.validateDeleteTeamRequest(request);
		
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteTeamResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		}else {
			response = teamService.deleteTeam(request);
		}
		
		return response;
		
		
	}

}