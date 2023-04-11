package com.rs.fer.ipl.service;

import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;
import com.rs.fer.ipl.response.DeletePlayerResponse;
import com.rs.fer.ipl.response.GetPlayerResponse;
import com.rs.fer.ipl.response.GetPlayersResponse;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.response.UpdatePlayerResponse;

public interface PlayerService {

	SavePlayerResponse savePlayer(SavePlayerRequest request);

	DeletePlayerResponse deletePlayer(int playerId);

	GetPlayersResponse getPlayers(Integer teamId);

	GetPlayerResponse getPlayer(Integer playerId);

	UpdatePlayerResponse updatePlayer(UpdatePlayerRequest request);
}