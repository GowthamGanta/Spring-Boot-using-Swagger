package com.rs.fer.ipl.service;

import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.response.DeletePlayerResponse;
import com.rs.fer.ipl.response.GetPlayersResponse;
import com.rs.fer.ipl.response.SavePlayerResponse;

public interface PlayerService {

	SavePlayerResponse savePlayer(SavePlayerRequest request);

	DeletePlayerResponse deletePlayer(int playerId);
	
	GetPlayersResponse getPlayers(Integer teamId);
}