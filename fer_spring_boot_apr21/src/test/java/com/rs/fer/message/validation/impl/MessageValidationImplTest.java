package com.rs.fer.message.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;

public class MessageValidationImplTest {

	@InjectMocks
	private MessageValidationImpl messageValidationImpl;

	@Test
	public void testvalidateSaveMessageRequest() {

		SaveMessageRequest request = new SaveMessageRequest();

		request.setMessage("Hi");
		request.setReceiverId(4);
		request.setSenderId(3); 

		Set<String> errorMessages = messageValidationImpl.validateSaveMessage(request); 

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateSaveMessageRequestFailure() {

		SaveMessageRequest request = new SaveMessageRequest();

		request.setMessage("hi");
		request.setReceiverId(3);
		request.setSenderId(4);

		Set<String> errorMessages = messageValidationImpl.validateSaveMessage(request);

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidateGetMessagesRequest() {

		GetMessagesRequest request = new GetMessagesRequest();

		request.setMessageTheradId(1);
		request.setUserdId(1);

		Set<String> errorMessages = messageValidationImpl.validateGetMessages(request); 

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateGetMessagesRequestFailure() {

		GetMessagesRequest request = new GetMessagesRequest();

		request.setMessageTheradId(1);
		//request.setUserdId(1);

		Set<String> errorMessages = messageValidationImpl.validateGetMessages(request); 

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	

}
