package com.rs.fer.message.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMessagesRequest {

	private int messageTheradId;
	
	private int userdId;
}
