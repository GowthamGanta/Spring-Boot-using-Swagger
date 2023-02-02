package com.rs.fer.message.service;

import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.response.SaveMessageResponse;

public interface MessageService {

	SaveMessageResponse sendMessage(SaveMessageRequest request);
	
}
