package com.rs.fer.ipl.response;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.rs.fer.ipl.entity.Team;

@Component
public class GetTeamsResponse {
	
	    private HttpStatus status;
	    public String statusCode;
	    private String message;
	    private String errorMessages;
	    private List<Team> teams;
		public void setTeams(List<Team> teamObj) {
			
		}
		public Object getStatus() {
			// TODO Auto-generated method stub
			return null;
		}
		public Object getTeams() {
			// TODO Auto-generated method stub
			return null;
		}
		public Object getMessage() {
			// TODO Auto-generated method stub
			return null;
		}
	}

