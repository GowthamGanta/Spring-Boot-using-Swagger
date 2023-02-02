package com.rs.fer.message.service.impl;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;
import com.rs.fer.message.repository.MessageRepository;
import com.rs.fer.message.repository.MessageThreadRepository;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.response.SaveMessageResponse;
import com.rs.fer.message.util.MessageUtil;

@SpringBootTest
public class MessageServiceImplTest {

	@InjectMocks
	private MessageServiceImpl messageServiceImpl;

	@Mock
	MessageRepository messageRepository;

	@Mock
	MessageThreadRepository messageThreadRepository;

	@Mock
	MessageUtil messageUtil;

	@Test
	public void testSendMessage() {

		List<MessageThread> messageThreadObjects = new ArrayList<>();

		MessageThread messageThread = new MessageThread();
		messageThread.setMessageThreadId(1);

		SaveMessageRequest request = new SaveMessageRequest();
		request.setSenderId(1);
		request.setReceiverId(2);

		Message message = new Message();
		message.setId(1);

		// Mock
		when(messageThreadRepository.findBySenderIdAndReceiverId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(messageThreadObjects);

		when(messageUtil.loadSaveMessageThreadRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(messageThread);

		when(messageThreadRepository.save(Mockito.any())).thenReturn(messageThread);

		when(messageUtil.loadSaveMessageRequest(Mockito.any(), Mockito.anyInt())).thenReturn(message);

		when(messageRepository.save(Mockito.any())).thenReturn(message);

		SaveMessageResponse response = messageServiceImpl.sendMessage(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testSendMessageFailure() {

		List<MessageThread> messageThreadObjects = new ArrayList<>();

		MessageThread messageThread = new MessageThread();
		messageThread.setMessageThreadId(11);

		SaveMessageRequest request = new SaveMessageRequest();
		request.setSenderId(13);
		request.setReceiverId(22);

		Message message = new Message();
		//message.setId(10);

		// Mock
		when(messageThreadRepository.findBySenderIdAndReceiverId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(messageThreadObjects);

		when(messageUtil.loadSaveMessageThreadRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(messageThread);

		when(messageThreadRepository.save(Mockito.any())).thenReturn(messageThread);

		when(messageUtil.loadSaveMessageRequest(Mockito.any(), Mockito.anyInt())).thenReturn(message);

		when(messageRepository.save(Mockito.any())).thenReturn(message);

		SaveMessageResponse response = messageServiceImpl.sendMessage(request);

		assertEquals("001", response.statusCode);

	}

}
