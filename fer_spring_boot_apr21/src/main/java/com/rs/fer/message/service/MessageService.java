package com.rs.fer.message.service;

import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.request.UpdateMessageRequest;
import com.rs.fer.message.response.DeleteMessageResponse;
import com.rs.fer.message.response.GetMessagesResponse;
import com.rs.fer.message.response.SaveMessageResponse;
import com.rs.fer.message.response.UpdateMessageResponse;

public interface MessageService {

	SaveMessageResponse sendMessage(SaveMessageRequest request);
	
	GetMessagesResponse getMessages(GetMessagesRequest request);

	DeleteMessageResponse deleteMessage(DeleteMessageRequest request);

	UpdateMessageResponse updateMessage(UpdateMessageRequest request);

}
