package com.rs.fer.message.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MessageThread {

	@Id
	@Column(name = "messageThread_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageThreadId;

	@Column
	private int senderId;

	@Column
	private int reciverId;

	public int getMessageThreadId() {
		return messageThreadId;
	}

	public void setMessageThreadId(int messageThreadId) {
		this.messageThreadId = messageThreadId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReciverId() {
		return reciverId;
	}

	public void setReciverId(int reciverId) {
		this.reciverId = reciverId;
	}

}
