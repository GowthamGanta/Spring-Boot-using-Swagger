package com.rs.fer.ipl.util;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.request.SavePlayerRequest;

public interface PlayerUtil {

	Player loadSavePlayerRequestToPlayer(SavePlayerRequest request);

}