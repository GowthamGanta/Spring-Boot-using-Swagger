package com.rs.fer.message.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
