package com.rs.fer.ipl.service;

import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.response.SavePlayerResponse;

public interface PlayerService {

	SavePlayerResponse SavePlayer(SavePlayerRequest request);

}