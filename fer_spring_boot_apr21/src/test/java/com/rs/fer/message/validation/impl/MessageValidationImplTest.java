package com.rs.fer.message.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
@SpringBootTest
public class MessageValidationImplTest {

	@InjectMocks
	private MessageValidationImpl messageValidationImpl;

	@Test
	public void testvalidateSaveMessageRequest() {

		SaveMessageRequest request = new SaveMessageRequest();

		request.setMessage("Hi");
		request.setReceiverId(4);
		request.setSenderId(3); 

		Set<String> errorMessages = messageValidationImpl.validateSaveMessageRequest(request); 

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateSaveMessageRequestFailure() {

		SaveMessageRequest request = new SaveMessageRequest();

		//request.setMessage("Hi");
		request.setReceiverId(4);
		request.setSenderId(3);

		Set<String> errorMessages = messageValidationImpl.validateSaveMessageRequest(request);

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidateGetMessagesRequest() {

		GetMessagesRequest request = new GetMessagesRequest();

		request.setMessageTheradId(1);
		request.setUserdId(1);

		Set<String> errorMessages = messageValidationImpl.validateGetMessageRequest(request); 

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test
	public void testvalidateGetMessagesRequestFailure() {

		GetMessagesRequest request = new GetMessagesRequest();

		//request.setMessageTheradId(1);
		request.setUserdId(1);

		Set<String> errorMessages = messageValidationImpl.validateGetMessageRequest(request); 

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidateDeleteMessageRequest() {

		DeleteMessageRequest request = new DeleteMessageRequest();

		request.setId(1);
		request.setUserId(4);

		Set<String> errorMessages = messageValidationImpl.validateDeleteMessageRequest(request); 

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testvalidateDeleteMessagesRequestFailure() {

		DeleteMessageRequest request = new DeleteMessageRequest();

		//request.setId(1);
		request.setUserId(4);

		Set<String> errorMessages = messageValidationImpl.validateDeleteMessageRequest(request); 

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	

}
