package com.rs.fer.message.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Message {

	@Id
	@Column(name = "message_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String message;

	@Column
	private String date;

	@Column
	private String readFlag;

	@Column
	private int senderId;

	@Column(name="thread_id")
	private int messageThreadId;
	
	public Message() {

	}

	public Message(String message, int senderId, int messageThreadId) {

		this.message = message;
		this.senderId = senderId;
		this.messageThreadId = messageThreadId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getMessageThreadId() {
		return messageThreadId;
	}
	
	public void setMessageThreadId(int messageThreadId) {
		this.messageThreadId = messageThreadId;
	}
}
