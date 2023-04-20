package com.rs.fer.ipl.util.impl;

import org.springframework.stereotype.Component;
import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.mapper.SavePlayerRequestMapper;
import com.rs.fer.ipl.mapper.UpdatePlayerRequestMapper;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;
import com.rs.fer.ipl.util.PlayerUtil;
import com.rs.fer.util.DateUtil;

@Component
public class PlayerUtilImpl implements PlayerUtil {

	@Override
	public Player loadSavePlayerRequestToPlayer(SavePlayerRequest request) {

		Player player = SavePlayerRequestMapper.MAPPER.mapToPlayer(request);

		player.setCreated(DateUtil.getCurrentDate());
		player.setUpdated(DateUtil.getCurrentDate());

		return player;
	}

	@Override
	public Player laodUpdatePlayerRequestToPlayer(UpdatePlayerRequest request) {

		Player player = UpdatePlayerRequestMapper.MAPPER.mapToPlayer(request);
		player.setCreated(DateUtil.getCurrentDate());
		player.setUpdated(DateUtil.getCurrentDate());

		return player;
	}

}
