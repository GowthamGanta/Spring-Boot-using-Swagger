package com.rs.fer.ipl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.repository.PlayerRepository;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.response.SavePlayerResponse;
import com.rs.fer.ipl.service.PlayerService;
import com.rs.fer.ipl.util.PlayerUtil;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerUtil playerUtil;

	@Autowired
	PlayerRepository playerRepository;

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

		// load vo to bean
		Player player = playerUtil.loadSavePlayerRequestToPlayer(request);

		// save bean to database
		player = playerRepository.save(player);

		// load response
		if (player.getPlayerId() > 0) {
			// success
			response = new SavePlayerResponse(HttpStatus.OK, "000", "Player is succesfully saved", null);
			response.setPlayer(player);
		} else {
			// failure
			response = new SavePlayerResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Player saved is failed", null);
		}

		return response;
	}
}