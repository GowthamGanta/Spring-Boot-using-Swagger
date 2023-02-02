package com.rs.fer.message.service;

import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.response.GetMessagesResponse;
import com.rs.fer.message.response.SaveMessageResponse;

public interface MessageService {

	SaveMessageResponse sendMessage(SaveMessageRequest request);
	
	GetMessagesResponse getMessages(GetMessagesRequest request);
	
}
