package com.rs.fer.message.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.message.entity.MessageThread;

public interface MessageThreadRepository extends JpaRepository<MessageThread, Integer>{

	List<MessageThread> findBySenderIdAndReceiverId(int senderId,int receiverId);
	
	List<MessageThread> findByUserIdAndSenderId(int userId,int senderId);
	
	//List<MessageThread> FindByEmail(String email);
	
	
}
