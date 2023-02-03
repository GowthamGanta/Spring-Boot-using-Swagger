package com.rs.fer.message.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;
import com.rs.fer.message.repository.MessageRepository;
import com.rs.fer.message.repository.MessageThreadRepository;
import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.response.GetMessagesResponse;
import com.rs.fer.message.response.SaveMessageResponse;
import com.rs.fer.message.service.MessageService;
import com.rs.fer.message.util.MessageUtil;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageUtil messageUtil;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	MessageThreadRepository messageThreadRepository;

	@Override
	public SaveMessageResponse sendMessage(SaveMessageRequest request) {

		SaveMessageResponse response = null;
		Message message = null;
		MessageThread messageThread = null;

		// To get the message thread based on sender and receiver match
		List<MessageThread> messageThreadObjects = messageThreadRepository
				.findBySenderIdAndReceiverId(request.getSenderId(), request.getReceiverId());

		// To get the message thread based on receiver and sender match
		if (messageThreadObjects == null || messageThreadObjects.isEmpty()) {
			messageThreadObjects = messageThreadRepository.findBySenderIdAndReceiverId(request.getReceiverId(),
					request.getSenderId());
		}

		// If Message Thread is not found
		if (messageThreadObjects == null || messageThreadObjects.isEmpty()) {

			// load vo data into messageThread entity
			messageThread = messageUtil.loadSaveMessageThreadRequest(request, request.getSenderId(),
					request.getReceiverId());

			// save message thread
			messageThread = messageThreadRepository.save(messageThread);
		} else {
			messageThread = messageThreadObjects.get(0);
		}

		// load VO data into message entity
		message = messageUtil.loadSaveMessageRequest(request, messageThread.getMessageThreadId());

		// save message
		message = messageRepository.save(message);

		// response if success
		if (message.getId() > 0) {
			response = new SaveMessageResponse(HttpStatus.OK, "000", "Message sent successfully", null);

			response.setMessages(message);

		} else {
			// response if failure
			response = new SaveMessageResponse(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Message send is failed", null);

		}

		return response;
	}

	@Override
	public GetMessagesResponse getMessages(GetMessagesRequest request) {

		GetMessagesResponse response = null;
		
		List<Message> messageThreadObjects = messageRepository.findByMessageThreadId(request.getMessageTheradId());
		
		if(messageThreadObjects.isEmpty()) {
			
			response = new GetMessagesResponse(HttpStatus.OK, "001", "No Messages found", null);
			
		} else {
			
			response = new GetMessagesResponse(HttpStatus.OK, "000", "fetch Messages", null);
			response.setMessages(messageThreadObjects.get(request.getMessageTheradId()));
		
		}
		
		return response;
	}

}
