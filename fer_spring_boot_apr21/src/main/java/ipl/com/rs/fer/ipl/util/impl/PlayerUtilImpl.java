package com.rs.fer.ipl.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.util.PlayerUtil;
import com.rs.fer.util.DateUtil;

@Component
public class PlayerUtilImpl implements PlayerUtil {

	@Override
	public Player loadSavePlayerRequestToPlayer(SavePlayerRequest request) {

		Player player = new Player(); 

		player.setFirstName(request.getFirstName());
		player.setMiddleName(request.getMiddleName());
		player.setLastName(request.getLastName());
		player.setGender(request.getGender());
		player.setDob(request.getDob());
		player.setRole(request.getRole());
		player.setSpecilization(request.getSpecilization());
		player.setJerseyNumber(request.getJerseyNumber());

		player.setCreated(DateUtil.getCurrentDate());
		player.setUpdated(DateUtil.getCurrentDate());

		return player;
	}

}
