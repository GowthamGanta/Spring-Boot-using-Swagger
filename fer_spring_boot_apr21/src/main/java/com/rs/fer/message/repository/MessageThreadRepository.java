package com.rs.fer.message.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.message.entity.MessageThread;

public interface MessageThreadRepository extends JpaRepository<MessageThread, Integer>{

	Optional<MessageThread> findBySenderIdAndReceiverId(int senderId,int receiverId);
	
}
