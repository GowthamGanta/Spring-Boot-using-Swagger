package com.rs.fer.message.request;

import java.util.Set;

import com.rs.fer.message.entity.Message;

public class SaveMessageRequest {

	private String message;
	private int senderId;
	private int receiverId;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getMessageThreadId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<Message> getMessages() {
		// TODO Auto-generated method stub
		return null;
	}

}
