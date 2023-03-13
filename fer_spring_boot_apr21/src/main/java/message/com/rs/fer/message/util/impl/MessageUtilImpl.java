package com.rs.fer.message.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;
import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.request.UpdateMessageRequest;
import com.rs.fer.message.util.MessageUtil;
import com.rs.fer.util.DateUtil;

@Component
public class MessageUtilImpl implements MessageUtil {

	@Override
	public Message loadSaveMessageRequest(SaveMessageRequest request, int messageThreadId) {

		Message message = new Message();

		message.setMessage(request.getMessage());
		message.setDate(DateUtil.getCurrentDate());
		message.setSenderId(request.getSenderId());
		message.setMessageThreadId(messageThreadId);
		message.setReadFlag("N");

		return message;
	}

	@Override
	public MessageThread loadSaveMessageThreadRequest(SaveMessageRequest request, int senderId, int receiverId) {

		MessageThread messageThread = new MessageThread();

		messageThread.setSenderId(request.getSenderId());
		messageThread.setReceiverId(request.getReceiverId());

		return messageThread;
	}
}
