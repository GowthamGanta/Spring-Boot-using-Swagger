package com.rs.fer.message.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.request.UpdateMessageRequest;
import com.rs.fer.message.response.DeleteMessageResponse;
import com.rs.fer.message.response.GetMessagesResponse;
import com.rs.fer.message.response.SaveMessageResponse;
import com.rs.fer.message.response.UpdateMessageResponse;
import com.rs.fer.message.service.MessageService;
import com.rs.fer.message.validation.MessageValidation;

@SpringBootTest
public class MessageControllerTest {

	@InjectMocks
	private MessageController messageController;

	@Mock
	MessageValidation messageValidation;

	@Mock
	MessageService messageService;

	@Test
	public void testSendMessage() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		SaveMessageRequest request = new SaveMessageRequest();
		SaveMessageResponse response = new SaveMessageResponse(HttpStatus.OK, "000", "", null);

		// when
		when(messageValidation.validateSaveMessageRequest(Mockito.any())).thenReturn(errorMessages);
		when(messageService.sendMessage(Mockito.any())).thenReturn(response);

		// Then
		SaveMessageResponse saveResponse = messageController.sendMessage(request);

		assertEquals("000", saveResponse.statusCode);

	}

	@Test
	public void testSendMessageFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please entre message");

		SaveMessageRequest request = new SaveMessageRequest();

		// when
		when(messageValidation.validateSaveMessageRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		SaveMessageResponse response = messageController.sendMessage(request);

		assertEquals("999", response.statusCode);

	}

	@Test
	public void testGetMessages() {

		Set<String> errorMessages = new LinkedHashSet<>();

		GetMessagesRequest request = new GetMessagesRequest();
		GetMessagesResponse response = new GetMessagesResponse(HttpStatus.OK, "000", "", null);

		when(messageValidation.validateGetMessageRequest(Mockito.any())).thenReturn(errorMessages);
		when(messageService.getMessages(Mockito.any())).thenReturn(response);

		GetMessagesResponse getResponse = messageController.getMessages(request);

		assertEquals("000", getResponse.statusCode);
	}

	@Test
	public void testGetMessagesFailure() {

		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please entre messageThreadId");

		GetMessagesRequest request = new GetMessagesRequest();

		when(messageValidation.validateGetMessageRequest(Mockito.any())).thenReturn(errorMessages);

		GetMessagesResponse response = messageController.getMessages(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testDeleteMessage() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		DeleteMessageRequest request = new DeleteMessageRequest();
		DeleteMessageResponse response = new DeleteMessageResponse(HttpStatus.OK, "000", "", null);

		// when
		when(messageValidation.validateDeleteMessageRequest(Mockito.any())).thenReturn(errorMessages);
		when(messageService.deleteMessage(Mockito.any())).thenReturn(response);

		// Then
		DeleteMessageResponse saveResponse = messageController.deleteMessages(request);

		assertEquals("000", saveResponse.statusCode);

	}

	@Test
	public void testDeleteMessageFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please entre id");

		DeleteMessageRequest request = new DeleteMessageRequest();

		// when
		when(messageValidation.validateDeleteMessageRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		DeleteMessageResponse response = messageController.deleteMessages(request);

		assertEquals("999", response.statusCode);

	}

	@Test
	public void testUpdateMessage() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		UpdateMessageRequest request = new UpdateMessageRequest();
		UpdateMessageResponse response = new UpdateMessageResponse(HttpStatus.OK, "000", "", null);

		// when
		when(messageValidation.validateUpdateMessageRequest(Mockito.any())).thenReturn(errorMessages);
		when(messageService.updateMessage(Mockito.any())).thenReturn(response);

		// Then
		UpdateMessageResponse saveResponse = messageController.updateMessage(request);

		assertEquals("000", saveResponse.statusCode);

	}

	@Test
	public void testUpdateMessageFailure() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter id");

		UpdateMessageRequest request = new UpdateMessageRequest();

		// when
		when(messageValidation.validateUpdateMessageRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		UpdateMessageResponse response = messageController.updateMessage(request);

		assertEquals("999", response.statusCode);

	}
}
