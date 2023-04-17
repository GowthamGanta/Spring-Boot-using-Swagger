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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

	@Column
	private int userId;

	public MessageThread() {

	}

	public MessageThread(int senderId, int receiverId, int userId) {

		this.senderId = senderId;
		this.receiverId = receiverId;
		this.userId = userId;

	}

	@OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "thread_id", referencedColumnName = "messageThread_id")
	private Set<Message> messages;
	
}
