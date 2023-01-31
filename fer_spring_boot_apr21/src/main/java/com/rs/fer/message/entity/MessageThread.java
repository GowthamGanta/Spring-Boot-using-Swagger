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
public class MessageThread {

	@Id
	@Column(name = "messageThread_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageThreadId;

	@Column
	private int senderId;

	@Column
	private int receiverId;

	public MessageThread() {

	}

	public MessageThread(int senderId, int receiverId) {

		this.senderId = senderId;
		this.receiverId = receiverId;
	}

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

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	@OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "message_id", referencedColumnName = "messageThread_id")
	private Set<Message> messages;

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
}
