package com.rs.fer.message.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;
import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.SaveMessageRequest;

@SpringBootTest
public class MessageUtilImplTest {

	@InjectMocks
	private MessageUtilImpl messageUtilImpl;

	@Test
	public void testUtilLoadMessageRequest() {

		SaveMessageRequest request = new SaveMessageRequest();

		request.setMessage("Hi");
		request.setSenderId(1);

		Message errorMessage = messageUtilImpl.loadSaveMessageRequest(request, 1);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != errorMessage.getSenderId() && null != errorMessage.getMessage());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testUtilLoadMessageRequestFailure() {

		SaveMessageRequest request = new SaveMessageRequest();

		//request.setMessage("hiAndBye");
		request.setSenderId(1); 

		Message errorMessage = messageUtilImpl.loadSaveMessageRequest(request, 1);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = (0 != errorMessage.getSenderId() && null != errorMessage.getMessage());

		assertEquals(isExpectedEmpty, isActualEmpty); 

	}

	@Test
	public void loadSaveMessageThreadRequest() {

		SaveMessageRequest request = new SaveMessageRequest();
		
		request.setSenderId(1);
		request.setReceiverId(2);

		MessageThread errorMessage = messageUtilImpl.loadSaveMessageThreadRequest(request, 1, 2);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != errorMessage.getSenderId() && 0 != errorMessage.getReceiverId());

		assertEquals(isExpectedEmpty, isActualEmpty); 

	}

	@Test
	public void loadSaveMessageThreadRequestFailure() {

		SaveMessageRequest request = new SaveMessageRequest();

		//request.setSenderId(1);
		request.setReceiverId(2); 

		MessageThread errorMessage = messageUtilImpl.loadSaveMessageThreadRequest(request, 1, 2);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = (0 != errorMessage.getSenderId() && 0 != errorMessage.getReceiverId());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void loadDeleteMessageThreadRequest() {

		DeleteMessageRequest request = new DeleteMessageRequest();
		
		request.setId(1);
		request.setUserId(2);

		Message errorMessage = messageUtilImpl.loadDeleteMessageRequest(request, 1);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != errorMessage.getId() && 0 != errorMessage.getSenderId());

		assertEquals(isExpectedEmpty, isActualEmpty); 

	}
	
	@Test
	public void loadDeleteMessageThreadRequestFailure() {

		DeleteMessageRequest request = new DeleteMessageRequest();
		
		//request.setId(1);
		request.setUserId(2);

		Message errorMessage = messageUtilImpl.loadDeleteMessageRequest(request, 1);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = (0 != errorMessage.getId() && 0 != errorMessage.getSenderId());

		assertEquals(isExpectedEmpty, isActualEmpty); 

	}
}
