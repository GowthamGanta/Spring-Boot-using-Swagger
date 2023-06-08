package com.rs.fer.ipl.util;

import com.rs.fer.ipl.entity.IPLMatch;
import com.rs.fer.ipl.request.EditMatchRequest;
import com.rs.fer.ipl.request.SaveMatchRequest;

public interface MatchUtil {
	IPLMatch loadSaveMatchRequestToMatch(SaveMatchRequest request);

	IPLMatch loadEditMatchRequestToMatch(EditMatchRequest request);

}
