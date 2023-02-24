package com.rs.fer.message.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;
import com.rs.fer.response.AbstractResponse;

public class UpdateMessageResponse extends AbstractResponse {

	public UpdateMessageResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {

		super(status, statusCode, message, errorMessages);

		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.errorMessages = errorMessages;

	}

	private Message messages;

	public Message getMessages() {
		return messages;
	}

	public void setMessages(Message messages) {
		this.messages = messages;
	}

	public void setMessages(MessageThread messageThread) {
		// TODO Auto-generated method stub
		
	}

}
