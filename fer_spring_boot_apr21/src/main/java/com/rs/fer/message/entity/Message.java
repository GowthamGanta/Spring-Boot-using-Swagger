package com.rs.fer.message.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private String readFalg;

	@Column
	private String senderId;

	public Message() {

	}

	public Message(String message, String senderId) {

		this.message = message;
		this.senderId = senderId;
		// this.messageThreadId = messageThreadId;
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

	public String getReadFalg() {
		return readFalg;
	}

	public void setReadFalg(String readFalg) {
		this.readFalg = readFalg;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	@OneToMany(targetEntity = MessageThread.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "thread_id", referencedColumnName = "mesageThread_id")
	private Set<MessageThread> messageThreadId;

	public void setMessageThreadId(Set<MessageThread> messageThreadId) {
		this.messageThreadId = messageThreadId;
	}

	public Set<MessageThread> getMessageThreadId() {
		return messageThreadId;
	}

}
