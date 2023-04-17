package com.rs.fer.message.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveMessageRequest {

	private String message;
	
	private int senderId;
	
	private int receiverId;

}
