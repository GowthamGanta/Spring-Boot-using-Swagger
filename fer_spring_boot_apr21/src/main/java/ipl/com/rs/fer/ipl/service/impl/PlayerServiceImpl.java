package com.rs.fer.ipl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.entity.Team;
import com.rs.fer.ipl.repository.PlayerRepository;
import com.rs.fer.ipl.repository.TeamRepository;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;
import com.rs.fer.ipl.response.DeletePlayerResponse;
import com.rs.fer.ipl.response.GetPlayerResponse;
import com.rs.fer.ipl.response.GetPlayersResponse;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.response.UpdatePlayerResponse;
import com.rs.fer.ipl.service.PlayerService;
import com.rs.fer.ipl.util.PlayerUtil;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerUtil playerUtil;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	TeamRepository teamRepository;

	@Override
	public SavePlayerResponse savePlayer(SavePlayerRequest request) {
		SavePlayerResponse response = null;
		List<Player> players = playerRepository.findByJerseyNumber(request.getJerseyNumber());

		if (!CollectionUtils.isEmpty(players)) {
			// User already present
			response = new SavePlayerResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"Player is already find with the given jerserynumber", null);
			return response;
		}

		Optional<Team> teamobj = teamRepository.findById(request.getTeamId());

		if (teamobj.isPresent()) {
			Player player = playerUtil.loadSavePlayerRequestToPlayer(request);
			Team team = teamobj.get();
			team.getPlayers().add(player);
			player = playerRepository.save(player);
			response = new SavePlayerResponse(HttpStatus.OK, "000", "Player is succesfully saved", null);
			response.setPlayer(player);

		} else {
			// failure
			response = new SavePlayerResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Team is not found", null);
		}

		return response;
	}

	@Override
	public DeletePlayerResponse deletePlayer(int playerId) {

		DeletePlayerResponse response = null;

		// To Delete the Player based on playerId
		Optional<Player> playerObj = playerRepository.findById(playerId);
		if (!playerObj.isPresent()) {
			return new DeletePlayerResponse(HttpStatus.PRECONDITION_FAILED, "002", "Player Id is not found", null);
		} else {

			playerRepository.deleteById(playerId);
			// response if success
			response = new DeletePlayerResponse(HttpStatus.OK, "000", "Player is deleted successfully", null);
		}

		return response;
	}

	@Override
	public GetPlayersResponse getPlayers(Integer teamId) {
		GetPlayersResponse response = null;

		List<Player> players = new ArrayList<Player>();

		// To load the userObject based on userId
		Optional<Team> teamObj = teamRepository.findById(teamId);

		if (!teamObj.isPresent()) {

			response = new GetPlayersResponse(HttpStatus.OK, "000", "No Teams found", null);

		} else {

			List<Player> playersObj = playerRepository.findByTeamId(teamId);

			for (Player player : playersObj) {
				players.add(player);

			}
			// response.setGroupParticipants(users);

			response = new GetPlayersResponse(HttpStatus.OK, "000", "Fetch Participants", null);
			response.setPlayers(players);
		}
		return response;
	}

	@Override
	public GetPlayerResponse getPlayer(Integer playerId) {

		GetPlayerResponse response = null;

		Optional<Player> playerObj = playerRepository.findById(playerId);

		if (playerObj.isPresent()) {

			response = new GetPlayerResponse(HttpStatus.OK, "000", "player found", null);
			response.setPlayer(playerObj.get());
		} else {
			// failure

			response = new GetPlayerResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "player not found", null);

		}

		return response;

	}

	@Override
	public UpdatePlayerResponse updatePlayer(UpdatePlayerRequest request) {

		UpdatePlayerResponse response = null;

		// Player is present or not check
		List<Player> playerObj = playerRepository.findByPlayerId(request.getPlayerId());

		if (!playerObj.isEmpty()) {

			// load vo to bean
			Player player = playerUtil.laodUpdatePlayerRequestToPlayer(request);

			// save bean to database
			player = playerRepository.save(player);

			// load response
			// success
			response = new UpdatePlayerResponse(HttpStatus.OK, "000", "Player Updated successfully", null);
			response.setPlayerId(player);
		} else {
			// failure

			response = new UpdatePlayerResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Player Updating failed",
					null);

		}

		return response;
	}
}
