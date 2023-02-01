package com.rs.fer.message.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;

public interface MessageRepository extends JpaRepository<Message, Integer>{

	List<Message> findByMessageThreadId(int messageThreadId);

	List<MessageThread> save(MessageThread messageThread);
	
}
