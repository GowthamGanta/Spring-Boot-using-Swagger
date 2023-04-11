package com.rs.fer.ipl.util;

import com.rs.fer.ipl.entity.Player;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;

public interface PlayerUtil {

	Player loadSavePlayerRequestToPlayer(SavePlayerRequest request);

	Player laodUpdatePlayerRequestToPlayer(UpdatePlayerRequest request);

}